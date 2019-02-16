package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.RobotMap;

public class Driver{
    private sparkMotor kLeftDrive;
    private sparkMotor kRightDrive;
    private shockwaveXbox cDriveXbox;
    private double cDriveLeftY;
    private double cDriveRightX;
    public Driver(){
        kLeftDrive = new sparkMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new sparkMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
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
        
    }
    public void drive(){
        drivebaseControl();
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