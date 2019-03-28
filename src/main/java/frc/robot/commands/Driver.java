package frc.robot.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.motors.*;
import frc.robot.subsystems.sensors.shockwaveEncoder;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.subsystems.shockwaveSolenoid;
import frc.robot.Dashboard;
import frc.robot.RobotMap;
import frc.robot.subsystems.sensors.colorSensor;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class Driver {
    public static final ADIS16448_IMU imu = new ADIS16448_IMU();
    public boolean straight = false;
    public static double currentZAngle = 0;
    public static String targetDirection = "NODIRECTION";
    public static double targetZAngle = -1;
    public static double angle = 0;
    private sparkMotor kLeftDrive;
    private sparkMotor kRightDrive;
    private victorMotor kLeftClimbDrive;
    private victorMotor kRightClimbDrive;
    private victorMotor kClimbPivot;
    private shockwaveXbox cDriveXbox;
    private shockwaveSolenoid pBallIntake;
    private shockwaveEncoder sClimbEncoder;
    private double cDriveLeftY;
    private double cDriveRightX;
    private double sClimbEncoderCount;
    private boolean climbMode;
    private boolean toggleIntake;
    private boolean cDriveAButton;
    private boolean cDriveBButton;
    private boolean cDriveStartButton;
    private boolean cDriveBackButton;
    private double drivemodetoggle;
    public static colorSensor colorsensor;
  
    public Driver(){
        kLeftDrive = new sparkMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new sparkMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        kLeftClimbDrive = new victorMotor(RobotMap.ClimbDriveLeft, RobotMap.LeftClimbDrivePos, RobotMap.LeftClimbDriveNeg);
        kRightClimbDrive = new victorMotor(RobotMap.ClimbDriveRight, RobotMap.RightClimbDrivePos, RobotMap.RightClimbDriveNeg);
        kClimbPivot = new victorMotor(RobotMap.ClimbPivotPort, RobotMap.ClimbPivotPos, RobotMap.ClimbPivotNeg);
        sClimbEncoder = new shockwaveEncoder(RobotMap.sClimbEncoder1, RobotMap.sClimbEncoder2);
        pBallIntake = new shockwaveSolenoid(RobotMap.pIntakeBallF, RobotMap.pIntakeBallR);
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);
        colorsensor = new colorSensor(I2C.Port.kOnboard);
        sClimbEncoder.resetEncoder();
    }

    private void pBallForward(){
        pBallIntake.forward();
    }
    private void pBallReverse(){
        pBallIntake.reverse();
    }
    private void pBallOff(){
        pBallIntake.off();
    }
    public void BallControl(final int mode){
        if(mode == 1){
            pBallForward();
        }else if(mode == 0){
            pBallReverse();
        }else{
            pBallOff();
        }
    }

    private void drivebaseControl() {
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveRightX = cDriveXbox.getRightX();
        if (cDriveLeftY == 0) {
            kLeftDrive.rotateMotor(cDriveRightX);
            kRightDrive.rotateMotor(cDriveRightX);
        } else {
            kLeftDrive.rotateMotor(cDriveLeftY + cDriveRightX);
            kRightDrive.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }
    private void climbmotorControl(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveRightX = cDriveXbox.getRightX();
        sClimbEncoderCount = sClimbEncoder.getCount();
        Dashboard.getInstance().putNumber(false, "ClimbPivot Encoder Count", sClimbEncoderCount);
        // Put the climb pivot thing here 
        if (cDriveLeftY == 0) {
            kLeftClimbDrive.rotateMotor(cDriveRightX);
            kRightClimbDrive.rotateMotor(cDriveRightX);
        } else {
            kLeftClimbDrive.rotateMotor(cDriveLeftY + cDriveRightX);
            kRightClimbDrive.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }
    private void intakeToggle() {
        cDriveAButton = cDriveXbox.getAbutton();
        cDriveBButton = cDriveXbox.getBbutton();
        if((cDriveAButton == true)&&(cDriveBButton == false)){
            toggleIntake = true;
        }else if((cDriveAButton == false)&&(cDriveBButton == true)){
            toggleIntake = false;
        }
        if(toggleIntake = true){
            BallControl(1);
        }else if(toggleIntake = false){
            BallControl(0);
        }else{
            BallControl(2);
        }
    }
    private void climbToggle(){
        cDriveStartButton = cDriveXbox.getStartButton();
        cDriveBackButton = cDriveXbox.getBackButton();
        if((cDriveStartButton == true)&&(cDriveBackButton == false)){
            climbMode = true;
        }else if((cDriveStartButton == false)&&(cDriveBackButton == true)){
            climbMode = false;
        }
    }

    public void IMUReset() {
        imu.calibrate();
        imu.reset();
    }

    private void DPadTurn() {
        colorsensor.read();
        angle = (((imu.getAngleZ() + 36000) % 360));
        Dashboard.getInstance().putString(false, "DPad Value", cDriveXbox.getDPadDirection().toString());
        Dashboard.getInstance().putNumber(false, "Current-Z", angle);
        targetDirection = cDriveXbox.getDPadDirection().toString();

        if (targetDirection == "NODIRECTION") {
            targetZAngle = -1;
        } else if (targetDirection == "UP") {
            targetZAngle = 0;
        } else if (targetDirection == "UP_RIGHT") {
            targetZAngle = 45;
        } else if (targetDirection == "RIGHT") {
            targetZAngle = 90;
        } else if (targetDirection == "DOWN_RIGHT") {
            targetZAngle = 135;
        } else if (targetDirection == "DOWN") {
            targetZAngle = 180;
        } else if (targetDirection == "DOWN_LEFT") {
            targetZAngle = 225;
        } else if (targetDirection == "LEFT") {
            targetZAngle = 270;
        } else if (targetDirection == "UP_LEFT") {
            targetZAngle = 315;
        }

        currentZAngle = SmartDashboard.getNumber("Current-Z", -1);
        Dashboard.getInstance().putNumber(false, "test", targetZAngle);
        if (targetZAngle == -1) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();

        } else {
            if (targetZAngle != -1) {

                if (targetZAngle == 0) {
                    if ((currentZAngle >= 350) || (currentZAngle <= 10)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle) <= 180) {
                        kLeftDrive.rotateCounterClockwise(0.5);
                        kRightDrive.rotateCounterClockwise(0.5);
                    } else {
                        kLeftDrive.rotateClockwise(0.5);
                        kRightDrive.rotateClockwise(0.5);
                    }
                } else if (targetZAngle == 45) {
                    if ((currentZAngle >= 40) && (currentZAngle <= 50)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                        System.out.println("STOP UP UR");
                    } else if ((currentZAngle >= 225) || (currentZAngle < 40)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                } else if (targetZAngle == 90) {
                    if ((currentZAngle >= 85) && (currentZAngle <= 95)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle >= 270) || (currentZAngle < 85)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                } else if (targetZAngle == 135) {
                    if ((currentZAngle >= 130) && (currentZAngle <= 140)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle >= 315) || (currentZAngle < 130)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                } else if (targetZAngle == 180) {
                    if ((currentZAngle >= 175) && (currentZAngle <= 185)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle < 175)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                } else if (targetZAngle == 225) {
                    if ((currentZAngle >= 215) && (currentZAngle <= 235)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle > 45) && (currentZAngle < 220)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                } else if (targetZAngle == 270) {
                    if ((currentZAngle >= 260) && (currentZAngle <= 280)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle > 90) && (currentZAngle < 260)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                } else if (targetZAngle == 315) {
                    if ((currentZAngle >= 305) && (currentZAngle <= 325)) {
                        kLeftDrive.stopMotor();
                        kRightDrive.stopMotor();
                    } else if ((currentZAngle > 135) && (currentZAngle < 320)) {
                        kLeftDrive.rotateCounterClockwise(-0.5);
                        kRightDrive.rotateCounterClockwise(-0.5);
                    } else {
                        kLeftDrive.rotateClockwise(-0.5);
                        kRightDrive.rotateClockwise(-0.5);
                    }

                }
            }
        }

        Dashboard.getInstance().putNumber(false, "Red", colorsensor.getRed());
        Dashboard.getInstance().putNumber(false, "Blue", colorsensor.getGreen());
        Dashboard.getInstance().putNumber(false, "Green", colorsensor.getBlue());
        Dashboard.getInstance().putNumber(false, "Proximity", colorsensor.getProx());

        if ((colorsensor.getRed() >= 10) && (colorsensor.getGreen() >= 7) && (colorsensor.getGreen() >= 10)) {
            Dashboard.getInstance().putBoolean(false, "Line Detected", true);
        } else {
            Dashboard.getInstance().putBoolean(false, "Line Detected", false);
        }
    }

    public void Drive() {
        climbToggle();
        drivemodetoggle = cDriveXbox.getRightTrigger();
        if(climbMode == true){
            climbmotorControl();
        }else{
            if(drivemodetoggle >= 0.1){
                DPadTurn();
            }else{
                drivebaseControl();
                intakeToggle();
            }
        }
    }
}