package frc.team4546.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team4546.robot.subsystems.motors.*;
import frc.team4546.robot.controllers.shockwaveXbox;

public class driveBase{
    private talonMotor kLeftDrive;
    private talonMotor kRightDrive;
    private shockwaveXbox cDriveXbox;
    public double cDriveLeftY;
    public double cDriveLeftX;
    public double cDriveRightY;
    public double cDriveRightX;
    public driveBase(){
        //kLeftDrive = new talonMotor(6,.2,.2);
        //kRightDrive = new talonMotor(7,.2,.2);
        cDriveXbox = new shockwaveXbox(1);
    }
    public double drive(){
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveLeftX = cDriveXbox.getLeftX();
        cDriveRightY = cDriveXbox.getRightY();
        cDriveRightX = cDriveXbox.getRightX();
        //kLeftDrive.rotateClockwise(cDriveLeftY);
        //kRightDrive.rotateCounterClockwise(cDriveLeftY);
        return cDriveRightY;
    }
}