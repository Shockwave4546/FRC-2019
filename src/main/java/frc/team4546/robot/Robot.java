/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;


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
	
    private static final int sUltrasonic1Port = 0;
    private AnalogInput sUltrasonic1;
	private double analogValue;
	
    private int bits;
    private int raw;
    private double volts;
    private int averageRaw;
    private double averageVolts;



	@Override
	public void robotInit() {
        sUltrasonic1 = new AnalogInput(sUltrasonic1Port);
        
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
		//sUltrasonic1.setOversampleBits(10);
		//sUltrasonic1.setAverageBits(10);
		AnalogInput.setGlobalSampleRate(62500);
		raw = sUltrasonic1.getValue();
        volts = sUltrasonic1.getVoltage();
        averageRaw = sUltrasonic1.getAverageValue();
        averageVolts = sUltrasonic1.getAverageVoltage();
		analogValue = raw * 5;
		System.out.println(analogValue);
		//System.out.println("Value:"+raw * 5);
		//System.out.println("Voltage:"+volts * 5);
		//System.out.println("AvgValue:"+averageRaw * 5);
		//System.out.println("AvgVoltage:"+averageVolts * 5);
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
