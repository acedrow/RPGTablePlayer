package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadManager {
	private final int NUM_THREADS;
	private final float MAX_VOLUME;
	private final float MIN_VOLUME;
	private final float DELTA_VOLUME;

	float currentVolume;

	private static int increasing = -1;
	public static AtomicInteger pool = new AtomicInteger();
	static Thread[] thread;

	public ThreadManager(int nt, float max, float min, float delta) {
		NUM_THREADS = nt;
		MIN_VOLUME = min;
		MAX_VOLUME = max;
		DELTA_VOLUME = delta;
		thread = new Thread[NUM_THREADS];

		for (int i = 0; i < NUM_THREADS; i++) {
			thread[i] = new Thread(new ThreadToTest(this, MAX_VOLUME, MIN_VOLUME, DELTA_VOLUME, i), "" + i);

		}
	}

	// WILL NEED TO LOCK GET AND SET INCREASING ON THE SAME OBJECT
	// prety sure I can just lock on "this" - the instance of ThreadManager
	public int getIncreasing() {
		return increasing;
	}

	public float takeVolume(float howMuch) {
		if (currentVolume >= DELTA_VOLUME) {
			currentVolume -= howMuch;
			return howMuch;
		} else {
			currentVolume -= currentVolume;
			return currentVolume;
		}
	}
	
	public void giveVolume(){
		if (currentVolume + DELTA_VOLUME <= MAX_VOLUME){
			currentVolume += DELTA_VOLUME;
		}
		else currentVolume = MAX_VOLUME;
	}
}
