package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Informe o turno em que você estuda M[MATUTINO], V[VESPERTINO] ou N[NOTURNO]: ");
        String turno = scanner.next();

        if(turno.equals("M")) {
            System.out.println("Bom dia!");
        } else if(turno.equals("V")) {
            System.out.println("Boa tarde!");
        } else if(turno.equals("N")) {
            System.out.println("Boa noite!");
        } else {
            System.out.println("Valor inválido");
        }
    }
}
