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
    private boolean toggleIntake;
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
            toggleIntake = true;
        }else if((cDriveAButton == false)&&(cDriveBButton == true)){
            toggleIntake = false;
        }
        if(toggleIntake = true){
            pSolenoidControl.BallControl(1);
        }else if(toggleIntake = false){
            pSolenoidControl.BallControl(0);
        }else{
            pSolenoidControl.BallControl(2);
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