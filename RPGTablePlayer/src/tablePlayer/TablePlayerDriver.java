package tablePlayer;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;

public class TablePlayerDriver {

	public static void main(String[] args) {
		File toPlay = new File("C:/Users/Linden/Music/Converted by MediaHuman/Overdrive.wav");

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(toPlay);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			for (int i = 0; i < 10; i++) {

				gainControl.setValue((float) (-i));
				Thread.sleep(500);
			}
			Thread.sleep(2000);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
