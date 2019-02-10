package frc.team4546.robot.subsystems.OI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team4546.robot.subsystems.OI.motors.*;

public class driveBase{
    private talonMotor kLeftDrive;
    private talonMotor kRightDrive;
    public driveBase(){
        kLeftDrive = new talonMotor(6,.2,.2);
        kRightDrive = new talonMotor(7,.2,.2);
        
    }

}