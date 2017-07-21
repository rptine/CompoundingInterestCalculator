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
		
		A = new JLabel("P or Future Value:");
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
		
		result = new JLabel("hello");
		platform = new JPanel();
		platform.add(result);
		add(platform);
		
		
		theHandler1 handler1 = new theHandler1();
		calculate.addActionListener(handler1);
	}
	
	public static void main(String args[]) {
		InterestCalc IC = new InterestCalc();
		
		// Set size
		IC.setPreferredSize(new Dimension(500,500));
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
				// Scenario when A or final amount is the only text field not written in
				if (Aval.equals("")&&!Cval.equals(null)&&!tval.equals(null)&&!nval.equals(null)&&!rval.equals(null)) {
					Double Cvalue = Double.parseDouble(Cval);
					Double tvalue = Double.parseDouble(tval);
					Double nvalue = Double.parseDouble(nval);
					Double rvalue = Double.parseDouble(rval);
					value = Cvalue*Math.pow((1+((rvalue)/(nvalue))),nvalue*tvalue);
					result.setText("Your A or future value is: $"+ Double.toString(value));
				}	
				// Scenario when C or initial amount is the only text field not written in
				else if(!Aval.equals(null)&&Cval.equals("")&&!tval.equals(null)&&!nval.equals(null)&&!rval.equals(null)) {
					Double Avalue = Double.parseDouble(Aval);
					Double tvalue = Double.parseDouble(tval);
					Double nvalue = Double.parseDouble(nval);
					Double rvalue = Double.parseDouble(rval);
					value = Avalue/(Math.pow(1+rvalue/nvalue,nvalue*tvalue));
					result.setText("Your C or initial deposit must have been: $" +Double.toString(value));
				}
				
			}
		}
	}
	}



