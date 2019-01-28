/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;





import frc.team4546.robot.subsystems.vision.Cameras;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
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





	private int driverStationNumber = 0;



	@Override
	public void robotInit() {
		
		driverStationNumber = DriverStation.getInstance().getLocation();
		Cameras.setup();

		SmartDashboard.putBoolean("Pixy2 Light", false);
		boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
		Cameras.light(PixyLightState);

		
	}

	@Override
	public void robotPeriodic() {
		Scheduler.getInstance().run();
		Cameras.run();

		boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
		Cameras.light(PixyLightState);
	
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

	public int getDriveStationNumber() {
		return driverStationNumber;
	}


	



}
