package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;

public class encoder{
    private Encoder sEncoder;
    private double dist;
    private double diameter;

    public encoder(final int port1, final int port2, final double diam){
        sEncoder = new Encoder(port1, port2, false, Encoder.EncodingType.k4X);
        sEncoder.reset();
        diameter = diam;
    }

    public int getCount(){
        int count = sEncoder.get();
        return count;
    }
    public double getRaw(){
        double raw = sEncoder.getRaw();
        return raw;
    }
    public double getDistance(){
        double distance = sEncoder.getDistance();
        return distance;
    }
    public double getPeriod(){
        double period = sEncoder.getPeriod();
        return period;
    }
    public double getRate(){
        double rate = sEncoder.getRate();
        return rate;
    }
    public String getDirection(){
        boolean direct = sEncoder.getDirection();
        String direction;
        if(direct == true){
            direction = "up";
        }else if(direct == false){
            direction = "down";
        }else{
            direction = "unknown";
        }
        return direction;
    }
    public boolean isStopped(){
        boolean stopped = sEncoder.getStopped();
        return stopped;
    }
}