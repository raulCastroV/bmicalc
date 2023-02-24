package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalcTest {
private BMICalcImpl calc = new BMICalcImpl();
	
	@Test
	public void bmiNormal() {
		double mass = 50;
		double height = 1.70;
		assertEquals(17.30, (double)Math.round(calc.bmi(mass, height)*100)/100);
	}
}
