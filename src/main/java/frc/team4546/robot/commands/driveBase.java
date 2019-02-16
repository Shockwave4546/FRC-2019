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
        kLeftDrive = new talonMotor(RobotMap.LeftDrivePort,RobotMap.LeftDrivePos,RobotMap.LeftDriveNeg);
        kRightDrive = new talonMotor(RobotMap.RightDrivePort,RobotMap.RightDrivePos,RobotMap.RightDriveNeg);
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);
    }
    public void drive(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveLeftX = cDriveXbox.getLeftX();
        cDriveRightY = cDriveXbox.getRightY();
        cDriveRightX = cDriveXbox.getRightX();

        kLeftDrive.rotateMotor(cDriveLeftY);
        kRightDrive.rotateMotor(cDriveLeftY);
    }
}