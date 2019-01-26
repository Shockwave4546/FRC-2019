/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4546.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private PowerDistributionPanel m_PDP;

    private static final int kMotor1Port = 13;
    private Talon kMotor1;
    private double kMotor1Pos = .5;
    private double kMotor1Neg = -.5;

    private static final int kMotor2Port = 14;
    private Talon kMotor2;
    private double kMotor2Pos = .5;
    private double kMotor2Neg = .5;

    private static final int sUltrasonic1Port = 0;
    private AnalogInput sUltrasonic1;
    private double analogValue;
    
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

        xbox = new XboxController(0);
        joystick = new Joystick(1);
        
    }

    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //analogValue = getVoltage(sUltrasonic1);
        //System.out.println(analogValue);
        // IDK WHAT TO DO HERE
=======
=======
>>>>>>> parent of ae247e9... OK so, basicly, this is ready to code now
=======
>>>>>>> parent of ae247e9... OK so, basicly, this is ready to code now
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of ae247e9... OK so, basicly, this is ready to code now
=======
>>>>>>> parent of ae247e9... OK so, basicly, this is ready to code now
=======
>>>>>>> parent of ae247e9... OK so, basicly, this is ready to code now
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
