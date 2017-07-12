import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterestCalc extends JFrame {
	/*private JLabel P;
	private JTextField Pt;
	private JLabel C;
	private JTextField Ct;
	private JLabel r;
	private JTextField rt;
	private JLabel n;
	private JTextField nt;
	private JLabel t;
	private JTextField tt;**/
	
	public InterestCalc(){
		super("Interest Calculator");
		setLayout(new FlowLayout());
		
		JLabel P = new JLabel("P or Future Value:");
		add(P);
		JTextField Pt = new JTextField(10);
		add(Pt);
		
		JLabel C = new JLabel("C or Initial Deposit:");
		add(C);
		JTextField Ct = new JTextField(10);
		add(Ct);
		
		JLabel r = new JLabel("r or Interest Rate:");
		add(r);
		JTextField rt = new JTextField(10);
		add(rt);
		
		JLabel n = new JLabel("n or number of compoundings per year:");
		add(n);
		JTextField nt = new JTextField(10);
		add(nt);
		
		JLabel t = new JLabel("t or number of years invested:");
		add(t);
		JTextField tt = new JTextField(10);
		add(tt);
		
		JButton calc = new JButton("Calculate");
		add(calc);
	}
	public static void main(String args[]) {
		InterestCalc IC = new InterestCalc();
		
		// Set size
		IC.setPreferredSize(new Dimension(500,500));
		IC.pack();
		
		// Make it visible
		IC.setVisible(true);
		
	}

}
