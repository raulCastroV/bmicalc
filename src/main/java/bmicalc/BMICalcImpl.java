package bmicalc;

public class BMICalcImpl  {

	public double bmi(double mass, double height) {
		if (mass<=0 || height<=0)
			throw new IllegalArgumentException("Mass and height must be higher than 0");
		if (mass>640)
			throw new IllegalArgumentException("Mass must be lower than 640");
		if (height>2.75)
			throw new IllegalArgumentException("Height must be lower than 2.75");
		
		double bmi = (mass/(height*height));
		
		return bmi;
	}

	public ObesityCategory getObesityCategory(double bmi) {
		if (bmi<=0)
			throw new IllegalArgumentException("BMI must be higher than 0");
		
		if (bmi < 18.5) {
			return ObesityCategory.UNDERWEIGHT;
		} else if (bmi < 25) {
			return ObesityCategory.NORMAL;
		} else if (bmi < 30) {
			return ObesityCategory.OVERWEIGHT;
		} else {
			return ObesityCategory.OBESE;
		}
	}

	public boolean abdominalObesity(double waistCircumference, Gender gender) {
		if (waistCircumference<40)
			throw new IllegalArgumentException("Waist circumference must be higher than 40 centimeters");
		if (waistCircumference>325)
			throw new IllegalArgumentException("Waist circumference must be lower than 325 centimeters");
		
		if (waistCircumference >= 90 && gender.equals(Gender.MALE)) {
			return true;
		} else if (waistCircumference >= 80 && gender.equals(Gender.FEMALE)) {
			return true;
		}
		return false;
	}

}
