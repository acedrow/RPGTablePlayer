package threadTest;
import java.awt.GridLayout;

import javax.swing.*;

public class ThreadTestGui {
	JFrame frame;
	JPanel panel;
	int ROWS = 2;
	int COLUMNS = 2;

	public ThreadTestGui() {
		frame = new JFrame("RPGTP");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout(ROWS, COLUMNS));
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		
	}

	public void addButton(JButton button) {
		panel.add(button);
	}
}
