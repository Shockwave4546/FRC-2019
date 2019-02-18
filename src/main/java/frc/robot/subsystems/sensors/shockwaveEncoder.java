package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

public class shockwaveEncoder{
    private int count;
    private boolean direction;
    private Encoder sEncoder;
    public shockwaveEncoder(final int port1, final int port2){
        sEncoder = new Encoder(RobotMap.sSlideEncoder1, RobotMap.sSlideEncoder2);
    }

    public int getCount(){
        count = sEncoder.get();
        return count;
    }
    public String getDirection(){
        direction = sEncoder.getDirection();
        if(direction == true){
            return "clockwise";
        }else if(direction == false){
            return "counter-clockwise";
        }else{
            return "unknown";
        }
    }
    public void resetEncoder(){
        sEncoder.reset();
    }
}