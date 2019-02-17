package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class shockwaveSolenoid{
    private DoubleSolenoid pSolenoid;

    public shockwaveSolenoid(final int forward, final int reverse){
        pSolenoid = new DoubleSolenoid(forward, reverse);
    }
    public void forward(){
        pSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void reverse(){
        pSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void off(){
        pSolenoid.set(DoubleSolenoid.Value.kOff);
    }
}