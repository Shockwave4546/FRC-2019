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
    public void BallControl(final int mode){
        if(mode == 1){
            pBallForward();
        }else if(mode == 0){
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
    public void HatchControl(final int mode){
        if(mode == 1){
            pHatchForward();
        }else if(mode == 0){
            pHatchReverse();
        }else{
            pHatchOff();
        }
    }
}