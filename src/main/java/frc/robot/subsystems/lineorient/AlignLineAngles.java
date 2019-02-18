package frc.robot.subsystems.lineorient;
/*
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.subsystems.motors.talonMotor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
         
public class AlignLineAngles extends Subsystem {
	public talonMotor kLeftDrive = new talonMotor(0, .5, .5);
    public talonMotor kRightDrive = new talonMotor(1, .5, .5);
    public boolean straight = false;
    public static double currentZAngle = 0;
    public static double targetZAngle = 0;
	

	public AlignLineAngles() {
		
    }
    
    public void initDefaultCommand() {
        //// Set the default command for a subsystem here.
      }


	public void AlignUp(){
        targetZAngle = 0;
        turn();
    }
    public void AlignUp_Right(){
        targetZAngle = 45;
        turn();
    }
    public void AlignRight(){
        targetZAngle = 90;
        turn();
    }
    public void AlignDown_Right(){
        targetZAngle = 135;
        turn();
    }
    public void AlignDown(){
        targetZAngle = 180;
        turn();
    }
    public void AlignDown_Left(){
        targetZAngle = 225;
        turn();
    }
    public void AlignLeft(){
        targetZAngle = 270;
        turn();
    }
    public void AlignUp_Left(){
        targetZAngle = 315;
        turn();
    }

    public void turn() {

        SmartDashboard.putNumber("Target-Z", targetZAngle);
        currentZAngle = SmartDashboard.getNumber("Current-Z", 500);

        if ((targetZAngle + 10 <= currentZAngle) && (targetZAngle - 10 >= currentZAngle)) {
            stop();
        } else if ((targetZAngle - currentZAngle) >= 180) {
            turnLeft();
        } else if ((targetZAngle - currentZAngle) < 0) {
            turnLeft();
        } else {
            turnRight();
        }

    }

    public void turnLeft() {
        if (straight == false) {
            kLeftDrive.rotateClockwise(0.5);
            kRightDrive.rotateClockwise(0.5);
        }
    }

    public void turnRight() {
        if (straight == false) {
            kLeftDrive.rotateCounterClockwise(0.5);
            kRightDrive.rotateCounterClockwise(0.5);
        }
    }

    public void stop() {
        kLeftDrive.rotateCounterClockwise(0);
        kRightDrive.rotateCounterClockwise(0);
        straight = true;
    }

    public void start() {
        straight = false;
    }

}
*/