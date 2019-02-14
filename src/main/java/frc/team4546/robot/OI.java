package frc.team4546.robot;

import frc.team4546.robot.commands.driveBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4546.robot.controllers.DPad;
import frc.team4546.robot.RobotMap;
/**
 * The glue that binds the controls on the physical operator interface to the
 * commands and command groups that allow control of the robot.
 */
public class OI {

	public static class DirectionalPad extends Button { 
		 
		/**
    	 * This is the relation of direction and number for .getPOV() used 
    	 * in the DirectionalPad class. 
     	*/ 
   		public static enum DPAD { 
       	 	UP          (0), 
        	UP_RIGHT    (45), 
        	RIGHT       (90), 
        	DOWN_RIGHT  (135), 
        	DOWN        (180), 
        	DOWN_LEFT   (225),
        	LEFT        (270), 
       	 	UP_LEFT     (315); 
         
        	/* Instance Value */ 
        	private int value; 
         
       		 /**
         	* Constructor 
        	 * @param value 
        	 */ 
        	DPAD(final int value) { 
            	this.value = value; 
        	} 
         
        	/**
        	 * Convert integers to DPAD values 
        	 * @param value 
         	* @return DPAD with matching angle 
			 */ 
			 
        	public static DPAD getEnum(int angle) { 
           		 angle = Math.abs(angle); 
            	angle %= 360; 
            	angle = Math.round(angle / 45) * 45;    // May have rounding errors. Due to rounding errors. 
             
            	DPAD[] all = DPAD.values(); 
             
            	for(int i = 0; i < all.length; i++) { 
               		 if (all[i].value == angle) { 
                   		 return all[i] ; 
                	} 
           		 } 
            return DPAD.UP; 
        } 
   	 }

        /* Instance Values */ 
        private final   Joystick    parent; 
         
        public final    Button      up; 
        public final    Button      upRight; 
        public final    Button      right; 
        public final    Button      downRight; 
        public final    Button      down; 
        public final    Button      downLeft; 
        public final    Button      left; 
        public final    Button      upLeft; 
         
        /**
         * Constructor 
         * @param parent 
         */ 
        DirectionalPad(final Joystick parent) { 
             
            /* Initialize */ 
            this.parent     = parent; 
            this.up         = new DPadButton(this, DPAD.UP); 
            this.upRight    = new DPadButton(this, DPAD.UP_RIGHT); 
            this.right      = new DPadButton(this, DPAD.RIGHT); 
            this.downRight  = new DPadButton(this, DPAD.DOWN_RIGHT); 
            this.down       = new DPadButton(this, DPAD.DOWN); 
            this.downLeft   = new DPadButton(this, DPAD.DOWN_LEFT); 
            this.left       = new DPadButton(this, DPAD.LEFT); 
            this.upLeft     = new DPadButton(this, DPAD.UP_LEFT); 
        } 
         
        /**
         * This class is used to represent each of the 8 values a 
         * dPad has as a button. 
         */ 
        public static class DPadButton extends Button { 
             
            /* Instance Values */ 
            private final DPAD              direction; 
            private final DirectionalPad    parent; 
             
            /**
             * Constructor 
             * @param parent 
             * @param dPad 
             */ 

            DPadButton(final DirectionalPad parent, final DPAD dPadDirection) { 
                /* Initialize */ 
                this.direction  = dPadDirection; 
                this.parent     = parent; 
            } 
             
            /* Extended Methods */ 
            @Override 
            public boolean get() { 
                return parent.getAngle() == direction.value; 
            } 
        } 
         
        private int angle() { 
            return parent.getPOV(); 
        } 
         
        /* Extended Methods */ 
        @Override 
        public boolean get() { 
            return angle() != -1; 
        } 
         
        /* Get Methods */ 
        /**
         * UP          0; 
         * UP_RIGHT    45; 
         * RIGHT       90; 
         * DOWN_RIGHT  135; 
         * DOWN        180; 
         * DOWN_LEFT   225; 
         * LEFT        270; 
         * UP_LEFT     315; 
         * @return A number between 0 and 315 indicating direction 
         */ 
        public int getAngle() { 
            return angle(); 
        } 
         
        /**
         * Just like getAngle, but returns a direction instead of an angle 
         * @return A DPAD direction 
         */ 
        public DPAD getDirection() { 
			return DPAD.getEnum(angle()); 
        } 
    } 

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
