package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.Dashboard;
import frc.robot.RobotMap;

public class Driver {
    private talonMotor kLeftDrive;
    private talonMotor kRightDrive;
    private talonMotor kMiddleDrive;
    private shockwaveXbox cDriveXbox;
    private double cDriveLeftY;
    private double cDriveLeftX;
    private double cDriveRightY;
    private double cDriveRightX;
    private boolean cDriveApress;
    private boolean cDriveBpress;
    private boolean cDriveYpress;
    private boolean cDriveXpress;
    private boolean cDriveLeftBumper;
    private boolean toggleOverdrive;
    private double motorSpeedScale;
    
    public Driver(){
        kLeftDrive = new talonMotor(RobotMap.LeftDrivePort, RobotMap.LeftDrivePos, RobotMap.LeftDriveNeg);
        kRightDrive = new talonMotor(RobotMap.RightDrivePort, RobotMap.RightDrivePos, RobotMap.RightDriveNeg);
        kMiddleDrive = new talonMotor(RobotMap.MiddleDrivePort, RobotMap.MiddleDrivePos, RobotMap.MiddleDriveNeg);
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);

    }
    
    private void toggleSpeeds(){
        cDriveApress = cDriveXbox.getAbutton(1);    //  25%
        cDriveBpress = cDriveXbox.getBbutton(1);    //  50%
        cDriveYpress = cDriveXbox.getYbutton(1);    //  75%
        cDriveXpress = cDriveXbox.getXbutton(1);    // 100%
        if(cDriveApress == true && motorSpeedScale == .25){
            motorSpeedScale = .25;
        }else if(cDriveApress == true && motorSpeedScale == .50){
            motorSpeedScale = .50;
        }else if(cDriveApress == true && motorSpeedScale == .75){
            motorSpeedScale = .75;
        }else if(cDriveApress == true && motorSpeedScale == 1){
            motorSpeedScale = 1;
        }
        kLeftDrive.setMotorSpeeds(motorSpeedScale, motorSpeedScale);
        kRightDrive.setMotorSpeeds(motorSpeedScale, motorSpeedScale);
        kMiddleDrive.setMotorSpeeds(motorSpeedScale, motorSpeedScale);
    }

    private void drivebaseControl() {
        cDriveLeftY = cDriveXbox.getLeftY();
        cDriveLeftX = cDriveXbox.getLeftX();
        cDriveRightX = cDriveXbox.getRightX();
        if(cDriveLeftY == 0) {
            kLeftDrive.rotateMotor(cDriveLeftX);
            kRightDrive.rotateMotor(cDriveRightX);
            kMiddleDrive.rotateMotor(cDriveLeftX);
        }else{
            kLeftDrive.rotateMotor(cDriveLeftY + cDriveRightX);
            kRightDrive.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }

    /*private void MAXIMUM_OVERDRIVE(){
        cDriveLeftBumper = cDriveXbox.getLeftBumper(0);
        if(cDriveLeftBumper == true){
            toggleOverdrive = true;
            kLeftDrive.setMotorSpeeds(1, 1);
            kRightDrive.setMotorSpeeds(1, 1);
        }else if((cDriveLeftBumper == false) &&(toggleOverdrive == true)){
            toggleOverdrive = false;
            kLeftDrive.resetMotorSpeeds();
            kRightDrive.resetMotorSpeeds();
        }
        Dashboard.getInstance().putBoolean(false, "Maximum Overdrive", toggleOverdrive);
    }*/
    
    public void Drive() {
        //MAXIMUM_OVERDRIVE();
        toggleSpeeds();
        drivebaseControl();
    }
}