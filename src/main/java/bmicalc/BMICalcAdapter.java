package bmicalc;

import java.util.Map;

public class BMICalcAdapter implements IMCHospital {
	private BMICalcImpl calculadora;
	
	public BMICalcAdapter(BMICalcImpl calc) {
		this.calculadora = calc;
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		
		return null;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		// TODO Auto-generated method stub
		return false;
	}
}
