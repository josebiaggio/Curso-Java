package com.company;

public class Main {

    public static void main(String[] args) {
        CalcularArea calcularArea = new CalcularArea();

        // Lados do quadrado: a e b
        int x = 10, y = x;
        int areaDoQuadrado = calcularArea.quadrado(x, y);
        System.out.printf("A área do quadrado é %dm2\n", areaDoQuadrado);

        // Base(b) e altura(h) de um triângulo
        int b = 12, h = 8;

        int areaDoTriangulo = calcularArea.triangulo(b, h);
        System.out.printf("A área do triângulo é %dm2", areaDoTriangulo);
    }
}
