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
    private boolean leftBumperPress;
    private boolean leftBumperRelease;
    private boolean rightBumper;
    private boolean rightBumperPress;
    private boolean rightBumperRelease;

    private double leftTrigger;
    private double rightTrigger;

    private boolean Abutton;
    private boolean Apress;
    private boolean Arelease;

    private boolean Bbutton;
    private boolean Bpress;
    private boolean Brelease;

    private boolean Ybutton;
    private boolean Ypress;
    private boolean Yrelease;

    private boolean Xbutton;
    private boolean Xpress;
    private boolean Xrelease;
    // private DPadButton dpad;

    private boolean backButton;
    private boolean backPress;
    private boolean backRelease;
    private boolean startButton;
    private boolean startPress;
    private boolean startRelease;


    public shockwaveXbox(final int port) {
        cXbox = new XboxController(port);
        deadzoneLeftY = defaultDeadzone;
        deadzoneLeftX = defaultDeadzone;
        deadzoneRightY = defaultDeadzone;
        deadzoneRightX = defaultDeadzone;

    }

    public shockwaveXbox(final int port, final double deadzone) {
        cXbox = new XboxController(port);
        deadzoneLeftY = deadzone;
        deadzoneLeftX = deadzone;
        deadzoneRightY = deadzone;
        deadzoneRightX = deadzone;
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

    //-----Left Y Axis-----
    public double getLeftY() {
        LeftY = cXbox.getY(Hand.kLeft);
        if (-deadzoneLeftY <= LeftY && LeftY <= deadzoneLeftY) {
            return 0;
        } else {
            return -LeftY;
        }
    }

    //-----Left X Axis-----
    public double getLeftX() {
        LeftX = cXbox.getX(Hand.kLeft);
        if (-deadzoneLeftX <= LeftX && LeftX <= deadzoneLeftX) {
            return 0;
        } else {
            return -LeftX;
        }
    }

    //-----Right Y Axis-----
    public double getRightY() {
        RightY = cXbox.getY(Hand.kRight);
        if (-deadzoneRightY <= RightY && RightY <= deadzoneRightY) {
            return 0;
        } else {
            return RightY;
        }
    }

    //-----Right X Axis-----
    public double getRightX() {
        RightX = cXbox.getX(Hand.kRight);
        if (-deadzoneRightX <= RightX && RightX <= deadzoneRightX) {
            return 0;
        } else {
            return RightX;
        }
    }
    
    //-----Left Trigger-----
    public double getLeftTrigger() {
        leftTrigger = cXbox.getTriggerAxis(Hand.kLeft);
        return leftTrigger;
    }

    //-----Right Trigger-----
    public double getRightTrigger() {
        rightTrigger = cXbox.getTriggerAxis(Hand.kRight);
        return rightTrigger;
    }

    //-----Left Bumper-----
    public boolean getLeftBumper(int choice) {
        if(choice == 1){
            // Button Press - 1
            leftBumperPress = cXbox.getBumperPressed(Hand.kLeft);
            return leftBumperPress;
        }else if(choice == 2){
            // Button Release - 2
            leftBumperRelease = cXbox.getBumperReleased(Hand.kLeft);
            return leftBumperRelease;
        }else{
            // Button Value - else
            leftBumper = cXbox.getBumper(Hand.kLeft);
            return leftBumper;
        }
    }

    //-----Right Bumper-----
    public boolean getRightBumper(int choice) {
        if(choice == 1){
            // Button Press - 1
            rightBumperPress = cXbox.getBumperPressed(Hand.kRight);
            return rightBumperPress;
        }else if(choice == 2){
            // Button Release - 2
            rightBumperRelease = cXbox.getBumperReleased(Hand.kRight);
            return rightBumperRelease;
        }else{
            // Button Value - else
            rightBumper = cXbox.getBumper(Hand.kRight);
            return rightBumper;
        }
    }

    //-----A Button-----
    public boolean getAbutton(int choice) {
        if(choice == 1){
            // Button Press - 1
            Apress = cXbox.getAButtonPressed();
            return Apress;
        }else if(choice == 2){
            // Button Release - 2
            Arelease = cXbox.getAButtonReleased();
            return Arelease;
        }else{
            // Button Value - else
            Abutton = cXbox.getAButton();
            return Abutton;
        }
    }

    //-----B Button-----
    public boolean getBbutton(int choice) {
        if(choice == 1){
            // Button Press - 1
            Bpress = cXbox.getBButtonPressed();
            return Bpress;
        }else if(choice == 2){
            // Button Release - 2
            Brelease = cXbox.getBButtonReleased();
            return Brelease;
        }else{
            // Button Value - else
            Bbutton = cXbox.getBButton();
            return Bbutton;
        }
    }

    //-----Y Button-----
    public boolean getYbutton(int choice) {
        if(choice == 1){
            // Button Press - 1
            Ypress = cXbox.getYButtonPressed();
            return Ypress;
        }else if(choice == 2){
            // Button Release - 2 
            Yrelease = cXbox.getYButtonReleased();
            return Yrelease;
        }else{
            // Button Value - else
            Ybutton = cXbox.getYButton();
            return Ybutton;
        }
    }

    //-----X Button-----
    public boolean getXbutton(int choice) {
        if(choice == 1){
            // Button Press - 1
            Xpress = cXbox.getXButtonPressed();
            return Xpress;
        }else if(choice == 2){
            // Button Release - 2
            Xrelease = cXbox.getXButtonReleased();
            return Xrelease;
        }else{
            // Button Value - else
            Xbutton = cXbox.getXButton();
            return Xbutton;
        }
    }

    //-----Start Button-----
    public boolean getStartButton(int choice) {
        if(choice == 2){
            // Button Press - else
            startPress = cXbox.getStartButtonPressed();
            return startPress;
        }else if(choice == 3){
            // Button Release - else
            startRelease = cXbox.getStartButtonReleased();
            return startRelease;
        }else{
            // Button Value - else
            startButton = cXbox.getStartButton();
            return startButton;
        }
    }

    //-----Back Button-----
    public boolean getBackButton(int choice) {
        if(choice == 2){
            // Button Press - 1
            backPress = cXbox.getBackButtonPressed();
            return backPress;
        }else if(choice == 3){
            // Button Release - 2
            backRelease = cXbox.getBackButtonReleased();
            return backRelease;
        }else{
            // Button Value - else
            backButton = cXbox.getBackButton();
            return backButton;
        }
    }
}