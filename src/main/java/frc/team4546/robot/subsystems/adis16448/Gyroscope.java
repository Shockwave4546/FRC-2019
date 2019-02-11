package frc.team4546.robot.subsystems.adis16448;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class Gyroscope {
    ADIS16448_IMU gyro;

    public Gyroscope() {
        gyro = new ADIS16448_IMU();
    }

    public void reset() {
        gyro.reset();
    }

    public double getAngle() {
        double angle = gyro.getAngleZ();
        /*while (angle < 0) {

        }*/

        angle %= 360;

        return angle;
    }
}