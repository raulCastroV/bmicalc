package bmicalc;

import java.util.Map;

public interface IMCHospital {
	
	public Map<Double, String> imc(double altura, double peso);
	
	public boolean tieneObesidadAbdominal(char genero, double circunferencia);
	
	public String mensaje(double altura, double peso, double imc);
	
}
