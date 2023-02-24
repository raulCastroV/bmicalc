package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BMICalcTest {
private BMICalcImpl calc = new BMICalcImpl();
	
	@Test
	public void bmiNormal() {
		double mass = 50;
		double height = 1.70;
		assertEquals(17.30, (double)Math.round(calc.bmi(mass, height)*100)/100);
	}
	
	@Test
	public void bmiNegativeMass() {
		double mass = -50;
		double height = 1.70;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.bmi(mass, height));
		String expectedMessage = "Mass and height must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmiNegativeHeight() {
		double mass = 50;
		double height = -1.70;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.bmi(mass, height));
		String expectedMessage = "Mass and height must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmi0MassHeight() {
		double mass = 0;
		double height = 0;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.bmi(mass, height));
		String expectedMessage = "Mass and height must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
