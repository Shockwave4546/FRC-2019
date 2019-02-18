package frc.robot.commands;

import frc.robot.subsystems.shockwaveSolenoid;
import frc.robot.RobotMap;

public class pneumatics{
    private shockwaveSolenoid pBallIntake;
    private shockwaveSolenoid pHatchIntake;
    public pneumatics(){
        pBallIntake = new shockwaveSolenoid(RobotMap.pIntakeBallF, RobotMap.pIntakeBallR);
        pHatchIntake = new shockwaveSolenoid(RobotMap.pIntakeHatchF, RobotMap.pIntakeHatchR);
    }

    private void pBallForward(){
        pBallIntake.forward();
    }
    private void pBallReverse(){
        pBallIntake.reverse();
    }
    private void pBallOff(){
        pBallIntake.off();
    }
    public void BallControl(final String mode){
        if(mode == "forward"){
            pBallForward();
        }else if(mode == "reverse"){
            pBallReverse();
        }else{
            pBallOff();
        }
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
    public void HatchControl(final String mode){
        if(mode == "forward"){
            pHatchForward();
        }else if(mode == "reverse"){
            pHatchReverse();
        }else{
            pHatchOff();
        }
    }
}