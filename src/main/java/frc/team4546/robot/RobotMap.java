package frc.team4546.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Joystick Ports //
    public static final int XboxDriver = 0;
    public static final int XboxCoDriver = 1;


    // PWM Channels //
        // public static final int DRIVE_TALONSR_LEFT_CHANNEL = 0;

    // CAN IDs //
        // public static final int PCMone = 0;
        // public static final int PCMtwo = 1;

    // Digital Channels //
        // public static final int DRIVE_LEFT_ENCODER = 1;
        // public static final int DRIVE_RIGHT_ENCODER = 2;

    // Solenoid Channels //

    // Drive Train Motor Speeds (POS & NEG) //
        public static final double LeftDrivePos = 1.0;
        public static final double LeftDriveNeg = 1.0;
        public static final double RightDrivePos = 1.0;
        public static final double RightDriveNeg = 1.0;

    // Misc Motor Speeds //

    // Lift Positions //
         public static final int GroundLevelBall = 1420; 

        public static final int LowHatchPanelHeight = 1420; // Same as Ground Level for Alliance Station and Cargo Ship and First Level Rocket.
        public static final int MidHatchPanelHeight = 1420;
        public static final int HighHatchPanelHeight = 1420;

        public static final int CargoShipBallHeight = 1420; // Cargo Ship Ball Height
        public static final int RocketLowBallHeight = 1420; // Rocket Ball Low
        public static final int RocketMidBallHeight = 1420; // Rocket Ball Mid
        public static final int RocketHighBallHeight = 1420; // Rocket Ball High

}