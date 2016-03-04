package threadTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;

public class ThreadTestDriver {
	private final static int NUM_THREADS = 3;
	private final static float MAX_VOLUME = 0.0f;
	private final static float MIN_VOLUME = -50.0f;
	private final static float DELTA_VOLUME = 1.0f;	

	public static void main(String[] args) {
		
		
		ThreadManager threadManager = new ThreadManager(NUM_THREADS, MAX_VOLUME, MIN_VOLUME, DELTA_VOLUME);
		ThreadTestGui gui = new ThreadTestGui(threadManager);
		
		gui.addButtons(NUM_THREADS);
		
	}
}
