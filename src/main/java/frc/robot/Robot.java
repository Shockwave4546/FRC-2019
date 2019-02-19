/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.vision.Cameras;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
//import frc.robot.commands.coDriver;
import frc.robot.commands.Driver;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * DO NOT MODIFY
   */

  //public static final ADIS16448_IMU imu = new ADIS16448_IMU();
  //public boolean straight = false;
  //public static double currentZAngle = 0;
  //public static String targetDirection = "NODIRECTION";
  //public static double targetZAngle = -1;
  //public static double angle = 0;
  //public static shockwaveXbox xController;
  //public talonMotor kLeftDrive = new talonMotor(0, .5, .5);
  //public talonMotor kRightDrive = new talonMotor(1, .5, .5);
  //public static ColorSensor colorsensor;
  private Driver dRover1 = new Driver();
  // public static ColorSensor colorSensor;
  // double leftTrigger = xController.getLeftTrigger();
  // private coDriver dRover2 = new coDriver();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
      dRover1.IMUReset();
    //colorsensor = new ColorSensor(I2C.Port.kOnboard);
    //xController = new shockwaveXbox(0);

    Cameras.setup(); // Setup and Connection to Pixy2 and Microsoft Camera
    /*SmartDashboard.putBoolean("Pixy2 Light", false); // Addition of Pixy2 Lamp Toggle
    boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2*/
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    dRover1.Drive();
    //dRover1.DPadTurn();
    /*boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2*/

  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    // Dashboard.getInstance().putNumber(false, "Gyro-X", imu.getAngleX());
    // Dashboard.getInstance().putNumber(false, "Gyro-Y", imu.getAngleY());

    // Dashboard.getInstance().putNumber(false, "Accel-X", imu.getAccelX());
    // Dashboard.getInstance().putNumber(false, "Accel-Y", imu.getAccelY());
    // Dashboard.getInstance().putNumber(false, "Accel-Z", imu.getAccelZ());

    // Dashboard.getInstance().putNumber(false, "Pitch", imu.getPitch());
    // Dashboard.getInstance().putNumber(false, "Roll", imu.getRoll());
    // Dashboard.getInstance().putNumber(false, "Yaw", imu.getYaw());

    // Dashboard.getInstance().putNumber(false, "Pressure: ",
    // imu.getBarometricPressure());
    // Dashboard.getInstance().putNumber(false, "Temperature: ",
    // imu.getTemperature());

    // boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    // Cameras.light(PixyLightState); // Sends Current state of Toggle Button to
    // Pixy2

    // Cameras.run(); // Runs Pixy2 and Microsoft Camera
  }

}
