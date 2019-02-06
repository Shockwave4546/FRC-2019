package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OIXbox {
	private static final int cXboxPort = 0;
	private XboxController cXbox;
	private double yAxisLeft;
	private double xAxisLeft;
	private double yAxisRight;
	private double xAxisRight;

	public OIXbox(){
		cXbox = new XboxController(cXboxPort);
	}

	public double getYAxisLeft(){
		yAxisLeft = cXbox.getY(Hand.kLeft);
		return yAxisLeft;
	}

	public double getXAxisLeft(){
		xAxisLeft = cXbox.getX(Hand.kLeft);
		return xAxisLeft;
	}

	public double getYAxisRight(){
		yAxisRight = cXbox.getY(Hand.kRight);
		return yAxisRight;
	}

	public double getXAxisRight(){
		xAxisRight = cXbox.getX(Hand.kRight);
		return xAxisRight;
	}
}