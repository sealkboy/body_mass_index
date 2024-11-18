package org.factoriaf5.imc;

public class IMCCalculator {

    private double peso;
    private double estatura;

    public IMCCalculator(double peso, double estatura) {
        this.peso = peso;
        this.estatura = estatura;
    }

    public double calcularIMC(){
        return peso / (estatura * estatura);
    }

    public static String obtenerCategoria(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }

    public String obtenerResultado() {
        double imc = calcularIMC();
        String categoria = obtenerCategoria(imc);
        return String.format("IMC: %.2f\nCategoría: %s", imc, categoria);
    }

    public void mostrarIMC() {
        System.out.println(obtenerResultado());
    }

}
