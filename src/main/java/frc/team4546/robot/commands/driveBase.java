package frc.team4546.robot.commands;

import frc.team4546.robot.subsystems.motors.*;
import frc.team4546.robot.controllers.shockwaveXbox;
import frc.team4546.robot.RobotMap;

public class driveBase{
    private talonMotor kLeftDrive;
    private talonMotor kRightDrive;
    private shockwaveXbox cDriveXbox;
    public double cDriveLeftY;
    public double cDriveLeftX;
    public double cDriveRightY;
    public double cDriveRightX;
    public driveBase(){
        kLeftDrive = new talonMotor(6,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new talonMotor(7,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        cDriveXbox = new shockwaveXbox(1);
    }
    public void drive(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveLeftX = cDriveXbox.getLeftX();
        cDriveRightY = cDriveXbox.getRightY();
        cDriveRightX = cDriveXbox.getRightX();
        
        kLeftDrive.rotateClockwise(cDriveLeftY);
        kRightDrive.rotateClockwise(cDriveLeftY);
    }
}