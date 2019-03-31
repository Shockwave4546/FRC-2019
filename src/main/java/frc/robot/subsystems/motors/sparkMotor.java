package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class sparkMotor extends Motor{
    private CANSparkMax kMotor;
    private CANEncoder kMotorEncoder;
    private double kMotorEncoderValuePos;
    private double kMotorEncoderValueVel;
    private double kMotorSpeedPos;
    private double kMotorSpeedNeg;
    private double kMotorDefaultPos;
    private double kMotorDefaultNeg;
    public sparkMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new CANSparkMax(port, MotorType.kBrushless);
        kMotorEncoder = kMotor.getEncoder();
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

    public double getEncoderPosition(){
        kMotorEncoderValuePos = kMotorEncoder.getPosition();
        return kMotorEncoderValuePos;
    }
    public double getEncoderVelocity(){
        kMotorEncoderValueVel = kMotorEncoder.getVelocity();
        return kMotorEncoderValueVel;
    }
}
