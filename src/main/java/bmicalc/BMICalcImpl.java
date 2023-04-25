package bmicalc;

import java.util.ArrayList;
import java.util.List;

public class BMICalcImpl implements BMICalc {
	
	private static BMICalcImpl instance;
    private double height;
    private double mass;
    private double bmi;
    private List<IMCStats> observers;
	
	private BMICalcImpl() {
        observers = new ArrayList<>();
	}
	
	public static BMICalcImpl getInstance() {
		if (instance == null) {
			instance = new BMICalcImpl();
		}
		return instance;
	}

	public double bmi(double mass, double height) {
		if (mass<=0 || height<=0)
			throw new IllegalArgumentException("Mass and height must be higher than 0");
		if (mass>640)
			throw new IllegalArgumentException("Mass must be lower than 640");
		if (height>2.75)
			throw new IllegalArgumentException("Height must be lower than 2.75");
		
		double bmi = (mass/(height*height));
		this.height = height;
		this.mass = mass;
		this.bmi = bmi;
		notifyObservers();
		
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
		System.out.println(Character.toString(gender).toUpperCase().equals("M"));
		if (waistCircumference<40)
			throw new IllegalArgumentException("Waist circumference must be higher than 40 centimeters");
		if (waistCircumference>325)
			throw new IllegalArgumentException("Waist circumference must be lower than 325 centimeters");
		if (!Character.toString(gender).toUpperCase().equals("M") && !Character.toString(gender).toUpperCase().equals("F"))
			throw new IllegalArgumentException("Gender must be M(male) or F(female)");
		
		if (waistCircumference >= 90 && Character.toString(gender).toUpperCase().equals("M")) {
			return true;
		} else if (waistCircumference >= 80 && Character.toString(gender).toUpperCase().equals("F")) {
			return true;
		}
		return false;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getMass() {
		return this.mass;
	}
	
	public double getBMI() {
		return this.bmi;
	}
	
	public void addObserver(IMCStats observer) {
        observers.add(observer);
    }

    public void removeObserver(IMCStats observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IMCStats observer : observers) {
            observer.update();
        }
    }

}
