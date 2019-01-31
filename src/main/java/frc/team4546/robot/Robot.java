/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;


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
	private PowerDistributionPanel m_PDP;

    private static final int kMotor1Port = 13;
    private Talon kMotor1;
    private double kMotor1Pos = .5;
    private double kMotor1Neg = -.5;

    private static final int kMotor2Port = 14;
    private Talon kMotor2;
    private double kMotor2Pos = .5;
    private double kMotor2Neg = -.5;

    private static final int sUltrasonic1Port = 0;
    private AnalogInput sUltrasonic1;
    private double analogValue;
    private int bits;
    private int raw;
    private double volts;
    private int averageRaw;
    private double averageVolts;
    
    public XboxController xbox;

    public Joystick joystick;


	@Override
	public void robotInit() {
		m_PDP = new PowerDistributionPanel(0);
        
        kMotor1 = new Talon(kMotor1Port);
        kMotor1.setInverted(false);
        
        kMotor2 = new Talon(kMotor2Port);
        kMotor2.setInverted(false);
        
        sUltrasonic1 = new AnalogInput(sUltrasonic1Port);
        
        /*sUltrasonic1.setOversampleBits(4);
        bits = sUltrasonic1.getOversampleBits();
        sUltrasonic1.setAverageBits(2);
        bits = sUltrasonic1.getAverageBits();*/

        raw = sUltrasonic1.getValue();
        volts = sUltrasonic1.getVoltage();
        averageRaw = sUltrasonic1.getAverageValue();
        averageVolts = sUltrasonic1.getAverageVoltage();

        xbox = new XboxController(0);
        joystick = new Joystick(1);
        
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
		Scheduler.getInstance().run();
        analogValue = averageVolts;
        System.out.println(analogValue);
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
