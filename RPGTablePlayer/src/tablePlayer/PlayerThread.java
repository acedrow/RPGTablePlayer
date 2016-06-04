package tablePlayer;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class PlayerThread implements Runnable {
	AudioInputStream ais;
	Clip clip;
	CategoryPlayer parent;
	FloatControl gainControl;
	File toPlay;

	public PlayerThread(CategoryPlayer p, File f) {
		toPlay = f;
		parent = p;

	}

	public void run() {
		try {
			ais = AudioSystem.getAudioInputStream(toPlay);
			clip = AudioSystem.getClip();
			clip.open(ais);
			System.out.println("Player thread starting");
			clip.start();
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(parent.getVolume());
			
			
			

			for (int i = 0; i < 5; i++) {
				gainControl.setValue(parent.getVolume());
				Thread.sleep(1000);
			
			}
			System.out.println("Player thread for loop done");
			
		} catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}

}
