package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import edu.wpi.first.wpilibj.Talon;



public class talonMotor extends Motor{
    private Talon kMotor;
    private double kMotorSpeedPos;
    private double kMotorSpeedNeg;
    private double kMotorDefaultPos;
    private double kMotorDefaultNeg;
    public talonMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new Talon(port);
        kMotorDefaultPos = pos;
        kMotorDefaultNeg = neg;
        kMotorSpeedPos = pos;
        kMotorSpeedNeg = neg;
    }

    public void setMotorSpeeds(final double pos, final double neg){
        kMotorSpeedPos = pos;
        kMotorSpeedNeg = neg;
    }
    public void resetMotorSpeeds(){
        kMotorSpeedPos = kMotorDefaultPos;
        kMotorSpeedNeg = kMotorDefaultNeg;
    }

    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * kMotorSpeedPos);
    }

    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * -kMotorSpeedNeg);
    }

    public void stopMotor(){
        kMotor.set(0);
    }
    
    public void rotateMotor(final double rotate){
        if(rotate > 0){
            kMotor.set(rotate * kMotorSpeedNeg);
        }else{
            kMotor.set(rotate * kMotorSpeedNeg);
        }
    }
}
