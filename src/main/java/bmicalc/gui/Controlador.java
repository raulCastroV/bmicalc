package bmicalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;

public class Controlador implements ActionListener {
	
	private BMICalcImpl modelo;
	private Vista vista;
	
	public Controlador(BMICalcImpl modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("CalcularBMI")) {
			double m = vista.getInputMass();
			double h = vista.getInputHeight();
			try {
				double bmi = modelo.bmi(m, h);
				String category = modelo.category(bmi);
				vista.setResutadoBMI((double)Math.round(bmi*100)/100, category);
			} catch (IllegalArgumentException error) {
				vista.errorBMI(error.getMessage());
			}
		}
		if (comando.equals("CalcularAbdominal")) {
			double w = vista.getInputWaist();
			char g = vista.getInputGender();
			try {
				boolean ab = modelo.abdominalObesity(w, g);
				vista.setResutadoWaist(ab);
			} catch (IllegalArgumentException error) {
				vista.errorWaist(error.getMessage());
			}
		}
	}
}
