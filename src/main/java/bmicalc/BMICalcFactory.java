package bmicalc;

public class BMICalcFactory {
    public static IMCHospital getCalculator(String region) {
        switch (region.toLowerCase()) {
            case "europe":
                return new EuropeanCalc();
            case "america":
                return new AmericanCalc();
            default:
                throw new IllegalArgumentException("Unsupported region");
        }
    }
}
