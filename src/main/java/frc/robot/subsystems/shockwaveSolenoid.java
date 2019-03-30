package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class shockwaveSolenoid extends Subsystem {
    Compressor compressor = new Compressor(0);

    DoubleSolenoid pHatchIntake = new DoubleSolenoid(RobotMap.pIntakeHatchF, RobotMap.pIntakeHatchR);

    DoubleSolenoid pBallIntake = new DoubleSolenoid(RobotMap.pIntakeBallF, RobotMap.pIntakeBallR);

    DoubleSolenoid pClimb = new DoubleSolenoid(RobotMap.pClimbF, RobotMap.pClimbR);
    public void HatchOuttake() {
        pHatchIntake.set(DoubleSolenoid.Value.kForward);
    }
    public void HatchIntake() {
        pHatchIntake.set(DoubleSolenoid.Value.kReverse);
    }
    public void HatchOff() {
        pHatchIntake.set(DoubleSolenoid.Value.kOff);
    }


    public void BallOut() {
        pBallIntake.set(DoubleSolenoid.Value.kForward);
    }
    public void BallIn() {
        pBallIntake.set(DoubleSolenoid.Value.kReverse);
    }
    public void BallOff() {
        pBallIntake.set(DoubleSolenoid.Value.kOff);
    }

    public void ClimbOut(){
        pClimb.set(DoubleSolenoid.Value.kForward);
    }
    public void ClimbIn(){
        pClimb.set(DoubleSolenoid.Value.kReverse);
    }
    public void ClimbOff(){
        pClimb.set(DoubleSolenoid.Value.kOff);
    }
    
    public void retractAll() {
        pHatchIntake.set(DoubleSolenoid.Value.kReverse);
        pBallIntake.set(DoubleSolenoid.Value.kReverse);
    }
    public void extendAll() {
        pHatchIntake.set(DoubleSolenoid.Value.kForward);
        pBallIntake.set(DoubleSolenoid.Value.kForward);
    }

    public void initDefaultCommand() {
        // There are no default commands needed.
    }

}