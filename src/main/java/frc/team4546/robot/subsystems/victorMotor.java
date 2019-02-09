package frc.team4546.robot.subsystems;
import frc.team4546.robot.subsystems.motor;
import edu.wpi.first.wpilibj.VictorSP;

public class victorMotor extends motor{
    private VictorSP kMotor;
    public victorMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new VictorSP(port);
    }
    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * mPos);
    }
    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * -mNeg);
    }
}
