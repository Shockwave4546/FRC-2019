/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;



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
	// Drivebase motors
	private static final int kMotorPort0 = 0;
	private PWM kLeftMotor;
	private double kLeftMotorPos = .5;
	private double kLeftMotorNeg = -.5;

	private static final int kMotorPort1 = 1;
	private PWM kRightMotor;
	private double kRightMotorPos = .5;
	private double kRightMotorNeg = -.5;
	
	private static final int cXboxPort = 0;
	private XboxController cXbox;
	private double yAxisLeft;
	private double xAxisLeft;
	private double yAxisRight;
	private double xAxisRight;

	private static final int cJoystickPort = 1;
	private Joystick cJoystick;
	private double yAxis;
	private double xAxis;
	private double zAxis;
	private double slider;

	@Override
	public void robotInit() {
		kLeftMotor = new PWM(kMotorPort0);

		kRightMotor = new PWM(kMotorPort1);

		cXbox = new XboxController(cXboxPort);
		cJoystick = new Joystick(cJoystickPort);
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
