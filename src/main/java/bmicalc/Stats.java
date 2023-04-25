package bmicalc;

public class Stats implements IMCStats {
	
	private BMICalcImpl calculadora;
	private double alturaTotal, alturaMedia;
	private double pesoTotal, pesoMedio;
	private double imcTotal, imcMedio;
	private int numPacientes;

    public Stats(BMICalcImpl calculadora) {
        this.calculadora = calculadora;
        this.calculadora.addObserver(this);
    }

	@Override
	public void update() {
        double altura = this.calculadora.getHeight();
        double peso = this.calculadora.getMass();
        double imc = this.calculadora.getBMI();

        alturaTotal += altura;
        pesoTotal += peso;
        imcTotal += imc;
        numPacientes++;


		
	}

	@Override
	public double alturaMedia() {
        alturaMedia = alturaTotal / numPacientes;
		return alturaMedia;
	}

	@Override
	public double pesoMedio() {
        pesoMedio = pesoTotal / numPacientes;
		return pesoMedio;
	}

	@Override
	public double imcMedio() {
        imcMedio = imcTotal / numPacientes;
		return imcMedio;
	}

	@Override
	public int numPacientes() {
		return numPacientes;
	}

}
