package frc.team4546.robot.subsystems.OI.controllers;

import frc.team4546.robot.subsystems.OI.controllers.AxisButton.ThresholdType;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick {

	public XboxController(int port) {
		super(port);
	}

	public XboxController(int port, double xDeadband, double yDeadband) {
		this(port);
		this.leftStick.setDeadband(xDeadband, yDeadband);
		this.rightStick.setDeadband(xDeadband, yDeadband);
	}


	public AxisButton leftTriggerButton = new AxisButton(this, XboxAxis.LEFT_TRIGGER, .25, ThresholdType.GREATER_THAN);
	public AxisButton rightTriggerButton = new AxisButton(this, XboxAxis.RIGHT_TRIGGER, .25,
			ThresholdType.GREATER_THAN);
	public Dpad Dpad = new Dpad(this);

	public ThumbStick leftStick = new ThumbStick(this, XboxAxis.LEFT_X, XboxAxis.LEFT_Y);
	public ThumbStick rightStick = new ThumbStick(this, XboxAxis.RIGHT_X, XboxAxis.RIGHT_Y);

	public Triggers triggers = new Triggers(this);

	public void setRumble(double leftValue, double rightValue) {
		setRumble(RumbleType.kLeftRumble, leftValue);
		setRumble(RumbleType.kRightRumble, rightValue);
	}

	static enum XboxButton {

		A(1), B(2), X(3), Y(4), LEFT_BUMPER(5), RIGHT_BUMPER(6), SELECT(7), START(8), LEFT_STICK(9), RIGHT_STICK(10);

		final int value;

		XboxButton(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	static enum XboxAxis {
		LEFT_X(0), LEFT_Y(1), LEFT_TRIGGER(2), RIGHT_TRIGGER(3), RIGHT_X(4), RIGHT_Y(5), DPAD(6);

		final int value;

		XboxAxis(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	static enum XboxDpad {
		UNPRESSED(-1), UP(0), UP_RIGHT(45), RIGHT(90), DOWN_RIGHT(135), DOWN(180), DOWN_LEFT(225), LEFT(270),
		UP_LEFT(315);

		final int value;

		XboxDpad(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

}