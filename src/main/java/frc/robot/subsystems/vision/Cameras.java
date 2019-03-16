package frc.robot.subsystems.vision;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;


public class Cameras {

    private static UsbCamera drive = null;

    public static void setup() {
        initDrive();

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
