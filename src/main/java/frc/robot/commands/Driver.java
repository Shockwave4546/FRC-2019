package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.RobotMap;

public class Driver{
    private talonMotor kLeftDrive;
    private talonMotor kRightDrive;
    private shockwaveXbox cDriveXbox;
    private double cDriveLeftY;
    //public double cDriveLeftX;
    //public double cDriveRightY;
    private double cDriveRightX;
    public Driver(){
        kLeftDrive = new talonMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new talonMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);
    }
    public void drive(){
        cDriveLeftY = cDriveXbox.getLeftY();
        //cDriveLeftX = cDriveXbox.getLeftX();
        //cDriveRightY = cDriveXbox.getRightY();
        cDriveRightX = cDriveXbox.getRightX();
        if(cDriveLeftY == 0){
            kLeftDrive.rotateMotor(cDriveRightX);
            kRightDrive.rotateMotor(cDriveRightX);
        }else{
            kLeftDrive.rotateMotor(cDriveLeftY + cDriveRightX);
            kRightDrive.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }

    public double testdriveLeft(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveRightX = cDriveXbox.getRightX();
        if(cDriveLeftY == 0){
            return(cDriveRightX);
        }else{
            return(cDriveLeftY + cDriveRightX);
        }
    }
    public double testdriveRight(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveRightX = cDriveXbox.getRightX();
        if(cDriveLeftY == 0){
            return(cDriveRightX);
        }else{
            return(cDriveLeftY - cDriveRightX);
        }
    }
}