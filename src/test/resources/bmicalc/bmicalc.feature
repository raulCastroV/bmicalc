@tag
Feature: BMI calculation
	As a User I want to know my exact BMI value so that I can know how far I am from the category I should reach.

	@tag1
	Scenario: Normal height and mass values
		Given I have a bmi calculator
		When I introduce a mass value of 77.60 and a height value of 1.80
		Then return a BMI value of 24.0

	@tag2
	Scenario: Mass value equal or lower than zero
		Given I have a bmi calculator
		When I introduce a mass value of -50.0 and a height value of 1.70
		Then throw error message
		
	@tag3
	Scenario: Height value equal or lower than zero
		Given I have a bmi calculator
		When I introduce a mass value of 50.0 and a height value of -1.70
		Then throw error message

	@tag4
	Scenario: Mass and height equals or lower than zero
		Given I have a bmi calculator
		When I introduce a mass value of 0.0 and a height value of 0.0
		Then throw error message

	@tag5
	Scenario: Mass higher than 640 kg
		Given I have a bmi calculator
		When I introduce a mass value of 641.0 and a height value of 1.80
		Then throw error message

	@tag6
	Scenario: Height higher than 2.75 m
		Given I have a bmi calculator
		When I introduce a mass value of 58.0 and a height value of 2.76
		Then throw error message