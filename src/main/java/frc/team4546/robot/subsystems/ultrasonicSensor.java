package frc.team4546.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;

public class ultrasonicSensor {
    private static final int sUltrasonic1Port = 0;
    private AnalogInput sUltrasonic1;
    private double analogValue;
    private double raw;
    //private double volts;
    //private double averageRaw;
    //private double averageVolts;
    private final int voltageInputWindowLength;
    private double[] voltageInputWindow;
    private double conversion;
    private boolean toInches = true;

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
        //volts = sUltrasonic1.getVoltage();
        //averageRaw = sUltrasonic1.getAverageValue();
        //averageVolts = sUltrasonic1.getAverageVoltage();
        conversion = 0.0393700787;
        if(toInches == true){
            analogValue = raw * conversion;
        }else{
            analogValue = raw;
        }
        

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