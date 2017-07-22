import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class InterestCalc extends JFrame {
	private JLabel A;
	private JTextField At;
	private JLabel C;
	private JTextField Ct;
	private JLabel r;
	private JTextField rt;
	private JLabel n;
	private JTextField nt;
	private JLabel t;
	private JTextField tt;
	private JButton calculate;
	private JLabel result;
	private JPanel platform;
	
	public InterestCalc(){
		/* Constructor sets up layout and adds all appropiate labels,
		text-fields and buttons**/
		super("Interest Calculator");
		setLayout(new GridLayout(8,2));
		
		A = new JLabel("A or Final Value:");
		add(A);
		At = new JTextField(1);
		add(At);
		
		C = new JLabel("C or Initial Deposit:");
		add(C);
		Ct = new JTextField(1);
		add(Ct);
		
		r = new JLabel("r or Interest Rate:");
		add(r);
		rt = new JTextField(1);
		add(rt);
		
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
		
		
		theHandler1 handler1 = new theHandler1();
		calculate.addActionListener(handler1);
	}
	
	public static void main(String args[]) {
		InterestCalc IC = new InterestCalc();
		
		// Set size
		IC.setPreferredSize(new Dimension(700,300));
		IC.pack();
		
		// Make it visible
		IC.setVisible(true);
		
	}
	private class theHandler1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// Only want action when the calculate button is pressed
			if (e.getSource()==calculate) {
				String Aval = At.getText();
				String Cval = Ct.getText();
				String tval = rt.getText();
				String nval = nt.getText();
				String rval = tt.getText();
				double value;
				// Scenario when A (final amount) is the only text field not written in
				if (Aval.equals("")&&!Cval.equals(null)&&!tval.equals(null)&&
						!nval.equals(null)&&!rval.equals(null)) {
					try {
					    Double Cvalue = Double.parseDouble(Cval);
					    Double tvalue = Double.parseDouble(tval);
						Double nvalue = Double.parseDouble(nval);
						Double rvalue = Double.parseDouble(rval);
						Double Avalue = Cvalue*Math.pow((1+((rvalue)/(nvalue))),nvalue*tvalue);
						result.setText("The A or final value is: $"+ 
						    Double.toString(Avalue));
					} catch(NumberFormatException y) {
						result.setText("Please enter valid numeric " +
								"inputs for all fields");
					}
				}	
				// Scenario when C (initial amount) is the only text field not written in
				else if(!Aval.equals(null)&&Cval.equals("")&&!tval.equals(null)&&
						!nval.equals(null)&&!rval.equals(null)) {
				    try {
				    	Double Avalue = Double.parseDouble(Aval);
						Double tvalue = Double.parseDouble(tval);
						Double nvalue = Double.parseDouble(nval);
						Double rvalue = Double.parseDouble(rval);
						Double Cvalue = Avalue/(Math.pow(1+rvalue/nvalue,nvalue*tvalue));
						result.setText("The C or initial deposit must have been: $" + 
						    Double.toString(Cvalue));
				    } catch(NumberFormatException y) {
				    	result.setText("Please enter valid numeric inputs for all fields");
				    }
					
				}
				// Schenario when t (time in years) is the only text field not written in
				else if (!Aval.equals(null)&&!Cval.equals(null)&&tval.equals("")&&
						!nval.equals(null)&&!rval.equals(null)) {
					try {
						Double Avalue = Double.parseDouble(Aval);
					    Double Cvalue = Double.parseDouble(Cval);
					    Double nvalue = Double.parseDouble(nval);
					    Double rvalue = Double.parseDouble(rval);
					    Double tvalue = Math.log(Avalue/Cvalue)/
					    		(nvalue*Math.log(1+rvalue/nvalue));
					    result.setText("The t or total elapsed time must have been:" + 
					    		Double.toString(tvalue)+ " years");
					} catch(NumberFormatException y) {
						result.setText("Please enter valid numeric inputs for all fields");
					}
						    
			}
			// Scenario when r (interest rate) is the only text field not written in
				else if (!Aval.equals(null)&&!Cval.equals(null)&&!tval.equals(null)&&
						!nval.equals(null)&&rval.equals("")) {
					try {
						Double Avalue = Double.parseDouble(Aval);
					    Double Cvalue = Double.parseDouble(Cval);
					    Double tvalue = Double.parseDouble(tval);
					    Double nvalue = Double.parseDouble(nval);
					    Double rvalue = nvalue*(Math.pow((Avalue/Cvalue),1/(nvalue*tvalue)));
					    result.setText("The r or interest rate must have been: "+ 
					        Double.toString(rvalue)+" years");	
					} catch(NumberFormatException y) {
						result.setText("Please enter valid numeric inputs for all fields");
					}
				}
				else {
					result.setText("This is not a valid input. All but one fields should be filled in");
				}
		}
	}
	}
}



