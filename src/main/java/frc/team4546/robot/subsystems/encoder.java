package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;

public class encoder{
    private Encoder sEncoder;
    private double dist;
    private double diameter;

    private int count;
    private double raw;
    private double distance;
    private double period;
    private double rate;
    private boolean direct; // True == up  ||  False == down
    private String direction;
    private boolean stopped;

    public encoder(final int port1, final int port2, final double diam){
        sEncoder = new Encoder(port1, port2, false, Encoder.EncodingType.k4X);
        sEncoder.reset();
        diameter = diam;
    }

    public int getCount(){
        count = sEncoder.get();
        return count;
    }
    public double getRaw(){
        raw = sEncoder.getRaw();
        return raw;
    }
    public double getDistance(){
        distance = sEncoder.getDistance();
        return distance;
    }
    public double getRate(){
        rate = sEncoder.getRate();
        return rate;
    }
    public String getDirection(){
        direct = sEncoder.getDirection();
        if(direct == true){
            direction = "up";
        }else if(direct == false){
            direction = "down";
        }
        return direction;
    }
    public Boolean isStopped(){
        stopped = sEncoder.getStopped();
        return stopped;
    }
}