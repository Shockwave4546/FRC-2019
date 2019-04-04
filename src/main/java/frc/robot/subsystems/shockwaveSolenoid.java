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

    DoubleSolenoid pClimb2 = new DoubleSolenoid(RobotMap.pClimb2F, RobotMap.pClimb2R);

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
    public void Climb2Out(){
        pClimb2.set(DoubleSolenoid.Value.kForward);
    }
    public void Climb2In(){
        pClimb2.set(DoubleSolenoid.Value.kReverse);
    }
    public void Climb2Off(){
        pClimb2.set(DoubleSolenoid.Value.kOff);
    }
    
    public void initDefaultCommand() {
        // There are no default commands needed.
    }

}