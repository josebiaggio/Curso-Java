package com.company;

public class Conta {
    private String nomeDoCliente;
    private long numero;
    private double saldo;

    public Conta(String nomeDoCliente, long numero) {
        this.nomeDoCliente = nomeDoCliente;
        this.numero = numero;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public long getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo > 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo informado inválido");
        }
    }

    public boolean sacar(double valor) {
        boolean suf = isSaldoSuficiente(valor);
        if(valor <= 0 && suf) {
            System.out.println("Valor inválido");
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    private boolean isSaldoSuficiente(double valor) {
        if(this.saldo >= valor) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nomeDoCliente='" + nomeDoCliente + '\'' +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
