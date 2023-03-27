package bmicalc.gui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Vista extends JFrame {
	
	private Container c;
    private JLabel titleBMI, titleWaist;
    private JLabel lHeight;
    private JTextField tHeight;
    private JLabel lMass;
    private JTextField tMass;
    private JLabel lWaist;
    private JTextField tWaist;
    private JButton bBMI;
    private JButton bWaist;
    private JLabel resBMI;
    private JLabel resWaist;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
    
	public Vista() {
		
	        setTitle("CALCULATOR");
	        setBounds(300, 90, 500, 415);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	        c.setBackground(new Color(67, 136, 204));
	 
	        titleBMI = new JLabel("BMI CALCULATOR");
	        titleBMI.setFont(new Font("Arial", Font.PLAIN, 15));
	        titleBMI.setSize(360, 30);
	        titleBMI.setLocation(120, 30);
	        c.add(titleBMI);
	 
	        lHeight = new JLabel("Height(m):");
	        lHeight.setFont(new Font("Arial", Font.PLAIN, 10));
	        lHeight.setSize(100, 20);
	        lHeight.setLocation(50, 80);
	        c.add(lHeight);
	 
	        tHeight = new JTextField();
	        tHeight.setFont(new Font("Arial", Font.PLAIN, 10));
	        tHeight.setSize(100, 20);
	        tHeight.setLocation(100, 80);
	        c.add(tHeight);
	 
	        lMass = new JLabel("Mass(kg):");
	        lMass.setFont(new Font("Arial", Font.PLAIN, 10));
	        lMass.setSize(100, 20);
	        lMass.setLocation(50, 100);
	        c.add(lMass);
	 
	        tMass = new JTextField();
	        tMass.setFont(new Font("Arial", Font.PLAIN, 10));
	        tMass.setSize(100, 20);
	        tMass.setLocation(100, 100);
	        c.add(tMass);
	        
	        bBMI = new JButton("Calculate");
	        bBMI.setFont(new Font("Arial", Font.PLAIN, 10));
	        bBMI.setSize(100, 20);
	        bBMI.setLocation(50, 125);
	        c.add(bBMI);
	        
	        resBMI = new JLabel("");
	        resBMI.setFont(new Font("Arial", Font.BOLD, 15));
	        resBMI.setSize(500, 25);
	        resBMI.setLocation(50, 165);
	        c.add(resBMI);
	        
	        titleWaist = new JLabel("ABDOMINAL OBESITY CALCULATOR");
	        titleWaist.setFont(new Font("Arial", Font.PLAIN, 15));
	        titleWaist.setSize(300, 30);
	        titleWaist.setLocation(110, 200);
	        c.add(titleWaist);
	 
	        lWaist = new JLabel("Waist Circumference(cm):");
	        lWaist.setFont(new Font("Arial", Font.PLAIN, 10));
	        lWaist.setSize(300, 20);
	        lWaist.setLocation(50, 250);
	        c.add(lWaist);
	 
	        tWaist = new JTextField();
	        tWaist.setFont(new Font("Arial", Font.PLAIN, 10));
	        tWaist.setSize(100, 20);
	        tWaist.setLocation(180, 250);
	        c.add(tWaist);
	        
	        gender = new JLabel("Gender:");
	        gender.setFont(new Font("Arial", Font.PLAIN, 10));
	        gender.setSize(100, 20);
	        gender.setLocation(50, 275);
	        c.add(gender);
	 
	        male = new JRadioButton("Male");
	        male.setFont(new Font("Arial", Font.PLAIN, 10));
	        male.setSelected(true);
	        male.setSize(75, 20);
	        male.setLocation(180, 275);
	        c.add(male);
	 
	        female = new JRadioButton("Female");
	        female.setFont(new Font("Arial", Font.PLAIN, 10));
	        female.setSelected(false);
	        female.setSize(80, 20);
	        female.setLocation(255, 275);
	        c.add(female);
	 
	        gengp = new ButtonGroup();
	        gengp.add(male);
	        gengp.add(female);
	        
	        bWaist = new JButton("Calculate");
	        bWaist.setFont(new Font("Arial", Font.PLAIN, 10));
	        bWaist.setSize(100, 20);
	        bWaist.setLocation(50, 300);
	        c.add(bWaist);
	 
	        resWaist = new JLabel("");
	        resWaist.setFont(new Font("Arial", Font.BOLD, 15));
	        resWaist.setSize(500, 25);
	        resWaist.setLocation(50, 335);
	        c.add(resWaist);
	 
	       
	 
	        setVisible(true);
	    
	}
	
	public double getInputHeight() {
		try {
			return Double.parseDouble(tHeight.getText());	
		} catch (NumberFormatException e) {
			resBMI.setText("Introduce un numero valido.");
			return -1;
		}
	}
	
	public double getInputMass() {
		try {
			return Double.parseDouble(tMass.getText());	
		} catch (NumberFormatException e) {
			resBMI.setText("Introduce un numero valido.");
			return -1;
		}
	}
	
	public void setResutadoBMI(double res, String cat) {
		resBMI.setText("Your BMI is: " + res + " (" + cat + ")");
	}
	
	public void registrarControlador(ActionListener ctrl) {
		bBMI.addActionListener(ctrl);
		bBMI.setActionCommand("CalcularBMI");
		bWaist.addActionListener(ctrl);
		bWaist.setActionCommand("CalcularAbdominal");
	}
	
	public void errorBMI(String msg) {
		resBMI.setText(msg);
	}
	
	public double getInputWaist() {
		try {
			return Double.parseDouble(tWaist.getText());	
		} catch (NumberFormatException e) {
			resWaist.setText("Introduce un numero valido.");
			return -1;
		}
	}
	
	public char getInputGender() {
		try {
			if (male.isSelected()) {
				return 'M';
			}
			else {
				return 'F';
			}
				
		} catch (NumberFormatException e) {
			resWaist.setText("Introduce un numero valido.");
			return 'N';
		}
	}
	
	public void setResutadoWaist(boolean b) {
		if (b) resWaist.setText("You have abdominal obesity");
		else resWaist.setText("You don't have abdominal obesity");
		
	}
	
	public void errorWaist(String msg) {
		resWaist.setText(msg);
	}
}
