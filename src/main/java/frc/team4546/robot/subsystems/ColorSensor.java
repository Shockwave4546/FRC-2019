package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import frc.team4546.robot.Dashboard;

public class ColorSensor {
	private static I2C sensor;

	protected final static int COMMAND_REGISTER_BIT = 0x80;
	protected final static int MULTI_BYTE_BIT = 0x20;

	protected final static int ENABLE_REGISTER = 0x00;
	protected final static int ATIME_REGISTER = 0x01;
	protected final static int PPULSE_REGISTER = 0x0E;

	protected final static int ID_REGISTER = 0x12;
	protected final static int CDATA_REGISTER = 0x14;
	protected final static int RDATA_REGISTER = 0x16;
	protected final static int GDATA_REGISTER = 0x18;
	protected final static int BDATA_REGISTER = 0x1A;
	protected final static int PDATA_REGISTER = 0x1C;

	public static void setup() {
		sensor = new I2C(I2C.Port.kOnboard, 0x39); // port, I2c address

		sensor.write(COMMAND_REGISTER_BIT | 0x00, 0b00000011); // power on, color sensor on
	}

	public static void red() {
		Dashboard.getInstance().putNumber(false, "Red Value", RDATA_REGISTER);
	}

	public static void green() {
		Dashboard.getInstance().putNumber(false, "Green Value", GDATA_REGISTER);
	}

	public static void blue() {
		Dashboard.getInstance().putNumber(false, "Blue Value", BDATA_REGISTER);
	}

	public static void clear() {
		Dashboard.getInstance().putNumber(false, "Clear Value", CDATA_REGISTER);
	}

	public static void proximity() {
		Dashboard.getInstance().putNumber(false, "Proximity Value", PDATA_REGISTER);
	}

}