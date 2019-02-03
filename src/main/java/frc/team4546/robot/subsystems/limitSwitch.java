package frc.team4546.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;

public class limitSwitch {
    private DigitalInput sLimitSwitch;
    private boolean sLimitSwitchValue;
    private boolean inverted;
    public limitSwitch(final int port, final boolean flip){
        sLimitSwitch = new DigitalInput(port);
        if(flip == true){
            inverted = true;
        }else{
            inverted = false;
        }
    }
    public boolean getValue(){
        sLimitSwitchValue = sLimitSwitch.get();
        if(inverted == true && sLimitSwitchValue == false){
            return true;
        }else if(inverted == true && sLimitSwitchValue == true){
            return false;
        }else{
            return sLimitSwitchValue;
        }
    }
}