package com.mycompany.banco;

public class Conta {
    private Pessoa titular;
    private String numero;
    private String agencia;
    private String banco;
    private double saldo = 0;

    public Conta(Pessoa titular, String numero, String agencia, String banco) {
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.banco = banco;
    }

    public boolean sacar(double valor) {
        if (valor > getSaldo()) {
            System.out.println("Valor acima do Saldo");
            return false;
        } else {
            setSaldo(getSaldo() - valor);
            return true;
        }
    }

    public boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("Valor inválido para Depósito");
            return false;
        } else {
            setSaldo(getSaldo() + valor);
            return true;
        }
    }

    public boolean transferirDinheiro(double valor, Conta contaDestino) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            System.out.println("Transferência feita com sucesso!");
            return true;
        } else {
            System.out.println("Erro na Transferência!");
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }


    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public Pessoa getTitular() {
        return titular;
    }


    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
}
