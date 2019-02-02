package frc.team4546.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;

public class ultrasonicSensor {
    private static final int sUltrasonic1Port = 0;
    private AnalogInput sUltrasonic1;
    private double analogValue;
    private int raw;
    private double volts;
    private int averageRaw;
    private double averageVolts;

    public ultrasonicSensor(){
        sUltrasonic1 = new AnalogInput(sUltrasonic1Port);
    }
    public double getRange(){
		AnalogInput.setGlobalSampleRate(62500);
		raw = sUltrasonic1.getValue();
        volts = sUltrasonic1.getVoltage();
        averageRaw = sUltrasonic1.getAverageValue();
        averageVolts = sUltrasonic1.getAverageVoltage();
		analogValue = averageRaw * 5;
        return analogValue;
    }
}