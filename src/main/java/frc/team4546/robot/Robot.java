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
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Talon;


public class Robot extends TimedRobot {
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
        System.out.println(analogValue);
    }
}