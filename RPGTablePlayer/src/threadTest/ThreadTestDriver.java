package threadTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;

public class ThreadTestDriver {
	private static int NUM_THREADS = 3;
	
	public static AtomicInteger pool = new AtomicInteger();
	static Thread[] thread;

	public static void main(String[] args) {
		thread = new Thread[NUM_THREADS];
		
		for (int i = 0; i < NUM_THREADS; i++){
			thread[i] = new Thread(new ThreadToTest(), "" + i);
		}
		
		ThreadTestGui gui = new ThreadTestGui();

		for (int i = 0; i < NUM_THREADS; i++) {
			JButton button = new JButton();
			gui.addButton(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
	}
	
	public void setAllDecreasing(){
		for (int i = 0; i < NUM_THREADS; i++){
			
		}
	}
}
