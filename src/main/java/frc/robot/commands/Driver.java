package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.commands.pneumatics;
import frc.robot.RobotMap;

public class Driver{
    private sparkMotor kLeftDrive;
    private sparkMotor kRightDrive;
    private shockwaveXbox cDriveXbox;
    private pneumatics pSolenoidControl;
    private double cDriveLeftY;
    private double cDriveRightX;
    private boolean intakeToggle;
    private boolean cDriveAButton;
    private boolean cDriveBButton;
    public Driver(){
        kLeftDrive = new sparkMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new sparkMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        pSolenoidControl = new pneumatics();
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
            pSolenoidControl.BallControl("forward");
        }else if(intakeToggle = false){
            pSolenoidControl.BallControl("reverse");
        }else{
            pSolenoidControl.BallControl("off");
        }


    }
    public void drive(){
        drivebaseControl();
        intakeToggle();
    }

    public void remoteLeftDrive(final double leftMotor){
        kLeftDrive.rotateMotor(leftMotor);
    }
    public double getLeftEncoderPos(){
        return kLeftDrive.getEncoderPosition();
    }
    public void remoteRightDrive(final double rightMotor){
        kLeftDrive.rotateMotor(rightMotor);
    }
    public double getRightEncoderPos(){
        return kRightDrive.getEncoderPosition();
    }
}