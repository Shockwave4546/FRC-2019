package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class shockwaveXbox{
    private XboxController cXbox;
    private double defaultDeadzone = .2;
    private double LeftY;
    private double deadzoneLeftY;
    private double LeftX;
    private double deadzoneLeftX;
    private double RightY;
    private double deadzoneRightY;
    private double RightX;
    private double deadzoneRightX;


    public shockwaveXbox(final int port){
        cXbox = new XboxController(port);
        deadzoneLeftY = defaultDeadzone;
        deadzoneLeftX = defaultDeadzone;
        deadzoneRightY = defaultDeadzone;
        deadzoneRightX = defaultDeadzone;
    }
    public shockwaveXbox(final int port, final double dead1, final double dead2, final double dead3, final double dead4){
        cXbox = new XboxController(port);
        deadzoneLeftY = dead1;
        deadzoneLeftX = dead2;
        deadzoneRightY = dead3;
        deadzoneRightX = dead4;
    }
    public double getLeftY(){
        LeftY = cXbox.getY(Hand.kLeft);
        if(-deadzoneLeftY <= LeftY && LeftY <= deadzoneLeftY){
            return 0;
        }else{
            return -LeftY;
        }
    }
    public double getLeftX(){
        LeftX = cXbox.getX(Hand.kLeft);
        if(-deadzoneLeftX <= LeftX && LeftX <= deadzoneLeftX){
            return 0;
        }else{
            return -LeftX;
        }
    }
    public double getRightY(){
        RightY = cXbox.getY(Hand.kRight);
        if(-deadzoneRightY <= RightY && RightY <= deadzoneRightY){
            return 0;
        }else{
            return RightY;
        }
    }
    public double getRightX(){
        RightX = cXbox.getX(Hand.kRight);
        if(-deadzoneRightX <= RightX && RightX <= deadzoneRightX){
            return 0;
        }else{
            return RightX;
        }
    }

}