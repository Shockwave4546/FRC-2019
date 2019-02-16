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
        UP(0), RIGHT(90), DOWN(180), LEFT(270);

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

}