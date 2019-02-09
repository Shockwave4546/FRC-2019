package frc.team4546.robot.subsystems;

public abstract class motor{
    protected int mPort;
    protected double mPos;
    protected double mNeg;
    public motor(final int port, final double pos, final double neg){
        mPort = port;
        mPos = pos;
        mNeg = neg;
    }

    public abstract void rotateClockwise(final double rotate);
    public abstract void rotateCounterClockwise(final double rotate);
    
}