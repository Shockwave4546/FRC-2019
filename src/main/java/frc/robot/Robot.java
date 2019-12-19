package frc.robot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.motors.talonMotor;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

public class Robot extends TimedRobot {


  //public static Timer timer;
  PowerDistributionPanel pdp = new PowerDistributionPanel();
  //SendableChooser rotateChooser = new SendableChooser<>();
  SendableChooser motorChooser = new SendableChooser<>();
  public static double drivePos;
  public static double driveNeg;
  public static double rotation;
  //public static Object motorPort;
  public static double[] motorPortArr = {0, 1, 2, 3, 4};
  public static double[] rotationalArr = {-1, -0.75, -0.5, -0.25, 0, 0.25, 0.5, 0.75, 1};
  public static talonMotor motor;
  public static talonMotor talon0 = new talonMotor(0, 0, 0);
  public static talonMotor talon1 = new talonMotor(1, 0, 0);
  public static talonMotor talon2 = new talonMotor(2, 0, 0);
  public static talonMotor talon3 = new talonMotor(3, 0, 0);
  public static talonMotor talon4 = new talonMotor(4, 0, 0);

  public ShuffleboardTab tab = Shuffleboard.getTab("Smartdashboard");
  public NetworkTableEntry speed;

  //public ShuffleboardTab tab = Shuffleboard.getTab("Smartdashboard");

  @Override
  public void robotInit() {
    motor = talon1;
    /*
    rotateChooser.addDefault("0", 0.0);
    rotateChooser.addObject("-1",-1.0);
    rotateChooser.addObject("-0.75",-0.75);
    rotateChooser.addObject("-0.5",-0.5);
    rotateChooser.addObject("-0.25",-0.25);
    rotateChooser.addObject("0.25",0.25);
    rotateChooser.addObject("0.5",0.5);
    rotateChooser.addObject("0.75",0.75);
    rotateChooser.addObject("1",1.0);
    
    SmartDashboard.putData("Rotate Speed",rotateChooser);
    */
    motorChooser.addDefault("0", 0);
    motorChooser.addObject("1", 1);
    motorChooser.addObject("2", 2);
    motorChooser.addObject("3", 3);
    motorChooser.addObject("4", 4);
    
    

    SmartDashboard.putData("Motor Select", motorChooser);

   
    speed = tab.add("Rotate Speed", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry();

  }

  @Override
  public void robotPeriodic() {
    int motorPort = (int) motorChooser.getSelected();

    //rotation = (double) rotateChooser.getSelected();


    switch(motorPort){
    case 0:
      motor = talon0;
      break;
    
    case 1:
      motor = talon1;
      break;

    case 2:
      motor = talon2;
      break;
      
    case 3:
      motor = talon3;
      break;
      
    case 4:
      motor = talon4;
      break;

    default:
      motor = null;
      break;
    }

    SmartDashboard.putNumber("Current", pdp.getTotalCurrent());
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
    teleopPeriodic();

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    motor.rotateMotor(speed.getDouble(0.0));
  }

  @Override
  public void testPeriodic() {

  }
}