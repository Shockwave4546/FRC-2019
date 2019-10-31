package frc.robot;

import frc.robot.commands.Driver;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  public static Timer timer;
  private Driver dRover1 = new Driver();

  @Override
  public void robotInit() {
    //dRover1.IMUReset();

  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {

  } 

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    teleopPeriodic();

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    dRover1.Drive();

  }

  @Override
  public void testPeriodic() {

  }
}