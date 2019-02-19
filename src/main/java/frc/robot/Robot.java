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
import com.analog.adis16448.frc.ADIS16448_IMU;
//import frc.robot.commands.coDriver;
//import frc.robot.commands.Driver;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Dashboard;
import frc.robot.subsystems.motors.talonMotor;
import frc.robot.controllers.shockwaveXbox;
import frc.robot.subsystems.sensors.ColorSensor;
//import frc.robot.subsystems.sensors.ColorSensor;

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

  public static final ADIS16448_IMU imu = new ADIS16448_IMU();
  public boolean straight = false;
  public static double currentZAngle = 0;
  public static String targetDirection = "NODIRECTION";
  public static double targetZAngle = -1;
  public static double angle = 0;
  public static shockwaveXbox xController;
  public talonMotor kLeftDrive = new talonMotor(0, .5, .5);
  public talonMotor kRightDrive = new talonMotor(1, .5, .5);
  public static ColorSensor ColorSensor;
  public double red;
  public double green;
  public double blue;

  // private Driver dRover1 = new Driver();
  // public static ColorSensor colorSensor;
  // double leftTrigger = xController.getLeftTrigger();
  // private coDriver dRover2 = new coDriver();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    imu.calibrate();
    imu.reset();

    xController = new shockwaveXbox(0);

    Cameras.setup(); // Setup and Connection to Pixy2 and Microsoft Camera
    SmartDashboard.putBoolean("Pixy2 Light", false); // Addition of Pixy2 Lamp Toggle
    boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2
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
    red = ColorSensor.getRed();
    green = ColorSensor.getGreen();
    blue = ColorSensor.getBlue();

    angle = (((imu.getAngleZ() + 36000) % 360));

    Dashboard.getInstance().putString(false, "DPad Value", xController.getDPadDirection().toString());

    Dashboard.getInstance().putNumber(false, "Current-Z", angle);

    // targetDirection = SmartDashboard.getString("DPad Value", "NODIRECTION");
    targetDirection = xController.getDPadDirection().toString();

    if (targetDirection == "NODIRECTION") {
      targetZAngle = -1;
    } else if (targetDirection == "UP") {
      targetZAngle = 0;
    } else if (targetDirection == "UP_RIGHT") {
      targetZAngle = 45;
    } else if (targetDirection == "RIGHT") {
      targetZAngle = 90;
    } else if (targetDirection == "DOWN_RIGHT") {
      targetZAngle = 135;
    } else if (targetDirection == "DOWN") {
      targetZAngle = 180;
    } else if (targetDirection == "DOWN_LEFT") {
      targetZAngle = 225;
    } else if (targetDirection == "LEFT") {
      targetZAngle = 270;
    } else if (targetDirection == "UP_LEFT") {
      targetZAngle = 315;
    }

    currentZAngle = SmartDashboard.getNumber("Current-Z", -1);

    if (targetZAngle == -1) {
      kLeftDrive.stopMotor();
      kRightDrive.stopMotor();

    } else {
      if (targetZAngle != -1) {

        if (targetZAngle == 0) {
          if ((currentZAngle >= 350) || (currentZAngle <= 10)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle) <= 180) {
            kLeftDrive.rotateCounterClockwise(0.5);
            kRightDrive.rotateCounterClockwise(0.5);
          } else {
            kLeftDrive.rotateClockwise(0.5);
            kRightDrive.rotateClockwise(0.5);
          }
        } else if (targetZAngle == 45) {
          if ((currentZAngle >= 40) && (currentZAngle <= 50)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
            System.out.println("STOP UP UR");
          } else if ((currentZAngle >= 225) || (currentZAngle < 40)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        } else if (targetZAngle == 90) {
          if ((currentZAngle >= 85) && (currentZAngle <= 95)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle >= 270) || (currentZAngle < 85)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        } else if (targetZAngle == 135) {
          if ((currentZAngle >= 130) && (currentZAngle <= 140)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle >= 315) || (currentZAngle < 130)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        } else if (targetZAngle == 180) {
          if ((currentZAngle >= 175) && (currentZAngle <= 185)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle < 175)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        } else if (targetZAngle == 225) {
          if ((currentZAngle >= 215) && (currentZAngle <= 235)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle > 45) && (currentZAngle < 220)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        } else if (targetZAngle == 270) {
          if ((currentZAngle >= 260) && (currentZAngle <= 280)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle > 90) && (currentZAngle < 260)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        } else if (targetZAngle == 315) {
          if ((currentZAngle >= 305) && (currentZAngle <= 325)) {
            kLeftDrive.stopMotor();
            kRightDrive.stopMotor();
          } else if ((currentZAngle > 135) && (currentZAngle < 320)) {
            kLeftDrive.rotateCounterClockwise(-0.5);
            kRightDrive.rotateCounterClockwise(-0.5);
          } else {
            kLeftDrive.rotateClockwise(-0.5);
            kRightDrive.rotateClockwise(-0.5);
          }

        }
      }
    }

    Cameras.run(); // Runs Pixy2 and Microsoft Camera
    boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2

    Dashboard.getInstance().putNumber(false, "Red", ColorSensor.getRed());
    Dashboard.getInstance().putNumber(false, "Blue", ColorSensor.getGreen());
    Dashboard.getInstance().putNumber(false, "Green", ColorSensor.getBlue());
    if (red > 20 && green > 30 && blue > 20) {
      kLeftDrive.stopMotor();
      kRightDrive.stopMotor();
    }

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
    imu.reset();
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
