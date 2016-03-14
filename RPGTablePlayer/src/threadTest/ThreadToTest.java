package threadTest;

public class ThreadToTest implements Runnable {
	final float MAX_VOLUME;
	final float MIN_VOLUME;
	final float DELTA_VOLUME;
	final int threadNumber;
	private float volume;

	ThreadManager threadManager;

	public ThreadToTest(ThreadManager tman, float max, float min, float delta, int tnum) {
		MAX_VOLUME = max;
		MIN_VOLUME = min;
		DELTA_VOLUME = delta;
		threadNumber = tnum;
		volume = -50.0f;

		threadManager = tman;

	}

	public void run() {
		//if this thread is increasing & volume isn't max:
		if (threadManager.getIncreasing() == threadNumber && volume < MAX_VOLUME){
			if (volume + DELTA_VOLUME <= MAX_VOLUME){
					volume += threadManager.takeVolume(DELTA_VOLUME);
				}
				else {
					volume += threadManager.takeVolume(MAX_VOLUME - volume);
				}
		}
		//if we're decreasing and volume isn't min:
		else if (volume > MIN_VOLUME){
			if (volume )
		}
		

	}
}
