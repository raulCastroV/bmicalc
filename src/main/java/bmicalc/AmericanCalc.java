package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class AmericanCalc implements IMCHospital {
	
	BMICalcImpl calculadora;

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> map = new HashMap<>(); 
		Double pulgadas = altura*12;
		Double bmi = (peso*703)/(pulgadas*pulgadas);
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
		// TODO Auto-generated method stub
		String mensaje = "The person with height " + altura +" feet and " + peso + " pounds of weight has an IMC of " + imc + ".";
		return mensaje;
	}

}
