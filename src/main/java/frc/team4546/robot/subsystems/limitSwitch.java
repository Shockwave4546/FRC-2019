package frc.team4546.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;

public class limitSwitch {
    private DigitalInput sLimitSwitch;
    private boolean sLimitSwitchValue;
    public limitSwitch(final int port){
        sLimitSwitch = new DigitalInput(port);
    }
    public boolean getValue(){
        sLimitSwitchValue = sLimitSwitch.get();
        return sLimitSwitchValue;
    }
}