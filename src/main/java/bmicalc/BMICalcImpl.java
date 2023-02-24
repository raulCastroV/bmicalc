package bmicalc;

public class BMICalcImpl implements BMICalc {

	public double bmi(double mass, double height) {
		if (mass<=0 || height<=0)
			throw new IllegalArgumentException("Mass and height must be higher than 0");
		if (mass>640)
			throw new IllegalArgumentException("Mass must be lower than 640");
		if (height>275)
			throw new IllegalArgumentException("Height must be lower than 275");
		
		double bmi = (mass/(height*height));
		
		return bmi;
	}

	public String category(double bmi) {
		if (bmi<=0)
			throw new IllegalArgumentException("BMI must be higher than 0");
		
		if (bmi < 18.5) {
			return "Underweight";
		} else if (bmi < 25) {
			return "Normal";
		} else if (bmi < 30) {
			return "Overweight";
		} else {
			return "Obese";
		}
	}

	public boolean abdominalObesity(double waistCircumference, char gender) {
		return false;
	}

}
