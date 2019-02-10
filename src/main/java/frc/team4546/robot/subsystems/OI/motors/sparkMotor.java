package frc.team4546.robot.subsystems.OI.motors;
import frc.team4546.robot.subsystems.OI.motors.Motor;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.SpeedController;

public class sparkMotor extends Motor{
    private CANSparkMax kMotor;
    //public static final CANSparkMaxLowLevel.MotorType kBrushless;
    public sparkMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new CANSparkMax(port, MotorType.kBrushless);
       
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
}
