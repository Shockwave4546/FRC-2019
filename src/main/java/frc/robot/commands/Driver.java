package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.subsystems.shockwaveSolenoid;
import frc.robot.controllers.shockwaveXbox;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotMap;
//import frc.robot.subsystems.sensors.ColorSensor;
import frc.robot.Dashboard;

public class Driver{
    private sparkMotor kLeftDrive;
    private sparkMotor kRightDrive;
    private shockwaveXbox cDriveXbox;
    private shockwaveSolenoid pBallIntake;
    private double cDriveLeftY;
    private double cDriveRightX;
    private boolean intakeToggle;
    private boolean cDriveAButton;
    private boolean cDriveBButton;
    public static shockwaveXbox xController;
    public Driver(){
        kLeftDrive = new sparkMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new sparkMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        pBallIntake = new shockwaveSolenoid(RobotMap.pIntakeBallF, RobotMap.pIntakeBallR);
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);
    }
    private void drivebaseControl(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveRightX = cDriveXbox.getRightX();
        if(cDriveLeftY == 0){
            kLeftDrive.rotateMotor(cDriveRightX);
            kRightDrive.rotateMotor(cDriveRightX);
        }else{
            kLeftDrive.rotateMotor(cDriveLeftY + cDriveRightX);
            kRightDrive.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }
    private void intakeToggle(){
        cDriveAButton = cDriveXbox.getAbutton();
        cDriveBButton = cDriveXbox.getBbutton();
        if((cDriveAButton == true)&&(cDriveBButton == false)){
            intakeToggle = true;
        }else if((cDriveAButton == false)&&(cDriveBButton == true)){
            intakeToggle = false;
        }
        if(intakeToggle = true){
            pBallIntake.forward();
        }else if(intakeToggle = false){
            pBallIntake.reverse();
        }else{
            pBallIntake.off();
        }


    }
    public void drive(){
        drivebaseControl();
        intakeToggle();
    }

    public void remoteLeftDrive(final double leftMotor){
        kLeftDrive.rotateMotor(leftMotor);
    }
    public double getLeftEncoder(){
        return kLeftDrive.getEncoder();
    }
    public void remoteRightDrive(final double rightMotor){
        kLeftDrive.rotateMotor(rightMotor);
    }
    public double getRightEncoder(){
        return kRightDrive.getEncoder();
    }
}