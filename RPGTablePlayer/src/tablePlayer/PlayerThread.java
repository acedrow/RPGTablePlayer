package tablePlayer;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class PlayerThread extends Thread {
	AudioInputStream ais;
	Clip clip;
	CategoryPlayer parent;
	FloatControl gainControl;
	File toPlay;
	float durationInSeconds;

	public PlayerThread(CategoryPlayer p, File f) {
		toPlay = f;
		parent = p;

		try {
			ais = AudioSystem.getAudioInputStream(toPlay);
			AudioFormat format = ais.getFormat();
			long audioFileLength = toPlay.length();
			int frameSize = format.getFrameSize();
			float frameRate = format.getFrameRate();
			durationInSeconds = (audioFileLength / (frameSize * frameRate));
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			float currentVolume = parent.getVolume();
			ais = AudioSystem.getAudioInputStream(toPlay);
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(parent.getVolume());

			for (int i = 0; i < 5; i++) {
				currentVolume = parent.getVolume();
				gainControl.setValue(currentVolume);
				System.out.println("volume at: " + currentVolume);
				Thread.sleep(500);

			}
			System.out.println("Player thread for loop done");

		} catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}
}
