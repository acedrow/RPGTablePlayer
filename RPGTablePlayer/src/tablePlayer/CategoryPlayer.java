package tablePlayer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.sampled.*;

public class CategoryPlayer {

	File folder;
	File lastPlayed;
	Vector<File> listOfFiles;
	Queue<File> fileQueue;
	PlayerThread playerThread;
	float volume;

	/*
	 * One-arg constructor taking a string filepath to the specific category's
	 * folder.
	 */
	public CategoryPlayer(String fp) {
		listOfFiles = new Vector<File>();
		folder = new File(fp);
		fileQueue = new LinkedList<File>();
		File[] files = folder.listFiles();

		for (File f : files) {
			String fn = f.getName();
			String filetype = fn.substring(fn.length() - 3, fn.length());
			if (f.isFile() && filetype.equals("wav")) {
				listOfFiles.add(f);
			}
		}
		populateQueue();

		// Normally, we'll instaniate toPlay as a random file.
		volume = -10.0f;
	}

	public void playRandomSong() {
		if (listOfFiles.size() == 1) {
			playerThread = new PlayerThread(this, listOfFiles.get(0));
			playerThread.start();
		} else {
			if (fileQueue.size() == 0) {
				populateQueue();
			}
			playerThread = new PlayerThread(this, fileQueue.remove());
			playerThread.start();
		}

	}

	public void populateQueue() {
		Vector<File> tempList = listOfFiles;
		while (tempList.size() > 0) {
			int r = ThreadLocalRandom.current().nextInt(0, tempList.size());
			fileQueue.add(tempList.get(r));
			tempList.remove(r);
		}

	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float v) {
		volume = v;
	}

}
