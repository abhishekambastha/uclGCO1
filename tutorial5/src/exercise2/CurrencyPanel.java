package exercise2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * write the conversion to a file!!
 */
public class CurrencyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> currencies = new ArrayList<String>();

	public CurrencyPanel() {
		
		ArrayList<String> currencies = new ArrayList<String>();
		currencies.add("GBP");
		currencies.add("USD");
		currencies.add("YEN");
		currencies.add("EU");
		
		Dimension size = getPreferredSize();
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("CURRENCY"));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		JLabel enterVal = new JLabel("Enter Value");
		add(enterVal, gc);
		
		
		//Input Box
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		JTextField value = new JTextField(10);
		add(value,gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		JLabel convertFrom = new JLabel("From");
		add(convertFrom, gc);
		
		//Source Currency
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		JComboBox<String> sourceCurrency = new JComboBox<String>(currencies.toArray(new String[currencies.size()]));
		add(sourceCurrency, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		JLabel convertTo = new JLabel("To");
		add(convertTo, gc);

		//DestinationCurrency
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		JComboBox<String> destCurrency = new JComboBox<String>(currencies.toArray(new String[currencies.size()]));
		add(destCurrency, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		JLabel answer = new JLabel("Converted Value:");
		add(answer, gc);
		
		
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		JButton btn = new JButton("Convert"); 
		add(btn, gc);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceC = (String)sourceCurrency.getSelectedItem();
				Currency c = new Currency();
				String destC = (String)destCurrency.getSelectedItem();
				System.out.println("From "+ sourceC + " To " + destC);
				
				double val = Double.parseDouble(value.getText());
				String src = (String)sourceCurrency.getSelectedItem();
				String dest = (String)destCurrency.getSelectedItem();
				
				answer.setForeground(Color.RED);
				String res ="" + (c.getConversion(val, src, dest));
				answer.setText(res);
				if(handleFile.readFile()){
					handleFile.writeAppend(src + " To " + dest+ "\t"+ res);
				}else{
					handleFile.writeNew(src + " To " + dest+ "\t"+ res);
				}
				
				
//				answer.setVisible(false);
			}
		});
	}


}
