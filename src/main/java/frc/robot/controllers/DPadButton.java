package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class DPadButton extends Button {

    Joystick joystick;
    Direction direction;

    public DPadButton(Joystick joystick, Direction direction) {
        this.joystick = joystick;
        this.direction = direction;
    }

    public static enum Direction {
        UP(0), UP_LEFT(45), LEFT(90), DOWN_LEFT(135), DOWN(180), DOWN_RIGHT(225), RIGHT(270), UP_RIGHT(315);

        int direction;

        private Direction(int direction) {
            this.direction = direction;
        }
    }

    public boolean get() {
        int DPadValue = joystick.getPOV();
        return (DPadValue == direction.direction) || (DPadValue == (direction.direction + 45) % 360)
                || (DPadValue == (direction.direction + 315) % 360);
    }
/**
 * DPAD:
-1: No Thumbpad Button
0: North Thumbpad Button
45: North-East Thumbpad Button
90: East Thumbpad Button
135: South-East Thumbpad Button
180: South Thumbpad Button
225: South-West Thumbpad Button
270: West Thumbpad Button
315: North-West Thumbpad Button

 */
}