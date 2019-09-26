package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class shockwaveXbox {
    private XboxController cXbox;
    private double defaultDeadzone = .2;
    private double LeftY;
    private double deadzoneLeftY;
    private double LeftX;
    private double deadzoneLeftX;
    private double RightY;
    private double deadzoneRightY;
    private double RightX;
    private double deadzoneRightX;

    private boolean leftBumper;
    private boolean rightBumper;

    private boolean Abutton;
    private boolean Apress;
    private boolean Bbutton;
    private boolean Ybutton;
    private boolean Ypress;
    private boolean Xbutton;
    // private DPadButton dpad;
    private double leftTrigger;
    private double rightTrigger;

    private boolean backButton;
    private boolean startButton;
    private boolean startPress;


    public shockwaveXbox(final int port) {
        cXbox = new XboxController(port);
        deadzoneLeftY = defaultDeadzone;
        deadzoneLeftX = defaultDeadzone;
        deadzoneRightY = defaultDeadzone;
        deadzoneRightX = defaultDeadzone;

    }

    public shockwaveXbox(final int port, final double dead1, final double dead2, final double dead3,
            final double dead4) {
        cXbox = new XboxController(port);
        deadzoneLeftY = dead1;
        deadzoneLeftX = dead2;
        deadzoneRightY = dead3;
        deadzoneRightX = dead4;
    }

    public enum DPadDirection {
        NODIRECTION, UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT;

    }

    public DPadDirection getDPadDirection() {

        final int currentPOV = cXbox.getPOV();
        if (currentPOV == -1) {
            return DPadDirection.NODIRECTION;
        } else if ((currentPOV >= 355) || (currentPOV <= 5)) {
            return DPadDirection.UP;
        } else if ((currentPOV >= 5) && (currentPOV <= 85)) {
            return DPadDirection.UP_RIGHT;
        } else if ((currentPOV > 85) && (currentPOV < 95)) {
            return DPadDirection.RIGHT;
        } else if ((currentPOV >= 95) && (currentPOV <= 175)) {
            return DPadDirection.DOWN_RIGHT;
        } else if ((currentPOV > 175) && (currentPOV < 185)) {
            return DPadDirection.DOWN;
        } else if ((currentPOV >= 185) && (currentPOV <= 265)) {
            return DPadDirection.DOWN_LEFT;
        } else if ((currentPOV > 265) && (currentPOV < 275)) {
            return DPadDirection.LEFT;
        } else if ((currentPOV >= 275) && (currentPOV < 355)) {
            return DPadDirection.UP_LEFT;
        } else {
            return DPadDirection.NODIRECTION;
        }

    }

    public double getLeftY() {
        LeftY = cXbox.getY(Hand.kLeft);
        if (-deadzoneLeftY <= LeftY && LeftY <= deadzoneLeftY) {
            return 0;
        } else {
            return -LeftY;
        }
    }

    public double getLeftX() {
        LeftX = cXbox.getX(Hand.kLeft);
        if (-deadzoneLeftX <= LeftX && LeftX <= deadzoneLeftX) {
            return 0;
        } else {
            return -LeftX;
        }
    }

    public double getRightY() {
        RightY = cXbox.getY(Hand.kRight);
        if (-deadzoneRightY <= RightY && RightY <= deadzoneRightY) {
            return 0;
        } else {
            return RightY;
        }
    }

    public double getRightX() {
        RightX = cXbox.getX(Hand.kRight);
        if (-deadzoneRightX <= RightX && RightX <= deadzoneRightX) {
            return 0;
        } else {
            return RightX;
        }
    }


    public boolean getLeftBumper() {
        leftBumper = cXbox.getBumper(Hand.kLeft);
        return leftBumper;
    }

    public boolean getRightBumper() {
        rightBumper = cXbox.getBumper(Hand.kRight);
        return rightBumper;
    }

    public boolean getAbutton() {
        Abutton = cXbox.getAButton();
        return Abutton;
    }
    public boolean getAPress() {
        Apress = cXbox.getAButtonPressed();
        return Apress;
    }

    public boolean getBbutton() {
        Bbutton = cXbox.getBButton();
        return Bbutton;
    }

    public boolean getYbutton() {
        Ybutton = cXbox.getYButton();
        return Ybutton;
    }
    public boolean getYPress() {
        Ypress = cXbox.getYButtonPressed();
        return Ypress;
    }

    public boolean getXbutton() {
        Xbutton = cXbox.getXButton();
        return Xbutton;
    }

    public boolean getStartButton() {
        startButton = cXbox.getStartButton();
        return startButton;
    }
    public boolean getStartPressed() {
        startPress = cXbox.getStartButtonPressed();
        return startPress;
    }

    public boolean getBackButton() {
        backButton = cXbox.getBackButton();
        return backButton;
    }

    public double getLeftTrigger() {
        leftTrigger = cXbox.getTriggerAxis(Hand.kLeft);
        return leftTrigger;
    }

    public double getRightTrigger() {
        rightTrigger = cXbox.getTriggerAxis(Hand.kRight);
        return rightTrigger;
    }
}