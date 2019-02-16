/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.vision.Cameras;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



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






	@Override
	public void robotInit() {

		Cameras.setup(); // Setup and Connection to Pixy2 and Microsoft Camera

		SmartDashboard.putBoolean("Pixy2 Light", false); // Addition of Pixy2 Lamp Toggle
		boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
		Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2

	}

	@Override

	public void robotPeriodic() {
		Cameras.run(); // Runs Pixy2 and Microsoft Camera

		boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
		Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2

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

	}

	@Override
	public void teleopPeriodic() {



	}

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


}
