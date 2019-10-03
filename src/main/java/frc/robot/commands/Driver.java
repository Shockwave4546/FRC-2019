package frc.robot.commands;

//import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.motors.*;
//import frc.robot.subsystems.sensors.shockwaveEncoder;
import frc.robot.controllers.shockwaveXbox;
//import frc.robot.subsystems.shockwaveSolenoid;
import frc.robot.Dashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
//import frc.robot.subsystems.sensors.colorSensor;

//import com.analog.adis16448.frc.ADIS16448_IMU;

public class Driver {
    //public static final ADIS16448_IMU imu = new ADIS16448_IMU();
    //public boolean straight = false;
    //public static double currentZAngle = 0;
    //public static String targetDirection = "NODIRECTION";
    //public static double targetZAngle = -1;
    //public static double angle = 0;
    private sparkMotor kLeftDrive;
    private sparkMotor kRightDrive;
    //private victorMotor kLeftClimbDrive;
    //private victorMotor kRightClimbDrive;
    //private victorMotor kClimbPivot;
    private shockwaveXbox cDriveXbox;
    private double cDriveLeftY;
    private double cDriveRightX;
    //private double cDriveRightY;
    //private boolean cDriveAButton;
    private boolean cDriveAPress;
    //private boolean cDriveBButton;
    //private boolean cDriveXButton;
    //private boolean cDriveYButton;
    private boolean cDriveYPress;
    //private boolean cDriveStartButton;
    private boolean cDriveStartPressed;
    //private boolean cDriveBackButton;
    private boolean cDriveLeftBumper;
    //private shockwaveEncoder sClimbEncoder;
    //private double sClimbEncoderCount;
    private boolean climbMode;
    private boolean toggleIntake;
    private double drivemodetoggle;
    private boolean toggleClimb;
    private boolean toggleClimb2;
    private boolean toggleOverdrive;
    //public static colorSensor colorsensor;
    public void BallControl(final int mode){
        if(mode == 1){
            Robot.pneumatics.BallOut();
        }else if(mode == 0){
            Robot.pneumatics.BallIn();
        }else{
            Robot.pneumatics.BallOff();
        }
    }
    public void ClimbControl(final int mode){
        if(mode == 1){
            Robot.pneumatics.ClimbOut();
        }else if(mode == 0){
            Robot.pneumatics.ClimbIn();
        }else{
            Robot.pneumatics.ClimbOff();
        }
    }
    public void Climb2Control(final int mode){
        if(mode == 1){
            Robot.pneumatics.Climb2Out();
        }else if(mode == 0){
            Robot.pneumatics.Climb2In();
        }else{
            Robot.pneumatics.Climb2Off();
        }
    }
    public Driver(){
        kLeftDrive = new sparkMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new sparkMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        //kLeftClimbDrive = new victorMotor(RobotMap.ClimbDriveLeft, RobotMap.LeftClimbDrivePos, RobotMap.LeftClimbDriveNeg);
        //kRightClimbDrive = new victorMotor(RobotMap.ClimbDriveRight, RobotMap.RightClimbDrivePos, RobotMap.RightClimbDriveNeg);
        //kClimbPivot = new victorMotor(RobotMap.ClimbPivotPort, RobotMap.ClimbPivotPos, RobotMap.ClimbPivotNeg);
        //sClimbEncoder = new shockwaveEncoder(RobotMap.sClimbEncoder1, RobotMap.sClimbEncoder2);
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);
        //colorsensor = new colorSensor(I2C.Port.kOnboard);
        climbMode = false;
        BallControl(2);
        ClimbControl(2);
        Climb2Control(2);
        //sClimbEncoder.resetEncoder();
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
    private void MAXIMUM_OVERDRIVE(){
        cDriveLeftBumper = cDriveXbox.getLeftBumper();
        if(cDriveLeftBumper == true){
            toggleOverdrive = true;
            kLeftDrive.setMotorSpeeds(1, 1);
            kRightDrive.setMotorSpeeds(1, 1);
        }else if((cDriveLeftBumper == false) &&(toggleOverdrive == true)){
            toggleOverdrive = false;
            kLeftDrive.resetMotorSpeeds();
            kRightDrive.resetMotorSpeeds();
        }
        Dashboard.getInstance().putBoolean(false, "Maximum Overdrive", toggleOverdrive);
    }
    private void climbmodeControl(){
        /*cDriveLeftY = cDriveXbox.getLeftY();
        cDriveRightY = cDriveXbox.getRightY();
        sClimbEncoderCount = sClimbEncoder.getCount();
        Dashboard.getInstance().putNumber(false, "ClimbPivot Encoder Count", sClimbEncoderCount);
        if (cDriveLeftY == 0) {
            kLeftClimbDrive.rotateMotor(0);
            kRightClimbDrive.rotateMotor(0);
        } else {
            kLeftClimbDrive.rotateMotor((cDriveLeftY) * -1);
            kRightClimbDrive.rotateMotor((cDriveLeftY) * -1);
        }
        if (cDriveRightY == 0) {
            kClimbPivot.rotateMotor(0);
        } else {
            kClimbPivot.rotateMotor((cDriveRightY) * -1);
        }*/
        //cDriveAButton = cDriveXbox.getAbutton();
        cDriveAPress = cDriveXbox.getAPress();
        //cDriveBButton = cDriveXbox.getBbutton();
        //cDriveXButton = cDriveXbox.getXbutton();
        //cDriveYButton = cDriveXbox.getYbutton();
        cDriveYPress = cDriveXbox.getYPress();
        if(cDriveAPress == true && toggleClimb == false){
            toggleClimb = true;
        }else if(cDriveAPress == true && toggleClimb == true){
            toggleClimb = false;
        }
        /*if((cDriveAButton == true)&&(cDriveBButton == false)){
            toggleClimb = true;
        }else if((cDriveAButton == false)&&(cDriveBButton == true)){
            toggleClimb = false;
        }*/
        if(toggleClimb == true){
            ClimbControl(1);
        }else if(toggleClimb == false){
            ClimbControl(0);
        }else{
            ClimbControl(2);
        }
        if(cDriveYPress == true && toggleClimb2 == false){
            toggleClimb2 = true;
        }else if(cDriveYPress == true && toggleClimb2 == true){
            toggleClimb2 = false;
        }
        /*if((cDriveXButton == true)&&(cDriveYButton == false)){  
            toggleClimb2 = true;
        }else if((cDriveXButton == false)&&(cDriveYButton == true)){
            toggleClimb2 = false;
        }*/
        if(toggleClimb2 == true){
            Climb2Control(1);
        }else if(toggleClimb2 == false){
            Climb2Control(0);
        }else{
            Climb2Control(2);
        }
        
    }
    private void intakeToggle() {
        //cDriveAButton = cDriveXbox.getAbutton();
        cDriveAPress = cDriveXbox.getAPress();
        //cDriveBButton = cDriveXbox.getBbutton();
        /*if((cDriveAButton == true)&&(cDriveBButton == false)){
            toggleIntake = true;
        }else if((cDriveAButton == false)&&(cDriveBButton == true)){
            toggleIntake = false;
        }*/
        if(cDriveAPress == true && toggleIntake == false){
            toggleIntake = true;
        }else if(cDriveAPress == true && toggleIntake == true){
            toggleIntake = false;
        }
        if(toggleIntake == true){
            BallControl(0);
        }else if(toggleIntake == false){
            BallControl(1);
        }else{
            BallControl(2);
        }
    }
    private void climbToggle(){
        //cDriveStartButton = cDriveXbox.getStartButton();
        //cDriveBackButton = cDriveXbox.getBackButton();
        cDriveStartPressed = cDriveXbox.getStartPressed();
        if(cDriveStartPressed == true && climbMode == false){
            climbMode = true;
        }else if(cDriveStartPressed == true && climbMode == true){
            climbMode = false;
        }
        /*if((cDriveStartButton == true)&&(cDriveBackButton == false)){
            climbMode = true;
        }else if((cDriveStartButton == false)&&(cDriveBackButton == true)){
            climbMode = false;
        }*/
    }
/*
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
*/
    public void Drive() {
        climbToggle();
        MAXIMUM_OVERDRIVE();
        drivemodetoggle = cDriveXbox.getRightTrigger();
        if(climbMode == true){
            climbmodeControl();
            drivebaseControl();
            Dashboard.getInstance().putString(false, "Robot Mode", "Climb");
        }else{
            if(drivemodetoggle >= 0.1){
                //DPadTurn();
                Dashboard.getInstance().putString(false, "Robot Mode", "Line Follow");
            }else{
                drivebaseControl();
                intakeToggle();
                Dashboard.getInstance().putString(false, "Robot Mode", "Drive");
            }
        }
    }
}