package frc.team4546.robot;


import frc.team4546.robot.subsystems.OI.controllers.XboxController;
////import frc.team4546.robot.commands.AutoCollectCubeClosed;
//import frc.team4546.robot.commands.AutoCollectCubeOpened;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public XboxController driverController;
	public XboxController operatorController;
	
	public OI() {

		driverController = new XboxController(0, 0.1, 0.1);

		//driverController.leftTriggerButton.configureThreshold(0.075);

		//driverController.rightBumper.whenPressed(new AutoCollectCubeOpened(true));
		//driverController.leftBumper.whenPressed(new AutoCollectCubeClosed(true));
		//driverController.rightTriggerButton.whenPressed(new CollectorToggle());
		//driverController.leftTriggerButton.whileHeld(new CubeCollectorSpit());
		//driverController.bButton.whenPressed(new CubeCollectorStopCollectorAndRumble());
		//driverController.startButton.whenPressed(new DrivetrainBrakeMode());
		//driverController.leftStickButton.whenPressed(new DrivetrainShiftToggle());
		
				
	

		operatorController = new XboxController(1, 0.1, 0.1);
		
		//operatorController.leftTriggerButton.whenPressed(new GoToScaleMiddlePose());
		//operatorController.rightTriggerButton.whenPressed(new GoToCollectPose());
		//operatorController.leftBumper.whenPressed(new WristGoHome());
		//operatorController.rightBumper.whenPressed(new WristGoToExchange());
		//operatorController.aButton.whenPressed(new GoToDunkPose(0.0));
		///operatorController.bButton.whenPressed(new GoToScaleBottomPose());
		//operatorController.xButton.whenPressed(new GoToSwitchPose(0.0));
		//operatorController.yButton.whenPressed(new GoToScaleTopPose());
		//operatorController.startButton.whenPressed(new ElevatorShiftToggle());
		//operatorController.leftStickButton.whenPressed(new StopElevatorInPlace());
		
		
		//operatorController.Dpad.Down.whenPressed(new DeployForkliftThenRetract());
		//operatorController.Dpad.Up.whenPressed(new GoToClimbPose());		
		
		// ---------------test buttons-------------------//
		// operatorController.Dpad.Left.whenPressed(new ElevatorGoToSwitchPosition());
		// operatorController.Dpad.Down.whenPressed(new GoToCollectPose());

		// this.driverController.xButton.whenPressed(new DoubleSwitchLeft());
		// this.driverController.xButton.whenPressed(new FollowArc(new FifteenFeetArc()));

		// this.operatorController.xButton.whenPressed(new ElevatorMotionMagicTest());
		// this.operatorController.bButton.whenPressed(new ElevatorGoToHomePosition());
		// this.operatorController.Dpad.Up.whenPressed(new ElevatorGoToDunkPosition());
		// this.operatorController.Dpad.Down.whenPressed(new ElevatorGoToSwitchPosition());

	}
}