package frc.team4546.robot.subsystems.motors;
import frc.team4546.robot.subsystems.motors.Motor;
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
}
