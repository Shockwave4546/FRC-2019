package frc.team4546.robot.subsystems.OI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team4546.robot.subsystems.OI.motors.*;

import frc.team4546.robot.Robot;

public class driveBase{
    private talonMotor kLeftDrive;
    private talonMotor kRightDrive;
 
    public double cDriveLeftY;
    public double cDriveLeftX;
    public double cDriveRightY;
    public double cDriveRightX;
    public driveBase(){
        kLeftDrive = new talonMotor(6,.2,.2);
        kRightDrive = new talonMotor(7,.2,.2);

    }
    public void drive(){
        cDriveLeftY = Robot.oi.driverController.leftStick.getY();
        cDriveRightY = Robot.oi.driverController.rightStick.getY();
        kLeftDrive.rotateClockwise(cDriveLeftY);
        kRightDrive.rotateCounterClockwise(cDriveRightY);
    }
}