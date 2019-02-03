/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.team4546.robot.subsystems.limitSwitch;


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
	private limitSwitch sLimitSwitch1 = new limitSwitch(0);
	private limitSwitch sLimitSwitch2 = new limitSwitch(1, true);

	@Override
	public void robotInit() {
        
    }

	@Override
	public void robotPeriodic() { 
		
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
		System.out.println(sLimitSwitch2.getValue());
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
