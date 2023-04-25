package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class BMICalcAdapter implements IMCHospital {
	private BMICalcImpl calculadora;
	
	public BMICalcAdapter(BMICalcImpl calc) {
		this.calculadora = calc;
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> map = new HashMap<>(); 
		Double bmi = calculadora.bmi(altura, peso);
		String category = calculadora.category(bmi);
		map.put(bmi, category);
		return map;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		boolean obesity = calculadora.abdominalObesity(circunferencia, genero);
		return obesity;
	}
}
