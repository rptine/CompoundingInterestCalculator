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
	private JLabel P;
	private JTextField Pt;
	private JLabel C;
	private JTextField Ct;
	private JLabel r;
	private JTextField rt;
	private JLabel n;
	private JTextField nt;
	private JLabel t;
	private JTextField tt;
	private JLabel result;
	private JPanel platform;
	
	public InterestCalc(){
		super("Interest Calculator");
		setLayout(new GridLayout(8,2));
		
		JLabel P = new JLabel("P or Future Value:");
		add(P);
		JTextField Pt = new JTextField(1);
		add(Pt);
		
		JLabel C = new JLabel("C or Initial Deposit:");
		add(C);
		JTextField Ct = new JTextField(1);
		add(Ct);
		
		JLabel r = new JLabel("r or Interest Rate:");
		add(r);
		JTextField rt = new JTextField(1);
		add(rt);
		
		JLabel n = new JLabel("n or number of compoundings per year:");
		add(n);
		JTextField nt = new JTextField(1);
		add(nt);
		
		JLabel t = new JLabel("t or number of years invested:");
		add(t);
		JTextField tt = new JTextField(1);
		add(tt);
		
		JButton calc = new JButton("Calculate");
		add(calc);
		
		theHandler handler = new theHandler();
		calc.addActionListener(handler);
		
		result = new JLabel();
		platform = new JPanel();
		platform.add(result);
		add(platform);
		
	}
	
	public static void main(String args[]) {
		InterestCalc IC = new InterestCalc();
		
		// Set size
		IC.setPreferredSize(new Dimension(500,500));
		IC.pack();
		
		// Make it visible
		IC.setVisible(true);
		
	}
	private class theHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==C) {
				String Pval = Pt.getText();
				String Cval = Ct.getText();
				String tval = rt.getText();
				String nval = nt.getText();
				String rval = tt.getText();
				if (Pval==null&&Cval!=null&&tval!=null&&nval!=null&&rval!=null){
					double y = Math.pow((1+Integer.parseInt(rval))/(Integer.parseInt(nval)),Integer.parseInt(nval)* Integer.parseInt(tval));
					result = new JLabel(Double.toString(y));
					add(result);
					pack();
				}
				
			}
		}
	}
	}



