
package frc.team4546.robot;

import frc.team4546.robot.commands.driveBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4546.robot.controllers.DPad;
import frc.team4546.robot.RobotMap;
import frc.team4546.robot.commands.*;


/**
 * The glue that binds the controls on the physical operator interface to the
 * commands and command groups that allow control of the robot.
 */
public class OI {

	// DRIVER
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
	private Button driverDPadUp = new DPad(driver, DPad.Direction.up);
	private Button driverDPadDown = new DPad(driver, DPad.Direction.down);
	private Button driverDPadRight = new DPad(driver, DPad.Direction.right);
	private Button driverDPadLeft = new DPad(driver, DPad.Direction.left);
	private Button driverDPadUpRight = new DPad(driver, DPad.Direction.up);
	private Button driverDPadUpLeft = new DPad(driver, DPad.Direction.down);
	private Button driverDPadDownRight = new DPad(driver, DPad.Direction.right);
	private Button driverDPadDownLeft = new DPad(driver, DPad.Direction.left);


	// CO-DRIVER
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
	private Button coDriverDPadUp = new DPad(coDriver, DPad.Direction.up);
	private Button coDriverDPadDown = new DPad(coDriver, DPad.Direction.down);
	private Button coDriverDPadRight = new DPad(coDriver, DPad.Direction.right);
	private Button coDriverDPadLeft = new DPad(coDriver, DPad.Direction.left);

	// Climber - positive climb/roll-in; negative unclimb/roll-out
	public OI() {

		// Buttons
		 driverA.whenPressed(new FollowBall());
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
