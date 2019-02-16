package frc.robot.subsystems.vision;

import java.util.ArrayList;
//import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Dashboard;

import frc.robot.subsystems.vision.Cameras;
//import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class TargetHatch {

    private static ArrayList<Block> blocks = Cameras.getPixyCamera().getPixy().getCCC().getBlocks();
    private static final int blockSignature = 1;

    public static void run(int count) {
        if (count > 0) {
            Block largestBlock = null;
            // Checks for Biggest Block that is of the Orange Color Signature
            for (Block block : blocks) {
                if (block.getSignature() == blockSignature) {
                    if (largestBlock == null) {
                        largestBlock = block;
                    } else if (block.getWidth() > largestBlock.getWidth()) {
                        largestBlock = block;
                    }
                }
            }

            int ballX = largestBlock.getX();
            double yaw = ((ballX - 157.5) * 0.1904761905);

            // Information about the Big Orange Block is sent to NetworkTables for
            // Shuffleboard
            Dashboard.getInstance().putNumber(false, "Ball Angle", yaw);
            Dashboard.getInstance().putNumber(false, "Ball X", largestBlock.getX());
            Dashboard.getInstance().putNumber(false, "Ball Y", largestBlock.getY());
            Dashboard.getInstance().putNumber(false, "Ball Box Width", largestBlock.getWidth());
            Dashboard.getInstance().putNumber(false, "Ball Box Height", largestBlock.getHeight());
        }

    }

}
