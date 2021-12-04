package com.company;
import java.util.Scanner;

public class Main {

    public enum Moedas {
        USD, EUR;
    }

    public static void main(String[] args) {
        /*
        Output
        No terminal no diretório company: java Main.java "José" "B"
        System.out.printf("Hello, %s %s!%n", args[0], args[1]);
        */

        /*
        Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o seu nome: ");
        String name = scanner.next();
        System.out.printf("Olá, %s!", name);
        */

        // Exercício: converter Real em Dólar e em Euro
        System.out.print("Entre com a quantidade de reais: ");
        Scanner scanner = new Scanner(System.in);
        float real = scanner.nextFloat();
        float dolar = 5.65f;
        float euro = 6.39f;
        System.out.printf("Você possui %.2f %s%n", real / dolar, Moedas.USD);
        System.out.printf("Você possui %.2f %s" , real / euro, Moedas.EUR);
    }
}
