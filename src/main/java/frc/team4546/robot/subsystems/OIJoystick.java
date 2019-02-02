package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class OIJoystick {
	private static final int cJoystickPort = 1;
	private Joystick cJoystick;
	private double yAxis;
	private double xAxis;
	private double twist;
	private double slider;
	/*private double button1;
	private double button2;
	private double button3;
	private double button4;
	private double button5;
	private double button6;
	private double button7;
	private double button8;
	private double button9;
	private double button10;
	private double button11;
	private double button12;*/

	public OIJoystick(){
		cJoystick = new Joystick(cJoystickPort);
	}

	public double getYAXIS(){
		yAxis = cJoystick.getY();
		return yAxis;
	}

	public double getXAXIS(){
		xAxis = cJoystick.getX();
		return xAxis;
	}

	public double getTwist(){
		twist = cJoystick.getTwist();
		return twist;
	}

	public double getThrottle(){
		slider = (cJoystick.getThrottle() - 1);
		return slider;
	}
}