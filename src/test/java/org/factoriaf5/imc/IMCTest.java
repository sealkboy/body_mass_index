package org.factoriaf5.imc;
import static org.junit.Assert.*;

import org.junit.Test;


public class IMCTest {


    @Test
    public void testCalcularIMC() {
        IMCCalculator persona1 = new IMCCalculator(70, 1.75);
        assertEquals(22.86, persona1.calcularIMC(), 0.01);
        
        IMCCalculator persona2 = new IMCCalculator(50, 1.60);
        assertEquals(19.53, persona2.calcularIMC(), 0.01);
        
        IMCCalculator persona3 = new IMCCalculator(85, 1.80);
        assertEquals(26.23, persona3.calcularIMC(), 0.01);
    }

    @Test
    public void testObtenerCategoria() {

        IMCCalculator persona1 = new IMCCalculator(70, 1.75);
        double imc1 = persona1.calcularIMC();
        assertEquals("Peso normal", IMCCalculator.obtenerCategoria(imc1));

        IMCCalculator persona2 = new IMCCalculator(50, 1.75);
        double imc2 = persona2.calcularIMC();
        assertEquals("Bajo peso", IMCCalculator.obtenerCategoria(imc2));

        IMCCalculator persona3 = new IMCCalculator(85, 1.75);
        double imc3 = persona3.calcularIMC();
        assertEquals("Sobrepeso", IMCCalculator.obtenerCategoria(imc3));

        IMCCalculator persona4 = new IMCCalculator(100, 1.75);
        double imc4 = persona4.calcularIMC();
        assertEquals("Obesidad", IMCCalculator.obtenerCategoria(imc4));
    }

    @Test
    public void testObtenerResultado() {

        IMCCalculator persona1 = new IMCCalculator(70, 1.75);
        String resultado1 = persona1.obtenerResultado();
        assertTrue(resultado1.contains("IMC: 22.86"));
        assertTrue(resultado1.contains("Categoría: Peso normal"));

        IMCCalculator persona2 = new IMCCalculator(50, 1.75);
        String resultado2 = persona2.obtenerResultado();
        assertTrue(resultado2.contains("IMC: 16.33"));
        assertTrue(resultado2.contains("Categoría: Bajo peso"));
    }

    @Test
    public void testMostrarIMC() {

        IMCCalculator persona1 = new IMCCalculator(70, 1.75);
        String expectedOutput = "IMC: 22,86\nCategoría: Peso normal\n";
        assertOutput(persona1, expectedOutput);
    }

    private void assertOutput(IMCCalculator persona, String expectedOutput) {

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream printStream = new java.io.PrintStream(baos);
        System.setOut(printStream);

        persona.mostrarIMC();

        assertEquals(expectedOutput, baos.toString());
    }
}
