![example workflow](https://github.com/jmhorcas/bmicalc/actions/workflows/maven.yml/badge.svg)

![](https://github.com/raulCastroV/bmicalc/blob/main/doc/BocetoGUI.pdf)


![](https://github.com/raulCastroV/bmicalc/blob/main/doc/BocetoGUI.png)


![](https://github.com/raulCastroV/bmicalc/blob/main/doc/Model.jpg)

# BMI calculator
A biomedical calculator for the body mass index (BMI) and other parameters.

# Test Cases:

BMI Method:
1. Cuando los valores introducidos estan en un rango normal: bmiNormal()
2. Cuando la masa introducida es negativa: bmiNegativeMass()
3. Cuando la altura introducida es negativa: bmiNegativeHeight()
4. Cuando los valores de la masa y la altura son negativos: bmi0MassHeight()
5. Cuando la masa supera el valor maximo previamente establecido: bmiMaxMassHeight()
6. Cuando la altura supera el valor maximo establecido: bmiMaxHeight()

Category Method:
1. Cuando el valor BMI introducido es igual a 0: categoryBMI0()
2. Cuando el valor BMI introducido corresponde al rango "UNDERWEIGHT": categoryUnderweight()
3. Cuando el valor BMI introducido corresponde al rango "NORMAL": categoryNormal()
4. Cuando el valor BMI introducido corresponde al rango "OVERWEIGHT": categoryOverweight()
5. Cuando el valor BMI introducido corresponde al rango "OBESE": categoryObese()

Abdominal Obesitiy Method:
1. Cuando la medida de cintura introducida es menor que el valor minimo establecido: abdominalObesityMinWaist()
2. Cuando la medida de cintura introducida es mayor que el valor minimo establecido: abdominalObesityMaxWaist()
3. Cuando el genero introducido no coincide con los generos permitidos(F o M): abdominalObesityWrongGender()
4. Cuando la medida de cintura introducida no corresponde con obesidad abdominal y el genero es masculino: abdominalObesityFalseMale()
5. Cuando la medida de cintura introducida corresponde con obesidad abdominal y el genero es masculino: abdominalObesityTrueMale()
6. Cuando la medida de cintura introducida no corresponde con obesidad abdominal y el genero es femenino: abdominalObesityFalseFemale()
7. Cuando la medida de cintura introducida corresponde con obesidad abdominal y el genero es femenino: abdominalObesityTrueFemale()

# Use Case:

USE CASE 1: BMI ESTIMATION
Primary Actor: User
Level: User goal
Stakeholders and Interests:
User - wants to know its BMI
Precondition: User introduces its mass and height
Success guarantees: User introduces its parameters and app show the BMI and category.
Main succes scenario:
1. User select BMI and introduce its mass and height.
2. App calculates BMI.
3. App assign a category.
4. App shows results.
Extensions:
1a. Submitted mass is equal or lower than zero.
1a1. Submitted height is equal or lower than zero.

# User Stories

USER STORY 1:
As a User
I want to know my BMI category
So that I can be aware of my health condition.

	- Scenario: BMI value equal to 0
		Given a category sorter
		When s introduced a BMI value of 0
		Then throw error message

	- Scenario: BMI value equal to 17
		Given a category sorter
		When is introduced a BMI value of 17
		Then return "Underweight"

	- Scenario: BMI value equal to 20
		Given a category sorter
		When is introduced a BMI value of 20
		Then return "Normal"

	- Scenario: BMI value equal to 27
		Given a category sorter
		When is introduced a BMI value of 27 
		Then return "Overweight"

	- Scenario: BMI value equal to 30
		Given a category sorter
		When is introduced a BMI value of 30
		Then return "Obese"

USER STORY 2: 
As a User
I want to know my exact BMI value
So that I can know how far I am from the category I should reach.

	- Scenario: Normal height and mass values
		Given I have a bmi calculator
		When I introduce a mass value of 77.60 and a height value of 1.80
		Then return a BMI value of 24

	- Scenario: Mass value equal or lower than zero
		Given I have a bmi calculator
		When I introduce a mass value of -50 and a height value of 1.70
		Then throw error message
		
	- Scenario: Height value equal or lower than zero
		Given I have a bmi calculator
		When I introduce a mass value of 50 and a height value of -1.70
		Then throw error message

	- Scenario: Mass and height equals or lower than zero
		Given I have a bmi calculator
		When I introduce a mass value of 0 and a height value of 0
		Then throw error message

	- Scenario: Mass higher than 640 kg
		Given I have a bmi calculator
		When I introduce a mass value of 641 and a height value of 1.80
		Then throw error message

	- Scenario: Height higher than 2.75 m
		Given I have a bmi calculator
		When I introduce a mass value of 58 and a height value of 2.76
		Then throw error message


USER STORY 3: 
As a User
I want to know if I have abdominal obesity
So that I can change my lifestyle.

	- Scenario: Waist circumference lower than 40 cm
		Given an abdominal obesity calculator
		When I introduce a waist circumference of 35 and a gender value of 'F'
		Then throw error message

	- Scenario: Waist circumference higher than 325 cm
		Given waist circumference of 330 cm
		And gender value of 'F'
		When I introduce a waist circumference of 330 and a gender value of 'F'
		Then throw error message

	- Scenario: Incorrect gender
		Given an abdominal obesity calculator
		When I introduce a waist circumference of 70 and a gender value of 'J'
		Then throw error message

	- Scenario: Male gender and waist circumference lower than 90
		Given an abdominal obesity calculator
		When I introduce a waist circumference of 70 and a gender value of 'M'
		Then return false

	- Scenario: Male gender and waist circumference higher than 90
		Given an abdominal obesity calculator
		When I introduce a waist circumference of 100 and a gender value of 'M'
		Then return true

	- Scenario: Female gender and waist circumference lower than 80
		Given an abdominal obesity calculator
		When I introduce a waist circumference of 70 and a gender value of 'F'
		Then return false

	- Scenario: Female gender and waist circumference higher than 80
		Given an abdominal obesity calculator
		When I introduce a waist circumference of 100 and a gender value of 'F'
		Then return true

USER STORY 4:
As a User
I want to know what is my ideal weight
So that I can go for it.

	- Scenario: Height value lower or equal to zero
		Given an ideal weight calculator
		When I introduce a height value of -1.5
		Then throw error message

	- Scenario: Height value higher than 2.75 m
		Given an ideal weight calculator
		When I introduce a height value of 2.90
		Then throw error message

	- Scenario: Valid height value
		Given an ideal weight calculator
		When I introduce a height value of 1.7
		Then return 65.0


