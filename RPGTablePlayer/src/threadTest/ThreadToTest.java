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
		//if we're increasing
		if (threadManager.getIncreasing() == threadNumber){
			if(volume < MAX_VOLUME){
				//if we're increasing, and volume isn't max, increase here
			}
		}
		else if (volume > MIN_VOLUME){
			//otherwise, if we're decreasing and have volume, decrease here
		}
		

	}
}
