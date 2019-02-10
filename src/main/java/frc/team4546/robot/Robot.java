package frc.team4546.robot;

import frc.team4546.robot.subsystems.ColorSensor;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.team4546.robot.Dashboard;
import edu.wpi.first.wpilibj.command.Scheduler;


import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.I2C;

public class Robot extends TimedRobot {

  private int driverStationNumber = 0;

  public ColorSensor colorsensor;


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



  }

  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
    // Cameras.run(); // Runs Pixy2 and Microsoft Camera
    colorsensor.read();
    Dashboard.getInstance().putNumber(false, "Red Value", colorsensor.getRed());
    Dashboard.getInstance().putNumber(false, "Green Value", colorsensor.getGreen());
    Dashboard.getInstance().putNumber(false, "Blue Value", colorsensor.getBlue());
    Dashboard.getInstance().putNumber(false, "Prox Value", colorsensor.getProx());
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