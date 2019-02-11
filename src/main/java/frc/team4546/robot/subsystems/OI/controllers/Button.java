package frc.team4546.robot.subsystems.OI.controllers;

import frc.team4546.robot.subsystems.OI.controllers.XboxController.XboxButton;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Button extends JoystickButton {

	public Button(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
	}

	public Button(XboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}


}