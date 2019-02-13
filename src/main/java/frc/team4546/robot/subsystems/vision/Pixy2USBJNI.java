package frc.team4546.robot.subsystems.vision;

import java.util.concurrent.atomic.AtomicBoolean;

public class Pixy2USBJNI implements Runnable {
    static {
       System.loadLibrary("pixy2_usb");
    }
  
    // Declare an instance native method sayHello() which receives no parameter and returns void
    private native int pixy2USBInit();

    private native void pixy2USBGetVersion();

    private native void pixy2USBLampOn();

    private native void pixy2USBLampOff();

    private native void pixy2USBStartCameraServer();

    private native void pixy2USBLoopCameraServer();

    private Pixy2USBJNI pixy2USBJNI;

    public AtomicBoolean toggleLamp = new AtomicBoolean(false);
    private boolean lampOn = false;

    public void toggleLamp() {
        if (lampOn) {
            System.out.println("Turning Lamp Off");
            pixy2USBJNI.pixy2USBLampOff();
            lampOn = false;
        } else {
            System.out.println("Turning Lamp On");
            pixy2USBJNI.pixy2USBLampOn();
            lampOn = true;
        }
    }

    @Override
    public void run() {
        pixy2USBJNI = new Pixy2USBJNI();
        int init_result = pixy2USBJNI.pixy2USBInit();
        if (init_result == 0) {
            pixy2USBJNI.pixy2USBGetVersion();
            pixy2USBJNI.pixy2USBLampOn();
            lampOn = true;
    
            pixy2USBJNI.pixy2USBStartCameraServer();
    
            while(true) {
                if (toggleLamp.get()) {
                    toggleLamp();
                    toggleLamp.set(false);
                }
                pixy2USBJNI.pixy2USBLoopCameraServer();
            }
        } else {
            System.err.println("[WARNING] is the Pixy2 plugged in???");
        }
    }
}
