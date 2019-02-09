package frc.team4546.robot.subsystems;
import frc.team4546.robot.subsystems.motor;
import edu.wpi.first.wpilibj.Spark;;

public class sparkMotor extends motor{
    private Spark kMotor;
    public sparkMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new Spark(port);
    }
    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * mPos);
    }
    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * -mNeg);
    }
}
