package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;

public class pwmMotor {
  private PWM kMotor;
  private double kMotorPos;
  private double kMotorNeg;
  public pwmMotor(final int port, final int Pos, final int Neg){
    kMotor = new PWM(port);
    kMotorPos = Pos;
    kMotorNeg = Neg;
  }
}