/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.commands.driveBase;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TogglePixy2LampCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.vision.Pixy2USBJNI;
import frc.robot.vision.Block;
import frc.robot.Dashboard;
import edu.wpi.first.wpilibj.DriverStation;
import com.analog.adis16448.frc.ADIS16448_IMU;

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

  private int driverStationNumber = 0;
  public static driveBase dRobot = new driveBase();
  public static double negzangle = 360;
  public static double currentZAngle = 360;
  public static double targetZAngle = 360;

  public static final ADIS16448_IMU imu = new ADIS16448_IMU();
  public static Pixy2USBJNI pixy2USBJNI = new Pixy2USBJNI();
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    Thread pixy2USBThread = new Thread(pixy2USBJNI);
    pixy2USBThread.setDaemon(true);
    pixy2USBThread.start();
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    // SmartDashboard.putData("Toggle Lamp", new TogglePixy2LampCommand());

    imu.reset();
    imu.calibrate();
    Dashboard.getInstance().putNumber(false, "Target-Z", 0.00);

    driverStationNumber = DriverStation.getInstance().getLocation();

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
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
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
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    double angle = imu.getAngleZ();
    angle %= 360;

    Dashboard.getInstance().putNumber(false, "Gyro-Z", angle);

    targetZAngle = SmartDashboard.getNumber("Target-Z", 500);
    currentZAngle = SmartDashboard.getNumber("Gyro-Z", 500);

    if (targetZAngle > currentZAngle + 2) {
      // turn left
    } else if (targetZAngle < currentZAngle - 2) {
      // turn right
    } else {
      // no turn
    }

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    /*
     * Block[] blocks = pixy2USBJNI.blocksBuffer.poll();
     * 
     * Block[] blocks = pixy2USBJNI.blocksBuffer.poll();
     * 
     * if (blocks != null) { for (Block b : blocks) {
     * System.out.println(b.toString()); }
     * 
     * }
     */

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

  public int getDriveStationNumber() {
    return driverStationNumber;
  }

}
