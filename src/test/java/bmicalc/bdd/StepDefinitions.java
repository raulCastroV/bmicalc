package bmicalc.bdd;

import org.junit.jupiter.api.Assertions;

import bmicalc.BMICalcImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private BMICalcImpl calculator;
	private Double result;
	private boolean exception;
	
	@Before
	public void initialization() {
		calculator = null;
	    result = null;
	    exception = false;
	}
	
	@Given("I have a bmi calculator")
	public void i_have_a_bmi_calculator() {
	    calculator = new BMICalcImpl();
	}

	@When("I introduce a mass value of {double} and a height value of {double}")
	public void i_introduce_a_mass_value_of_and_a_height_value_of(Double double1, Double double2) {
	    try {
	    	result = calculator.bmi(double1, double2);
	    } catch (Exception e) {
	    	exception = true;
	    }
	}

	
	@Then("throw error message")
	public void throw_error_message() {
	    Assertions.assertTrue(exception);
	}
	
	@Then("return a BMI value of {double}")
	public void return_a_bmi_value_of(Double double1) {
	    Assertions.assertEquals(double1,  Math.round(result));
	}
	
}
