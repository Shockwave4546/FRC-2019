package frc.robot.commands;

import frc.robot.subsystems.motors.*;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.RobotMap;

public class intake{
    private victorMotor kIntakeLeft;
    private victorMotor kIntakeRight;
    private shockwaveXbox cCoDriverXbox;
    private double cIntakeLeft;
    private double cIntakeRight;
    public intake(){
        kIntakeLeft = new victorMotor(RobotMap.LeftIntakePort, RobotMap.LeftIntakePos, RobotMap.LeftIntakeNeg);
        kIntakeRight = new victorMotor(RobotMap.RightIntakePort, RobotMap.RightIntakePos, RobotMap.RightIntakeNeg);
        cCoDriverXbox = new shockwaveXbox(RobotMap.XboxCoDriver);
    }
}