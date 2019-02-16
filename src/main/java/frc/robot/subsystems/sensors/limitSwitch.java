package frc.robot.subsystems.sensors;
import edu.wpi.first.wpilibj.DigitalInput;
/*
    when declaring a limit switch the first parameter is the port number.
    Add a second perameter (boolean) if using magnet limit switch, defaults to false.
*/
public class limitSwitch {
    private DigitalInput sLimitSwitch;
    private boolean sLimitSwitchValue;
    private boolean inverted;

    public limitSwitch(final int port){
        sLimitSwitch = new DigitalInput(port);
    }

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