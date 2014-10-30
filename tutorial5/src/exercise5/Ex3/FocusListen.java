package exercise5.Ex3;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JSlider;

public class FocusListen implements FocusListener {
	@Override
	public void focusGained(FocusEvent e) {
		
		if(e.getComponent() instanceof JButton){
			MainFrame.msg.setText("Button is Selected!!");
		}else if (e.getComponent() instanceof JSlider){
			MainFrame.msg.setText("Slider is Selected!!");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		MainFrame.msg.setText( "Out Of Focus");
		
	}

}
