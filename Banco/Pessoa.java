package com.mycompany.banco;

public class Pessoa {
    private String nome;
    private String endereco;
    private String cpf;

    public Pessoa(String nome, String endereco, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        
      
    }
    public String getEndereco() {
    return endereco;
}
    
    public String getCpf() {
    return cpf;
}
        public String getNome() {
    return nome;
}
}
