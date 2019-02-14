package frc.team4546.robot.subsystems.vision;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.ArrayList;
import java.util.Scanner;
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

    private native String pixy2USBGetBlocks();

    private static Block[] blocks;
    public static final ArrayBlockingQueue<Block[]> blocksBuffer = new ArrayBlockingQueue<>(2);

    private double m_expirationTime;
    private final int m_notifier = NotifierJNI.initializeNotifier();
    private final double m_period = .05; // Milliseconds?

    private int cycleCounter = 0;

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

            System.out.println("Starting Thread");

            m_expirationTime = RobotController.getFPGATime() * 1e-6 + m_period;
            updateAlarm();

            pixy2USBJNI.pixy2USBStartCameraServer();

            while (true) {
                long curTime = NotifierJNI.waitForNotifierAlarm(m_notifier);
                if (curTime == 0) {
                    break;
                }

                if (toggleLamp.get()) {
                    toggleLamp();
                    toggleLamp.set(false);
                }
                m_expirationTime += m_period;
                updateAlarm();

                loopfunc();
                pixy2USBJNI.pixy2USBLoopCameraServer();
            }
        } else {
            System.err.println("[WARNING] is the Pixy2 plugged in???");
        }
    }

    private void loopfunc() {
        String visionStuffs = pixy2USBJNI.pixy2USBGetBlocks();

        if (visionStuffs.equals("")) {
            if (++cycleCounter > 100) {
                cycleCounter = 0;
                System.out.println("[INFO] No blocks detected");
            }
            return;
        }

        // Reset counter if there are blocks present
        cycleCounter = 0;

        String[] visionParts = visionStuffs.split("\n");
        blocks = new Block[visionParts.length];

        int arrayIndex = 0;

        for (String s : visionParts) {

            if (!s.isEmpty() && !s.isBlank() && !s.equals(null) && !s.equals("")) {
                try {
                    Scanner sc = new Scanner(s);
                    sc.next();
                    sc.next();
                    sc.next();
                    sc.next();
                    int sig = sc.nextInt();
                    sc.next();
                    int x = sc.nextInt();
                    sc.next();
                    int y = sc.nextInt();
                    sc.next();
                    int width = sc.nextInt();
                    sc.next();
                    int height = sc.nextInt();
                    sc.next();
                    int index = sc.nextInt();
                    sc.next();
                    int age = sc.nextInt();

                    blocks[arrayIndex++] = new Block(sig, x, y, width, height, index, age);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /*
         * for (Block b: blocks){ System.out.println(b.toString()); }
         */
        synchronized (blocksBuffer) {
            if (blocksBuffer.remainingCapacity() == 0) {
                blocksBuffer.remove();
            }
            try {
                blocksBuffer.put(blocks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateAlarm() {
        NotifierJNI.updateNotifierAlarm(m_notifier, (long) (m_expirationTime * 1e6));
    }
}