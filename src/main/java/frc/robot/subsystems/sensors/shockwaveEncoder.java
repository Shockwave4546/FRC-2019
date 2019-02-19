package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

public class shockwaveEncoder{
    private int count;
    private boolean directionEncoder;
    private Encoder sEncoder;
    private enum direction{
        clockwise,
        counterclockwise,
        unknown
    }
    public shockwaveEncoder(final int port1, final int port2){
        sEncoder = new Encoder(RobotMap.sSlideEncoder1, RobotMap.sSlideEncoder2);
    }

    public int getCount(){
        count = sEncoder.get();
        return count;
    }
    public String getDirection(){
        directionEncoder = sEncoder.getDirection();
        if(directionEncoder == true){
            return direction.clockwise.toString();
        }else if(directionEncoder == false){
            return direction.clockwise.toString();
        }else{
            return direction.clockwise.toString();
        }
    }
    public void resetEncoder(){
        sEncoder.reset();
    }
}