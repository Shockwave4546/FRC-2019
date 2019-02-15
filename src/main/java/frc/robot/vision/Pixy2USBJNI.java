package frc.robot.vision;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import edu.wpi.first.hal.NotifierJNI;
import edu.wpi.first.wpilibj.RobotController;

public class Pixy2USBJNI implements Runnable {
    static {
        System.loadLibrary("pixy2_usb");
    }

    // Declare an instance native method sayHello() which receives no parameter and
    // returns void
    private native int pixy2USBInit();

    private native void pixy2USBGetVersion();

    private native void pixy2USBLampOn();

    private native void pixy2USBLampOff();

    private native void pixy2USBStartCameraServer();

    private native void pixy2USBLoopCameraServer();

    private native String pixy2USBGetBlocks();

    private static Block[] blocks;
    public static final ArrayBlockingQueue<Block[]> blocksBuffer = new ArrayBlockingQueue<>(2);


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
            // pixy2USBJNI.pixy2USBLampOn();
            // lampOn = true;

            pixy2USBJNI.pixy2USBStartCameraServer();

            System.out.println("Starting Thread");

      
            while (true) {
                /*
                 * if (toggleLamp.get()) { toggleLamp(); toggleLamp.set(false); }
                 */
                pixy2USBJNI.pixy2USBLoopCameraServer();

  
            }
        } else {
            System.err.println("[WARNING] is the Pixy2 plugged in???");
        }
    }


}
