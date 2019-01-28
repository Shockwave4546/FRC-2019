package frc.team4546.robot.subsystems.vision;

//import java.util.ArrayList;

import io.github.pseudoresonance.pixy2api.Pixy2;
//import io.github.pseudoresonance.pixy2api.Pixy2CCC;
//import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.Link;

public class PixyCamera {

	private final Pixy2 pixy;

	

	public PixyCamera(Link link) {
		pixy = Pixy2.createInstance(link);
		pixy.init();
	}

	public PixyCamera(Link link, int arg) {
		pixy = Pixy2.createInstance(link);
		pixy.init(arg);
	}

	public void run() {

		//pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
		//ArrayList<Block> blocks = pixy.getCCC().getBlocks();
	}

	public void light(boolean state) {
		if (state == true) {
			pixy.setLamp((byte) 1, (byte) 0);
		} else if (state == false) {
			pixy.setLamp((byte) 0, (byte) 0);
		}
	}

	public Pixy2 getPixy() {
		return pixy;
	}

}