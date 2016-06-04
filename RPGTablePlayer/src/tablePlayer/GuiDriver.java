package tablePlayer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiDriver extends JFrame implements ActionListener{
	String TITLE = "";
	 int NUM_BUTTONS = 0;
	 Vector<JButton> buttons = new Vector<JButton>();
	 TextField text = new TextField(20);

    
     
	public GuiDriver (int numButtons, String title){
		TITLE = title;
		NUM_BUTTONS = numButtons;
		setSize(500,500);
		setLayout(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//MAIN METHOD IS FOR TESTING PURPOSES ONLY
	public static void main(String[] args){
		GuiDriver g = new GuiDriver(4, "RPG Table Player");
		g.makeButtons();
		
	}
	
	private void makeButtons(){
			for(int i = 0; i < NUM_BUTTONS; i++){
				JButton b = new JButton("" + i);
				b.setName("" + i);
				b.addActionListener(this);
				buttons.add(b);
				add(buttons.get(i));
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = ((JButton) e.getSource()).getActionCommand();
		System.out.println(command);
		
	}

	
	
}
