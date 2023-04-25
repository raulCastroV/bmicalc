package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class EuropeanCalc implements IMCHospital {
	
	BMICalcImpl calculadora;

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

	@Override
	public String mensaje(double altura, double peso, double imc) {
		String mensaje = "La persona con altura " + altura + " metros y " + peso + " kilos de peso tiene un IMC de " + imc + ".";
		return mensaje;
	}
}
