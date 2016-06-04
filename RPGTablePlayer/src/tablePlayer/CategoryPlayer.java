package tablePlayer;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;


public class CategoryPlayer {

	String FILE_PATH;
	float volume;

	String testFilePath = "C:/Users/Linden/Downloads/baker_arduous.wav";
	File toPlay;

	
	//MAIN FOR TESTING ONLY
	public static void main(String[] args){
		File toPlay = new File("C:/Users/Linden/Downloads/baker_arduous.wav");
		CategoryPlayer cp = new CategoryPlayer("C:/Users/Linden/Downloads/baker_arduous.wav");
		PlayerThread player = new PlayerThread(cp, toPlay);
		player.run();
	}
	
	public CategoryPlayer(String fp) {
		FILE_PATH = fp;

		// Normally, we'll instaniate toPlay as a random file.
		toPlay = new File(testFilePath);
		volume = -10.0f;

		

		// code to search the directory, find all .WAVs and populate WAV_LIST

	}
	public float getVolume() {
		return volume;
	}

	public void setVolume(float v) {
		volume = v;
	}

}
