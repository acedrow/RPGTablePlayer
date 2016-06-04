package tablePlayer;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;

public class TablePlayerDriver {

	public static void main(String[] args) {
		File toPlay = new File("C:/Users/Linden/Downloads/baker_arduous.wav");

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(toPlay);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			gainControl.setValue((float) (-10));
			Thread.sleep(1000);
			gainControl.setValue((float) (-20));
			Thread.sleep(1000);
			gainControl.setValue((float) (-30));
			Thread.sleep(1000);
			gainControl.setValue((float) (-40));
			Thread.sleep(1000);
			gainControl.setValue((float) (-50));
			Thread.sleep(1000);

//			for (int i = 0; i < 30; i++) {
//
//				gainControl.setValue((float) (-i));
//				Thread.sleep(500);
//			}
		

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
