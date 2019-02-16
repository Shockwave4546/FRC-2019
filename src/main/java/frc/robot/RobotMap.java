
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

        public static final int LeftIntakePort = 0;
        public static final int RightIntakePort = 1;

        public static final int LinearSlidePort = 2;
        public static final int IntakePivotPort = 3;


    // CAN IDs //
        public static final int LeftDrivePort = 1;
        public static final int RightDrivePort = 2;
        // public static final int PCMone = 0;
        // public static final int PCMtwo = 1;

    // Digital Channels //
        // public static final int DRIVE_LEFT_ENCODER = 1;
        // public static final int DRIVE_RIGHT_ENCODER = 2;

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

        public static final double ArmPivotPos = .2;
        public static final double ArmPivotNeg = .2;
        
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

