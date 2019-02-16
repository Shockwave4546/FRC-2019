package frc.robot.subsystems.vision;



import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
//import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.Link;

public class PixyCamera {

	private final Pixy2 pixy;
	private boolean laststate = false;
	public final static int PixyResult = 0;

	public PixyCamera(Link link) {
		pixy = Pixy2.createInstance(link);
		pixy.init();
	}

	public PixyCamera(Link link, int arg) {
		pixy = Pixy2.createInstance(link);
		pixy.init(arg);
	}

	public void run() {

		final int pixystatus = pixy.init(PixyResult); // Checks for Pixy2 Error (If issue, Robot is Not Effected)
		if (pixystatus == 0) {

			final int count = pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);

			TargetBall.run(count); // Track Orange Ball Code Run


			final int countt = pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG3, 25);

			TargetHatch.run(countt); // Track Orange Ball Code Run

		}

		// pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
		// ArrayList<Block> blocks = pixy.getCCC().getBlocks();
		// pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);

	}

	public void light(boolean state) {
		final int pixystatus = pixy.init(PixyResult); // Checks for Pixy2 Error (If issue, Robot is Not Effected)
		if (pixystatus == 0) {

			if ((state == true) && (laststate == false)) { // Pixy2 Lamp Turns On/Off w/ Shuffleboard Button
				laststate = true;
				pixy.setLamp((byte) 1, (byte) 0);
			} else if (state == false && laststate == true) {
				laststate = false;
				pixy.setLamp((byte) 0, (byte) 0);
			}

		}
	}

	public Pixy2 getPixy() {
		return pixy;
	}

}