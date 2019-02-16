package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.RobotMap;

public class coDriver{
    private victorMotor kIntakeLeft;
    private victorMotor kIntakeRight;
    private victorMotor kLinearSlide;
    private shockwaveXbox cCoDriverXbox;
    private boolean cIntakeLeft;
    private boolean cIntakeRight;
    private double cLinearSlide;
    public coDriver(){
        kIntakeLeft = new victorMotor(RobotMap.LeftIntakePort, RobotMap.LeftIntakePos, RobotMap.LeftIntakeNeg);
        kIntakeRight = new victorMotor(RobotMap.RightIntakePort, RobotMap.RightIntakePos, RobotMap.RightIntakeNeg);
        kLinearSlide = new victorMotor(RobotMap.LinearSlidePort, RobotMap.LinearSlidePos, RobotMap.LinearSlideNeg);
        cCoDriverXbox = new shockwaveXbox(RobotMap.XboxCoDriver);
    }

    private void intakeControl(){
        cIntakeLeft = cCoDriverXbox.getLeftBumper();
        cIntakeRight = cCoDriverXbox.getRightBumper();
        if(cIntakeLeft == true){
            kIntakeLeft.rotateClockwise(1);
            kIntakeRight.rotateCounterClockwise(1);
        }else{
            kIntakeLeft.stopMotor();
            kIntakeRight.stopMotor();
        }

        if(cIntakeRight == true){
            kIntakeLeft.rotateCounterClockwise(1);
            kIntakeRight.rotateClockwise(1);
        }else{
            kIntakeLeft.stopMotor();
            kIntakeRight.stopMotor();
        }
    }

    private void slideControl(){
        cLinearSlide = cCoDriverXbox.getLeftY();
        kLinearSlide.rotateMotor(cLinearSlide);
    }

    public void coDrive(){
        intakeControl();
        slideControl();
    }
    public void remoteIntake(final double speed){
        kIntakeLeft.rotateMotor(speed);
        kIntakeRight.rotateMotor(speed);
    }
    public void remoteSlide(final double speed){
        kLinearSlide.rotateMotor(speed);
    }
}