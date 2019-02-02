package frc.team4546.robot;

import frc.team4546.robot.subsystems.ColorSensor;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.I2C;

public class Robot extends TimedRobot {

  private int driverStationNumber = 0;

  public ColorSensor colorsensor;

  public XboxController xbox;

  public Joystick joystick;

  @Override
  public void robotInit() {
    driverStationNumber = DriverStation.getInstance().getLocation();
    // Cameras.setup(); // Setup and Connection to Pixy2 and Microsoft Camera

    // SmartDashboard.putBoolean("Pixy2 Light", false); // Addition of Pixy2 Lamp
    // Toggle
    // boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    // Cameras.light(PixyLightState); // Sends Current state of Toggle Button to
    // Pixy2

    colorsensor = new ColorSensor(I2C.Port.kOnboard);

    xbox = new XboxController(0);
    joystick = new Joystick(1);

  }

  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
    // Cameras.run(); // Runs Pixy2 and Microsoft Camera
    colorsensor.read();
    System.out.println(colorsensor.getRed());
    System.out.println(colorsensor.getGreen());
    System.out.println(colorsensor.getBlue());
    System.out.println(colorsensor.getProx());
    // boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    // Cameras.light(PixyLightState); // Sends Current state of Toggle Button to
    // Pixy2

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
  }

  @Override
  public void teleopInit() {
    colorsensor = new ColorSensor(I2C.Port.kOnboard);
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    colorsensor.read();
    System.out.println(colorsensor.getRed());
    System.out.println(colorsensor.getGreen());
    System.out.println(colorsensor.getBlue());
    System.out.println(colorsensor.getProx());

  }

  public int getDriveStationNumber() {
    return driverStationNumber;
  }

}