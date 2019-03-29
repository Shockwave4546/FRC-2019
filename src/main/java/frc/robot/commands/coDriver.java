package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.motors.*;
import frc.robot.subsystems.sensors.shockwaveEncoder;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.Dashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class coDriver{
    private victorMotor kIntakeLeft;
    private victorMotor kIntakeRight;
    private victorMotor kLinearSlide;
    private shockwaveXbox cCoDriverXbox;
    private shockwaveEncoder sSlideEncoder;
    private boolean cIntakeLeft;
    private boolean cIntakeRight;
    private double cLinearSlide;
    private boolean cDriveYButton;
    private String climbposstr;
    private int climbposint;
    private int sSlideEncoderCount;
    public coDriver(){
        kIntakeLeft = new victorMotor(RobotMap.LeftIntakePort, RobotMap.LeftIntakePos, RobotMap.LeftIntakeNeg);
        kIntakeRight = new victorMotor(RobotMap.RightIntakePort, RobotMap.RightIntakePos, RobotMap.RightIntakeNeg);
        kLinearSlide = new victorMotor(RobotMap.LinearSlidePort, RobotMap.LinearSlidePos, RobotMap.LinearSlideNeg);
        sSlideEncoder = new shockwaveEncoder(RobotMap.sSlideEncoder1, RobotMap.sSlideEncoder2);
        cCoDriverXbox = new shockwaveXbox(RobotMap.XboxCoDriver);
    }

    private void HatchControl(final int mode){
        if(mode == 1){
            Robot.pneumatics.HatchOuttake();
        }else if(mode == 0){
            Robot.pneumatics.HatchIntake();
        }else{
            Robot.pneumatics.HatchOff();
        }
    }

    private void intakeBallControl(){
        cIntakeLeft = cCoDriverXbox.getLeftBumper();
        cIntakeRight = cCoDriverXbox.getRightBumper();
        if(cIntakeLeft == true){
            kIntakeLeft.rotateClockwise(1);
            kIntakeRight.rotateCounterClockwise(1);
        }else if(cIntakeRight == true){
            kIntakeLeft.rotateCounterClockwise(1);
            kIntakeRight.rotateClockwise(1);
        }else{
            kIntakeLeft.stopMotor();
            kIntakeRight.stopMotor();
        }
    }
    private void moveSlide(final int target){

    }

    private void slideControl(){
        cLinearSlide = cCoDriverXbox.getLeftY();
        System.out.println(cLinearSlide);
        kLinearSlide.rotateMotor(cLinearSlide);

    }

    private void intakeHatchControl(){
        cDriveYButton = cCoDriverXbox.getYbutton();
        if(cDriveYButton == true){
            HatchControl(0);
        }else{
            HatchControl(1);
        }
    }

    public void coDrive(){
        climbposstr = "Ground";
        Dashboard.getInstance().putString(false, "Slide Position", climbposstr);
        sSlideEncoderCount = sSlideEncoder.getCount();
        Dashboard.getInstance().putNumber(false, "Slide Encoder Count", sSlideEncoderCount);
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