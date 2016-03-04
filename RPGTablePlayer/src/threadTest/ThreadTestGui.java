package threadTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ThreadTestGui {
	ThreadManager threadManager;
	JFrame frame;
	JPanel panel;
	int ROWS = 2;
	int COLUMNS = 2;

	public ThreadTestGui(ThreadManager threadManager) {
		frame = new JFrame("RPGTP");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout(ROWS, COLUMNS));

		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);

	}
	

	public void addButtons(int numButtons) {
		for (int i = 0; i < numButtons; i++) {
			JButton button = new JButton("" + i);
			panel.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int inc = Integer.parseInt(button.getName());
					threadManager.setIncreasing(inc);
				}
			});
		}
	}
}
