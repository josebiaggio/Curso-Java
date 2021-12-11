package com.company;

public class Main {

    public static void main(String[] args) {
        Conta conta1 = new Conta("José", 123);
        conta1.setSaldo(100.0);
        System.out.println(conta1);
        conta1.sacar(100.0);
        System.out.println(conta1);
    }
}
