package exercise3;


import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OldEntry extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextArea text = new JTextArea(12,60);
	public OldEntry() {
		setBorder(BorderFactory.createTitledBorder("Last Entry"));
		text.setEditable(false);
		text.setText("Not");
		add(text);
	}

	public static void update(){
		text.setText("Still Nothing");
		
		String updateString = "";
		Stack<String> textToDisplay = null;
		ArrayList<String> newText = new ArrayList<String>();
		ArrayList<String> filterText = new ArrayList<String>();
		
		
		if(handleFile.readFile()){
			textToDisplay  = handleFile.getText();
		}
		
		for(String s: textToDisplay){
			newText.add(s);
		}
		
		int size = newText.size();
		int i=size-1;
		boolean truth = true;
		while(truth&& i>0){
			String s = newText.get(i--);
			if(s.equals("<hr />")){
				truth = false;
				s="";
			}
			if(!s.equals("<br/>")){
				filterText.add(s);
			}
		}
		
		for(int j=filterText.size()-1; j>0; j--){
			updateString += (filterText.get(j)) + "\n";
			System.out.println(j);
		}
		
		text.setText(updateString);
	}
	
}