package frc.robot.vision;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class Cameras {

    private static UsbCamera drive = null;
    private static PixyCamera pixy = null;

    public static void setup() {
        initDrive();
        pixy = new PixyCamera(new SPILink());

    }

    public static void light(boolean state) {
        pixy.light(state);
    }

    public static void run() {
        pixy.run();
    }

    public static PixyCamera getPixyCamera() {
        return pixy;
    }

    public static void initDrive() {
        drive = CameraServer.getInstance().startAutomaticCapture();
        if (drive != null) {
            // drive.setVideoMode(PixelFormat.kBGR, 320, 240, 30);
            drive.setResolution(320, 240);
            drive.setFPS(60);
            
        }
    }

}