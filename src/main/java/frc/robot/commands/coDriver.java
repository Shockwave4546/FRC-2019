package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.subsystems.shockwaveSolenoid;
import frc.robot.RobotMap;

public class coDriver{
    private victorMotor kIntakeLeft;
    private victorMotor kIntakeRight;
    private victorMotor kLinearSlide;
    private shockwaveXbox cCoDriverXbox;
    private shockwaveSolenoid pHatchIntake;
    private boolean cIntakeLeft;
    private boolean cIntakeRight;
    private double cLinearSlide;
    private boolean cDriveYButton;
    public coDriver(){
        kIntakeLeft = new victorMotor(RobotMap.LeftIntakePort, RobotMap.LeftIntakePos, RobotMap.LeftIntakeNeg);
        kIntakeRight = new victorMotor(RobotMap.RightIntakePort, RobotMap.RightIntakePos, RobotMap.RightIntakeNeg);
        kLinearSlide = new victorMotor(RobotMap.LinearSlidePort, RobotMap.LinearSlidePos, RobotMap.LinearSlideNeg);
        pHatchIntake = new shockwaveSolenoid(RobotMap.pIntakeHatchF, RobotMap.pIntakeHatchR);
        cCoDriverXbox = new shockwaveXbox(RobotMap.XboxCoDriver);
    }

    private void pHatchForward(){
        pHatchIntake.forward();
    }
    private void pHatchReverse(){
        pHatchIntake.reverse();
    }
    private void pHatchOff(){
        pHatchIntake.off();
    }
    public void HatchControl(final int mode){
        if(mode == 1){
            pHatchForward();
        }else if(mode == 0){
            pHatchReverse();
        }else{
            pHatchOff();
        }
    }

    private void intakeBallControl(){
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

    public void slideControl(){
        cLinearSlide = cCoDriverXbox.getLeftY();
        kLinearSlide.rotateMotor(cLinearSlide);
    }

    public void intakeHatchControl(){
        cDriveYButton = cCoDriverXbox.getYbutton();
        if(cDriveYButton == true){
            HatchControl(1);
        }else{
            HatchControl(0);
        }
    }

    public void coDrive(){
        intakeBallControl();
        intakeHatchControl();
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