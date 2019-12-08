package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import edu.wpi.first.wpilibj.Talon;



public class talonMotor extends Motor{
    private Talon kMotor;
    public talonMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new Talon(port);
    }

    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * mPos);
    }

    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * -mNeg);
    }

    public void stopMotor(){
        kMotor.set(0);
    }
    
    public void rotateMotor(final double rotate){
        if(rotate > 0){
            kMotor.set(rotate);
        }else{
            kMotor.set(rotate);
        }
    }
}
