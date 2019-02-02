package frc.team4546.robot;

import frc.team4546.robot.subsystems.vision.Cameras;
import frc.team4546.robot.subsystems.ColorSensor;

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
import edu.wpi.first.wpilibj.DriverStation;

public class Robot extends TimedRobot {

  private int driverStationNumber = 0;

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
  private int bits;
  private int raw;
  private double volts;
  private int averageRaw;
  private double averageVolts;

  public XboxController xbox;

  public Joystick joystick;

  @Override
  public void robotInit() {
    driverStationNumber = DriverStation.getInstance().getLocation();
    Cameras.setup(); // Setup and Connection to Pixy2 and Microsoft Camera

    SmartDashboard.putBoolean("Pixy2 Light", false); // Addition of Pixy2 Lamp Toggle
    boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2

    ColorSensor.setup();

    m_PDP = new PowerDistributionPanel(0);

    kMotor1 = new Talon(kMotor1Port);
    kMotor1.setInverted(false);

    kMotor2 = new Talon(kMotor2Port);
    kMotor2.setInverted(false);

    sUltrasonic1 = new AnalogInput(sUltrasonic1Port);

    /*
     * sUltrasonic1.setOversampleBits(4); bits = sUltrasonic1.getOversampleBits();
     * sUltrasonic1.setAverageBits(2); bits = sUltrasonic1.getAverageBits();
     */

    raw = sUltrasonic1.getValue();
    volts = sUltrasonic1.getVoltage();
    averageRaw = sUltrasonic1.getAverageValue();
    averageVolts = sUltrasonic1.getAverageVoltage();

    xbox = new XboxController(0);
    joystick = new Joystick(1);

  }

  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
    Cameras.run(); // Runs Pixy2 and Microsoft Camera

    boolean PixyLightState = SmartDashboard.getBoolean("Pixy2 Light", false);
    Cameras.light(PixyLightState); // Sends Current state of Toggle Button to Pixy2

  }

  @Override
  public void disabledInit() {

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
    // analogValue = getVoltage(sUltrasonic1);
    System.out.println(analogValue);
  }

  public int getDriveStationNumber() {
    return driverStationNumber;
  }

}