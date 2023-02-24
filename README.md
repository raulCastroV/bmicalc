![example workflow](https://github.com/jmhorcas/bmicalc/actions/workflows/maven.yml/badge.svg)

# BMI calculator
A biomedical calculator for the body mass index (BMI) and other parameters.

# Test Cases:

BMI Method:
1.Cuando los valores introducidos estan en un rango normal: bmiNormal()
2.Cuando la masa introducida es negativa: bmiNegativeMass()
3.Cuando la altura introducida es negativa: bmiNegativeHeight()
4.Cuando los valores de la masa y la altura son negativos: bmi0MassHeight()
5.Cuando la masa supera el valor maximo previamente establecido: bmiMaxMassHeight()
6.Cuando la altura supera el valor maximo establecido: bmiMaxHeight()

Category Method:
1.Cuando el valor BMI introducido es igual a 0: categoryBMI0()
2.Cuando el valor BMI introducido corresponde al rango "UNDERWEIGHT": categoryUnderweight()
3.Cuando el valor BMI introducido corresponde al rango "NORMAL": categoryNormal()
4.Cuando el valor BMI introducido corresponde al rango "OVERWEIGHT": categoryOverweight()
5.Cuando el valor BMI introducido corresponde al rango "OBESE": categoryObese()

Abdominal Obesitiy Method:
1.Cuando la medida de cintura introducida es menor que el valor minimo establecido: abdominalObesityMinWaist()
2.Cuando la medida de cintura introducida es mayor que el valor minimo establecido: abdominalObesityMaxWaist()
3.Cuando el genero introducido no coincide con los generos permitidos(F o M): abdominalObesityWrongGender()
4.Cuando la medida de cintura introducida no corresponde con obesidad abdominal y el genero es masculino: abdominalObesityFalseMale()
5.Cuando la medida de cintura introducida corresponde con obesidad abdominal y el genero es masculino: abdominalObesityTrueMale()
6.Cuando la medida de cintura introducida no corresponde con obesidad abdominal y el genero es femenino: abdominalObesityFalseFemale()
7.Cuando la medida de cintura introducida corresponde con obesidad abdominal y el genero es femenino: abdominalObesityTrueFemale()
