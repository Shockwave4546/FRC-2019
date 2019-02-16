package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.RobotMap;

public class intake{
    private victorMotor kIntakeLeft;
    private victorMotor kIntakeRight;
    private shockwaveXbox cCoDriverXbox;
    private boolean cIntakeLeft;
    private boolean cIntakeRight;
    public intake(){
        kIntakeLeft = new victorMotor(RobotMap.LeftIntakePort, RobotMap.LeftIntakePos, RobotMap.LeftIntakeNeg);
        kIntakeRight = new victorMotor(RobotMap.RightIntakePort, RobotMap.RightIntakePos, RobotMap.RightIntakeNeg);
        cCoDriverXbox = new shockwaveXbox(RobotMap.XboxCoDriver);
    }

    public void intakeControl(){
        cIntakeLeft = cCoDriverXbox.getLeftBumper();
        cIntakeRight = cCoDriverXbox.getRightBumper();
        if(cIntakeLeft == true){
            kIntakeLeft.rotateClockwise(1);
        }else{
            kIntakeLeft.stopMotor();
        }

        if(cIntakeRight == true){
            kIntakeRight.rotateCounterClockwise(1);
        }else{
            kIntakeRight.stopMotor();
        }
    }
}