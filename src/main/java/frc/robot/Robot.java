package frc.robot;

import frc.robot.commands.coDriver;
import frc.robot.commands.Driver;
import frc.robot.subsystems.vision.Cameras;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.shockwaveSolenoid;

public class Robot extends TimedRobot {
  public static Timer timer;
  public static final shockwaveSolenoid pneumatics = new shockwaveSolenoid();
  private Driver dRover1 = new Driver();
  private coDriver dRover2 = new coDriver();

  @Override
  public void robotInit() {
    //dRover1.IMUReset();
    Cameras.setup(); // Setup and Connection to Microsoft Camera

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Time", Math.round(timer.getMatchTime()));

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
    dRover2.coDrive();

  }

  @Override
  public void testPeriodic() {

  }
}