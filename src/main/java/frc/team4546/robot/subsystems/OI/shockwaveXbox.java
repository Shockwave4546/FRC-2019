package frc.team4546.robot.subsystems.OI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class shockwaveXbox{
    private XboxController cXbox;
    private double LeftY;
    private double LeftX;
    private double RightY;
    private double RightX;
    public shockwaveXbox(final int port){
        cXbox = new XboxController(port);
    }
    public double getLeftY(){
        LeftY = cXbox.getY(Hand.kLeft);
        if(-.2 <= LeftY && LeftY <=.2){
            return 0;
        }else{
            return LeftY;
        }
    }
    public double getLeftX(){
        LeftX = cXbox.getX(Hand.kLeft);
        if(-.2 <= LeftX && LeftX <=.2){
            return 0;
        }else{
            return LeftX;
        }
    }
    public double getRightY(){
        RightY = cXbox.getY(Hand.kRight);
        if(-.2 <= RightY && RightY <=.2){
            return 0;
        }else{
            return RightY;
        }
    }
    public double getRightX(){
        RightX = cXbox.getX(Hand.kRight);
        if(-.2 <= RightY && RightY <=.2){
            return 0;
        }else{
            return RightY;
        }
    }
}