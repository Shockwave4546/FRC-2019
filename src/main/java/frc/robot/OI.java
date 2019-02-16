
package frc.robot;

import frc.robot.commands.driveBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.controllers.DPadButton;
import frc.robot.commands.*;
import frc.robot.RobotMap;

/**
 * The glue that binds the controls on the physical operator interface to the
 * commands and command groups that allow control of the robot.
 */
public class OI {

	/**
	 * MAIN DRIVER CONTROLS (XBOX CONTROLLER 1)
	 */
	private Joystick driver = new Joystick(RobotMap.XboxDriver);
	private Button driverA = new JoystickButton(driver, 1);
	private Button driverB = new JoystickButton(driver, 2);
	private Button driverX = new JoystickButton(driver, 3);
	private Button driverY = new JoystickButton(driver, 4);
	private Button driverLB = new JoystickButton(driver, 5);
	private Button driverRB = new JoystickButton(driver, 6);
	private Button driverBack = new JoystickButton(driver, 7);
	private Button driverStart = new JoystickButton(driver, 8);
	private Button driverLS = new JoystickButton(driver, 9);
	private Button driverRS = new JoystickButton(driver, 10);
	// DPad Buttoms
	private Button driverDPadUp = new DPadButton(driver, DPadButton.Direction.UP);
	private Button driverDPadDown = new DPadButton(driver, DPadButton.Direction.DOWN);
	private Button driverDPadRight = new DPadButton(driver, DPadButton.Direction.RIGHT);
	private Button driverDPadLeft = new DPadButton(driver, DPadButton.Direction.LEFT);
	private Button driverDPadUpLeft = new DPadButton(driver, DPadButton.Direction.UP_LEFT);
	private Button driverDPadUpRight = new DPadButton(driver, DPadButton.Direction.UP_RIGHT);
	private Button driverDPadDownLeft = new DPadButton(driver, DPadButton.Direction.DOWN_LEFT);
	private Button driverDPadDownRight = new DPadButton(driver, DPadButton.Direction.DOWN_RIGHT);

	/**
	 * Co Driver CONTROLS (XBOX CONTROLLER 2)
	 */
	private Joystick coDriver = new Joystick(RobotMap.XboxCoDriver);
	private Button coDriverA = new JoystickButton(coDriver, 1);
	private Button coDriverB = new JoystickButton(coDriver, 2);
	private Button coDriverX = new JoystickButton(coDriver, 3);
	private Button coDriverY = new JoystickButton(coDriver, 4);
	private Button coDriverLB = new JoystickButton(coDriver, 5);
	private Button coDriverRB = new JoystickButton(coDriver, 6);
	private Button coDriverBack = new JoystickButton(coDriver, 7);
	private Button coDriverStart = new JoystickButton(coDriver, 8);
	private Button coDriverLS = new JoystickButton(coDriver, 9);
	private Button coDriverRS = new JoystickButton(coDriver, 10);
	// DPad Buttoms
	private Button coDriverDPadUp = new DPadButton(coDriver, DPadButton.Direction.UP);
	private Button coDriverDPadDown = new DPadButton(coDriver, DPadButton.Direction.DOWN);
	private Button coDriverDPadRight = new DPadButton(coDriver, DPadButton.Direction.RIGHT);
	private Button coDriverDPadLeft = new DPadButton(coDriver, DPadButton.Direction.LEFT);
	private Button coDriverDPadUpLeft = new DPadButton(coDriver, DPadButton.Direction.UP_LEFT);
	private Button coDriverDPadUpRight = new DPadButton(coDriver, DPadButton.Direction.UP_RIGHT);
	private Button coDriverDPadDownLeft = new DPadButton(coDriver, DPadButton.Direction.DOWN_LEFT);
	private Button coDriverDPadDownRight = new DPadButton(coDriver, DPadButton.Direction.DOWN_RIGHT);

	// Climber - positive climb/roll-in; negative unclimb/roll-out
	public OI() {

		// Buttons

		// driverA.whenPressed();
		// driverA.whenReleased();
		// driverX.whenPressed();

		// driverBack.whenPressed(new Shoot());

		// driverB.whenPressed();
		// driverB.whenReleased();

		// driverX.whenReleased();
		// driverY.whenPressed();

		// coDriverRB.whenPressed();
		// coDriverLB.whenPressed();

		// coDriverA.whenPressed();
		// coDriverY.whenReleased();
		// coDriverB.whenPressed();
		// coDriverY.whenPressed();

		// driverStart.whenPressed();
		// driverStart.whenReleased();

	}

}
