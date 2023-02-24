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
	
	@Test
	public void bmiMaxMassHeight() {
		double mass = 641;
		double height = 1.80;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.bmi(mass, height));
		String expectedMessage = "Mass must be lower than 640";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmiMaxHeight() {
		double mass = 58;
		double height = 276;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.bmi(mass, height));
		String expectedMessage = "Height must be lower than 275";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void categoryBMI0() {
		double bmi = 0;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.category(bmi));
		String expectedMessage = "BMI must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void categoryUnderweight() {
		double bmi = 17;
		
		assertEquals("Underweight", calc.category(bmi));
	}
	
	@Test
	public void categoryNormal() {
		double bmi = 20;
		
		assertEquals("Normal", calc.category(bmi));
	}
	
	@Test
	public void categoryOverweight() {
		double bmi = 27;
		
		assertEquals("Overweight", calc.category(bmi));
	}
	
	@Test
	public void categoryObese() {
		double bmi = 30;
		
		assertEquals("Obese", calc.category(bmi));
	}
}
