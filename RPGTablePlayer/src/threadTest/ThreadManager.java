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
	
	public void setIncreasing(int inc){
		if (inc > 0 && inc < NUM_THREADS){
			increasing = inc;
		}
	}

	//NEED TO FIX/FINISH to check for min volume and such.
	public float takeVolume(float howMuch) {
		if (howMuch > DELTA_VOLUME){
			System.out.println("trying to take too much volume");
			return howMuch;
		}
		else if (currentVolume >= DELTA_VOLUME) {
			currentVolume -= howMuch;
			return howMuch;
		} else {
			currentVolume -= currentVolume;
			return currentVolume;
		}
	}
	
	public float giveVolume(float howMuch){
		if (currentVolume + howMuch <= MAX_VOLUME){
			currentVolume += howMuch;
			return howMuch;
		}
		else{
			
		}
	}
}
