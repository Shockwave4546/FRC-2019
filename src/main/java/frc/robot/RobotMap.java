
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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

        public static final int LeftIntakePort = 0;     // Motor Controller n/a -PDP: 5
        public static final int RightIntakePort = 1;    // Motor Controller 1   -PDP: 7

        public static final int LinearSlidePort = 2;    // Motor Controller 2   -PDP: 0

        public static final int ClimbDriveLeft = 3;     // Motor Controller 3   -PDP: 1
        public static final int ClimbDriveRight = 4;    // Motor Controller 4   -PDP: 2

        public static final int ClimbPivotPort = 5;     // Motor Controller 5   -PDP: 3


    // CAN IDs //
        public static final int LeftDrivePort = 1;      // SparkMax Motor 1     -PDP: 12
        public static final int RightDrivePort = 2;     // SparkMax Motor 2     -PDP: 14
        // public static final int PCMone = 0;
        // public static final int PCMtwo = 1;

    // Digital Channels //
        public static final int sSlideEncoder1 = 0;     // Linear Slide Encoder
        public static final int sSlideEncoder2 = 1;

        public static final int sClimbEncoder1 = 2;     // Climb Mechanism Encoder
        public static final int sClimbEncoder2 = 3;

        public static final int sLimitSwitch1 = 4;      // Linear Slide Reset Switch???

    // Solenoid Channels //

    // Drive Train Motor Speeds (POS & NEG) //
        public static final double LeftDrivePos = .3;
        public static final double LeftDriveNeg = .3;

        public static final double RightDrivePos = .3;
        public static final double RightDriveNeg = .3;

    // Misc Motor Speeds //
        public static final double LeftIntakePos = .5;
        public static final double LeftIntakeNeg = .5;

        public static final double RightIntakePos = .5;
        public static final double RightIntakeNeg = .5;

        public static final double LinearSlidePos = .5;
        public static final double LinearSlideNeg = .5;

        public static final double LeftClimbDrivePos = .3;
        public static final double LeftClimbDriveNeg = .3;

        public static final double RightClimbDrivePos = .3;
        public static final double RightClimbDriveNeg = .3;

        public static final double ArmPivotPos = .2;
        public static final double ArmPivotNeg = .2;
        
    // Lift Positions //
        public static final int GroundLevelBall = 1420; 
        
        // Ground Hatch             - 1'7"
        public static final int LowHatchPanelHeight = 1420; // Same as Ground Level for Alliance Station and Cargo Ship and First Level Rocket.
        // Rocket Hatch Mid         - 3'11"
        public static final int MidHatchPanelHeight = 1420;
        // Rocket Hatch High        - 6'3"
        public static final int HighHatchPanelHeight = 1420;
        
        // Cargo Ship Ball Height   - > 2'7.5"
        public static final int CargoShipBallHeight = 1420;
        // Rocket Ball Low          - 2'3.5"
        public static final int RocketLowBallHeight = 1420;
        // Rocket Ball Mid          - 4'7.5"
        public static final int RocketMidBallHeight = 1420;
        // Rocket Ball High         - 6'11.5"
        public static final int RocketHighBallHeight = 1420;

}

