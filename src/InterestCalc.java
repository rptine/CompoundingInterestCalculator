import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




public class InterestCalc extends JFrame {
	private JLabel A;
	private JTextField At;
	private JLabel P;
	private JTextField Pt;
	private JLabel r;
	private JTextField rt;
	private JRadioButton cont;
	private JRadioButton noncont;
	private JLabel n;
	private JTextField nt;
	private JLabel t;
	private JTextField tt;
	private JButton calculate;
	private JLabel result;
	private JPanel platform;
	
	/** Constructor sets up layout and adds all appropriate labels,
	 *  text-fields and buttons */
	public InterestCalc(){
		super("Interest Calculator");
		setLayout(new GridLayout(7,2));
		
		A = new JLabel("A or Final Value:");
		add(A);
		At = new JTextField(1);
		add(At);
		
		P = new JLabel("P or Initial Deposit:");
		add(P);
		Pt = new JTextField(1);
		add(Pt);
		
		r = new JLabel("r or Interest Rate:");
		add(r);
		rt = new JTextField(1);
		add(rt);
		
		cont = new JRadioButton("Compoundings are continuous");
		add(cont);
		noncont = new JRadioButton("Compoundings are non-continuous");
		add(noncont);
		
		n = new JLabel("n or number of compoundings per year:");
		add(n);
		nt = new JTextField(1);
		add(nt);
		
		t = new JLabel("t or number of years invested:");
		add(t);
		tt = new JTextField(1);
		add(tt);
		
		calculate = new JButton("Calculate");
		add(calculate);
		
		result = new JLabel();
		platform = new JPanel();
		platform.add(result);
		add(platform);
		
		// Create new actionHandler object
		actionHandler handler = new actionHandler();
		// Add action listeners to the calculate button and to the radio buttons
		calculate.addActionListener(handler);
		cont.addActionListener(handler);
		noncont.addActionListener(handler);
	}
	/** Creates new InterestCalc object, and sets the size, and the visibility
	 *  to true.*/
	public static void main(String args[]) {
		InterestCalc IC = new InterestCalc();
		
		// Set size
		IC.setPreferredSize(new Dimension(700,300));
		IC.pack();
		
		// Make it visible
		IC.setVisible(true);
		
	}
	private class actionHandler implements ActionListener{
		/** Actions when  the radio buttons (continuous and non-continuous
		 *  compound options) are clicked, and when the the calculate button
		 *  is clicked */
		public void actionPerformed(ActionEvent e) {
			// Selecting continuous radio button should disable the non-continuous,
			// and should disable the text box to get the number of compounds (n)
			if(e.getSource()==cont) {
				noncont.setSelected(false);
				nt.setText(""); 
				nt.setEnabled(false);  
			}
			// Selecting non-continuous radio button should disable the continuous
			// and should enable the text box to get the number of compounds (n)
			if(e.getSource()==noncont) {
				cont.setSelected(false);
				nt.setEnabled(true);
			}
			// Action when the calculate button is pressed
		    else if (e.getSource()==calculate) {
		    	String Aval = At.getText();
				String Pval = Pt.getText();
				String rval = tt.getText();
				String nval = nt.getText();
				String tval = rt.getText();
				// Scenario when compounds are continuous
		    	if (cont.isSelected()==true) {
		    		// Case when A (final amount) is the only text field not written in
		    		if (Aval.equals("")&&!Pval.equals(null)&&!tval.equals(null)&&
							!rval.equals(null)) {
		    			// Try to parse all textFields with values in them to doubles
						try {
						    Double Pvalue = Double.parseDouble(Pval);
							Double rvalue = Double.parseDouble(rval);
							Double tvalue = Double.parseDouble(tval);
							Double Avalue = Pvalue*Math.pow(Math.E,rvalue*tvalue);
							result.setText("<html>The A or final value is:<br> $"+ 
							    Double.toString(Avalue) + "</html>");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException
						catch(NumberFormatException y) {
							result.setText("Please enter valid numeric " +
									"inputs for all fields");
						}	
		    	    }
		    		// Case when P (initial amount) is the only text field not written in
		    		else if(!Aval.equals(null)&&Pval.equals("")&&!tval.equals(null)&&
							!rval.equals(null)) {
		    			// Try to parse all textFields with values in them to doubles
		    			try {
						    Double Avalue = Double.parseDouble(Aval);
							Double rvalue = Double.parseDouble(rval);
							Double tvalue = Double.parseDouble(tval);
							Double Pvalue = Avalue/(Math.pow(Math.E,rvalue*tvalue));
							result.setText("<html>The P or initial deposit must have been:<br> $"+ 
							    Double.toString(Pvalue) + "</html>");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException 
		    			catch(NumberFormatException y) {
							result.setText("Please enter valid numeric " +
									"inputs for all fields");
						}	
		    		}
		    		// Case when t (time in years) is the only text field not written in
		    		else if(!Aval.equals(null)&&!Pval.equals(null)&&tval.equals("")&&
							!rval.equals(null)) {
		    			// Try to parse all textFields with values in them to doubles
		    			try {
						    Double Avalue = Double.parseDouble(Aval);
							Double Pvalue = Double.parseDouble(Pval);
							Double rvalue = Double.parseDouble(rval);
							Double tvalue = (Math.log(Avalue)-Math.log(Pvalue))/rvalue;
							result.setText("<html>The t or total elapsed time must have been:<br>"+ 
							    Double.toString(tvalue) + "</html>");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException
		    			catch(NumberFormatException y) {
							result.setText("Please enter valid numeric " +
									"inputs for all fields");
						}	
		    		}
		    		// Case when r (interest rate) is the only text field not written in
		    		else if(!Aval.equals(null)&&!Pval.equals(null)&&!tval.equals(null)&&
							rval.equals("")) {
		    			// Try to parse all textFields with values in them to doubles
		    			try {
						    Double Avalue = Double.parseDouble(Aval);
							Double Pvalue = Double.parseDouble(Pval);
							Double tvalue = Double.parseDouble(rval);
							Double rvalue = (Math.log(Avalue)-Math.log(Pvalue))/tvalue;
							result.setText("<html>The r or interest rate must have been:<br>"+ 
							    Double.toString(rvalue) + "</html>");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException 
		    			catch(NumberFormatException y) {
							result.setText("Please enter valid numeric " +
									"inputs for all fields");
						}
		    		}
		    		else if(!Aval.equals(null)&&!Pval.equals(null)&&!tval.equals(null)&&
							!rval.equals(null)) {
		    			// Try to parse all textFields with values in them to doubles
		    			try {
						    Double Avalue = Double.parseDouble(Aval);
							Double Pvalue = Double.parseDouble(Pval);
							Double rvalue = Double.parseDouble(rval);
							Double tvalue = Double.parseDouble(rval);
						    // Case when the values are valid, plus or minus .1
						    if((Avalue<Pvalue*Math.pow(Math.E,rvalue*tvalue)+.1)&&
						    		Avalue>Pvalue*Math.pow(Math.E, rvalue*tvalue)-.1)
						    {
						    	result.setText("Yes, this is true!");
						    }
						    else {
						    	result.setText("No, this is false!");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException 
		    			} catch(NumberFormatException y) {
							result.setText("Please enter valid numeric " +
									"inputs for all fields");
						}
		    		}
		    		else {
						result.setText("<html>This is not a valid input.<br> All but one fields should be filled in</html>");
					}
		    		
		    	}
		    	
		    	// Scenario when compounds are non-continuous
		    	else if(noncont.isSelected()==true) {
		    		// Case when A (final amount) is the only text field not written in
					if (Aval.equals("")&&!Pval.equals(null)&&!tval.equals(null)&&
							!nval.equals(null)&&!rval.equals(null)) {
						// Try to parse all textFields with values in them to doubles
						try {
						    Double Pvalue = Double.parseDouble(Pval);
							Double nvalue = Double.parseDouble(nval);
							Double rvalue = Double.parseDouble(rval);
							Double tvalue = Double.parseDouble(tval);
							Double Avalue = Pvalue*Math.pow((1+((rvalue)/(nvalue))),nvalue*tvalue);
							result.setText("<html>The A or final value is:<br> $"+ 
							    Double.toString(Avalue) + "</html>");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException 
						catch(NumberFormatException y) {
							result.setText("Please enter valid numeric " +
									"inputs for all fields");
						}
					}	
					// Case when C (initial amount) is the only text field not written in
					else if(!Aval.equals(null)&&Pval.equals("")&&!tval.equals(null)&&
							!nval.equals(null)&&!rval.equals(null)) {
						// Try to parse all textFields with values in them to doubles
					    try {
					    	Double Avalue = Double.parseDouble(Aval);
							Double nvalue = Double.parseDouble(nval);
							Double rvalue = Double.parseDouble(rval);
							Double tvalue = Double.parseDouble(tval);
							Double Pvalue = Avalue/(Math.pow(1+rvalue/nvalue,nvalue*tvalue));
							result.setText("<html>The P or initial deposit must have been:<br>$" + 
							    Double.toString(Pvalue)+"</html>");
					    } // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException
					    catch(NumberFormatException y) {
					    	result.setText("Please enter valid numeric inputs for all fields");
					    }				
					}
					// Case when t (time in years) is the only text field not written in
					else if (!Aval.equals(null)&&!Pval.equals(null)&&tval.equals("")&&
							!nval.equals(null)&&!rval.equals(null)) {
						// Try to parse all textFields with values in them to doubles
						try {
							Double Avalue = Double.parseDouble(Aval);
						    Double Pvalue = Double.parseDouble(Pval);
						    Double nvalue = Double.parseDouble(nval);
						    Double rvalue = Double.parseDouble(rval);
						    Double tvalue = Math.log(Avalue/Pvalue)/
						    		(nvalue*Math.log(1+rvalue/nvalue));
						    result.setText("<html>The t or total elapsed time must have been:<br>" + 
						    		Double.toString(tvalue)+ " years</html>");
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException
						catch(NumberFormatException y) {
							result.setText("Please enter valid numeric inputs for all fields");
						}		 				
				}
				// Case when r (interest rate) is the only text field not written in
					else if (!Aval.equals(null)&&!Pval.equals(null)&&!tval.equals(null)&&
							!nval.equals(null)&&rval.equals("")) {
						// Try to parse all textFields with values in them to doubles
						try {
							Double Avalue = Double.parseDouble(Aval);
						    Double Pvalue = Double.parseDouble(Pval);
						    Double nvalue = Double.parseDouble(nval);
						    Double tvalue = Double.parseDouble(tval);
						    Double rvalue = nvalue*(Math.pow((Avalue/Pvalue),1/(nvalue*tvalue)));
						    result.setText("<html>The r or interest rate must have been: <br>"+ 
						        Double.toString(rvalue)+"</html>");	
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException 
						catch(NumberFormatException y) {
							result.setText("Please enter valid numeric inputs for all fields");
						}
					}
					// Case when all fields are filled in. Is either true or false
					else if((!Aval.equals(null)&&!Pval.equals(null)&&!tval.equals(null)&&
							!nval.equals(null)&&!rval.equals(null))) {
						// Try to parse all textFields with values in them to doubles
						try {
							Double Avalue = Double.parseDouble(Aval);
						    Double Pvalue = Double.parseDouble(Pval);
						    Double rvalue = Double.parseDouble(Pval);
						    Double nvalue = Double.parseDouble(nval);
						    Double tvalue = Double.parseDouble(tval);
						    // Case when the values are valid, plus or minus .1
						    if((Avalue<Pvalue*Math.pow((1+((rvalue)/(nvalue))),nvalue*tvalue)+.1)&&
						    		Avalue>Pvalue*Math.pow((1+((rvalue)/(nvalue))),nvalue*tvalue)-.1)
						    {
						    	result.setText("Yes, this is true!");
						    }
						    else {
						    	result.setText("No, this is false!");
						    }
						} // If all textFields with values in them cannot be parsed to 
						  // doubles, throw a NumberFormatException 
						catch(NumberFormatException y) {
							result.setText("Please enter valid numeric inputs for all fields");
					}
					}
					else {
						result.setText("<html>This is not a valid input.<br> All but one fields should be filled in</html>");
					}
		    	}		
		    }
	    }
    }
}




