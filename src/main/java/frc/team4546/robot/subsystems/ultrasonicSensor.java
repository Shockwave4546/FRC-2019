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
    private final int voltageInputWindowLength;
    private double[] voltageInputWindow;

    public ultrasonicSensor(){
        sUltrasonic1 = new AnalogInput(sUltrasonic1Port);
        voltageInputWindowLength = 5;
        voltageInputWindow = new double[voltageInputWindowLength];
    }
    
    public ultrasonicSensor(final int averageWindowSize){
        sUltrasonic1 = new AnalogInput(sUltrasonic1Port);
        voltageInputWindowLength = averageWindowSize;
        voltageInputWindow = new double[voltageInputWindowLength];
    }

    public double getRange(){
		AnalogInput.setGlobalSampleRate(62500);
		raw = sUltrasonic1.getValue();
        volts = sUltrasonic1.getVoltage();
        averageRaw = sUltrasonic1.getAverageValue();
        averageVolts = sUltrasonic1.getAverageVoltage();
        analogValue = averageRaw * 5;

        // shift average window
        for(int i = 0; i < (voltageInputWindowLength - 1); i++){
            voltageInputWindow[i] = voltageInputWindow[i+1];
        }
        voltageInputWindow[voltageInputWindowLength - 1] = analogValue;
        
        // calculating average of window
        int sum = 0;
        for(int i = 0; i < voltageInputWindowLength; i++){
            sum += voltageInputWindow[i];
        }

        return sum / voltageInputWindowLength;
    }
}