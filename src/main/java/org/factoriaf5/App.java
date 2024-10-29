public class IMCCalculator {
    private static final double BAJO_PESO_MAX = 18.5;
    private static final double PESO_NORMAL_MAX = 24.9;
    private static final double SOBREPESO_MAX = 29.9;

    private final double peso;
    private final double estatura;

    public IMCCalculator(double peso, double estatura) {
        this.peso = peso;
        this.estatura = estatura; 
    }
