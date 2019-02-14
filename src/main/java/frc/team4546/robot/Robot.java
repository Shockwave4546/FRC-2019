/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;

import frc.team4546.robot.subsystems.vision.Cameras;
import frc.team4546.robot.Dashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import com.analog.adis16448.frc.ADIS16448_IMU;
//import frc.team4546.robot.subsystems.limitSwitch;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4546.robot.subsystems.OI.motors.talonMotor;
import frc.team4546.robot.subsystems.adis16448.Gyroscope;
import java.lang.Math;

import frc.team4546.robot.commands.TogglePixy2LampCommand;
import frc.team4546.robot.subsystems.vision.Pixy2USBJNI;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final Pixy2USBJNI pixy2USBJNI = new Pixy2USBJNI();
	/**
	 * DO NOT MODIFY
	 */

	private int driverStationNumber = 0;
	public double negzangle = 360;
	public double currentZAngle = 360;
	public double targetZAngle = 360;

	public static final ADIS16448_IMU imu = new ADIS16448_IMU();
	public talonMotor kLeftDrive = new talonMotor(0, .2, .2);
	public talonMotor kRightDrive = new talonMotor(1, .2, .2);

	@Override
	public void robotInit() {
		imu.calibrate();
		Dashboard.getInstance().putNumber(false, "Target-Z", 0.00);

		driverStationNumber = DriverStation.getInstance().getLocation();

		Thread pixy2USBThread = new Thread(pixy2USBJNI);
		pixy2USBThread.setDaemon(true);
		pixy2USBThread.start();

		Cameras.setup(); // Setup and Connection to Pixy2 and Microsoft Camera

		// SmartDashboard.putBoolean("Pixy2 Light", false); // Addition of Pixy2 Lamp
		// Toggle
		// boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
		// Cameras.light(PixyLightState); // Sends Current state of Toggle Button to
		// Pixy2

	}

	@Override

	public void robotPeriodic() {
		Scheduler.getInstance().run();

		Dashboard.getInstance().putNumber(false, "Gyro-X", imu.getAngleX());
		Dashboard.getInstance().putNumber(false, "Gyro-Y", imu.getAngleY());

		Dashboard.getInstance().putNumber(false, "Accel-X", imu.getAccelX());
		Dashboard.getInstance().putNumber(false, "Accel-Y", imu.getAccelY());
		Dashboard.getInstance().putNumber(false, "Accel-Z", imu.getAccelZ());

		Dashboard.getInstance().putNumber(false, "Pitch", imu.getPitch());
		Dashboard.getInstance().putNumber(false, "Roll", imu.getRoll());
		Dashboard.getInstance().putNumber(false, "Yaw", imu.getYaw());

		Dashboard.getInstance().putNumber(false, "Pressure: ", imu.getBarometricPressure());
		Dashboard.getInstance().putNumber(false, "Temperature: ", imu.getTemperature());

		// boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
		// Cameras.light(PixyLightState); // Sends Current state of Toggle Button to
		// Pixy2

	}

	/**
	 * Disabled
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
	}

	/**
	 * Teleoperated
	 */
	@Override
	public void teleopInit() {
		imu.reset();
	}

	@Override
	public void teleopPeriodic() {
		Cameras.run(); // Runs Pixy2 and Microsoft Camera

	}
	/*----------------------------------------------------------------------------*/
	// }

	/**
	 * Autonomous
	 */
	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
	}

	/**
	 * Test
	 */
	@Override
	public void testInit() {

	}

	@Override
	public void testPeriodic() {
	}

	public int getDriveStationNumber() {
		return driverStationNumber;
	}

}
