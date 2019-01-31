package frc.team4546.robot.subsystems.vision;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4546.robot.Dashboard;

import frc.team4546.robot.subsystems.vision.Cameras;
//import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class TargetBall{

   private static ArrayList<Block> blocks = Cameras.getPixyCamera().getPixy().getCCC().getBlocks();
    private static final int blockSignature = 1;



    public static void run() {

        Block largestBlock = null;
        for(Block block : blocks) {
            if(block.getSignature() == blockSignature){
                if(largestBlock == null) {
                    largestBlock = block;
                } else if(block.getWidth() > largestBlock.getWidth()) {
                    largestBlock = block;
                }
            } 
        }
        Dashboard.getInstance().putNumber(false, "Ball X", largestBlock.getX());
        Dashboard.getInstance().putNumber(false, "Ball Y", largestBlock.getY());
        Dashboard.getInstance().putNumber(false, "Ball Box Width", largestBlock.getWidth());
        Dashboard.getInstance().putNumber(false, "Ball Box Height", largestBlock.getHeight());
    }

   
        
    

}
