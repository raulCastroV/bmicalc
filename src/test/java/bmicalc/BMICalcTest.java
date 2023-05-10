package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BMICalcTest {
private CardiovascularMetrics cardioCalc = new BMICalcImpl();
private MetabolicMetrics metaCalc = new BMICalcImpl();
	
	@Test
	public void bmiNormal() {
		double mass = 50;
		double height = 1.70;
		assertEquals(17.30, (double)Math.round(cardioCalc.calculateBodyMassIndex(mass, height)*100)/100);
	}
	
	@Test
	public void bmiNegativeMass() {
		double mass = -50;
		double height = 1.70;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cardioCalc.calculateBodyMassIndex(mass, height));
		String expectedMessage = "Mass and height must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmiNegativeHeight() {
		double mass = 50;
		double height = -1.70;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cardioCalc.calculateBodyMassIndex(mass, height));
		String expectedMessage = "Mass and height must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmi0MassHeight() {
		double mass = 0;
		double height = 0;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cardioCalc.calculateBodyMassIndex(mass, height));
		String expectedMessage = "Mass and height must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmiMaxMassHeight() {
		double mass = 641;
		double height = 1.80;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cardioCalc.calculateBodyMassIndex(mass, height));
		String expectedMessage = "Mass must be lower than 640";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void bmiMaxHeight() {
		double mass = 58;
		double height = 2.76;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cardioCalc.calculateBodyMassIndex(mass, height));
		String expectedMessage = "Height must be lower than 2.75";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void categoryBMI0() {
		double bmi = 0;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cardioCalc.getObesityCategory(bmi));
		String expectedMessage = "BMI must be higher than 0";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void categoryUnderweight() {
		double bmi = 17;
		
		assertEquals(ObesityCategory.UNDERWEIGHT, cardioCalc.getObesityCategory(bmi));
	}
	
	@Test
	public void categoryNormal() {
		double bmi = 20;
		
		assertEquals(ObesityCategory.NORMAL, cardioCalc.getObesityCategory(bmi));
	}
	
	@Test
	public void categoryOverweight() {
		double bmi = 27;
		
		assertEquals(ObesityCategory.OVERWEIGHT, cardioCalc.getObesityCategory(bmi));
	}
	
	@Test
	public void categoryObese() {
		double bmi = 30;
		
		assertEquals(ObesityCategory.OBESE, cardioCalc.getObesityCategory(bmi));
	}
	
	@Test
	public void abdominalObesityMinWaist() {
		double waistCircunference = 35;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> metaCalc.abdominalObesity(waistCircunference, Gender.MALE));
		String expectedMessage = "Waist circumference must be higher than 40 centimeters";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void abdominalObesityMaxWaist() {
		double waistCircunference = 330; 
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> metaCalc.abdominalObesity(waistCircunference, Gender.FEMALE));
		String expectedMessage = "Waist circumference must be lower than 325 centimeters";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void abdominalObesityFalseMale() {
		double waistCircunference = 70;
		
		assertFalse(metaCalc.abdominalObesity(waistCircunference, Gender.MALE));
	}
	
	@Test
	public void abdominalObesityTrueMale() {
		double waistCircunference = 100;
		
		assertTrue(metaCalc.abdominalObesity(waistCircunference, Gender.MALE));
	}
	
	@Test
	public void abdominalObesityFalseFemale() {
		double waistCircunference = 70;
		
		assertFalse(metaCalc.abdominalObesity(waistCircunference, Gender.FEMALE));
	}
	
	@Test
	public void abdominalObesityTrueFemale() {
		double waistCircunference = 100;
		
		assertTrue(metaCalc.abdominalObesity(waistCircunference, Gender.FEMALE));
	}
}
