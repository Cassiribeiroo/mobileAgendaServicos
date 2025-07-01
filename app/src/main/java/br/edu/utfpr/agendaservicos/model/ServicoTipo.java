package br.edu.utfpr.agendaservicos.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ServicoTipo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String unidade; // ex: "m2", "unidade"
    private double valor;   // valor por unidade

    // Construtor padrão vazio (obrigatório para o Room)
    public ServicoTipo() {}

    // Construtor completo (opcional, útil para testes ou criação rápida)
    public ServicoTipo(String nome, String unidade, double valor) {
        this.nome = nome;
        this.unidade = unidade;
        this.valor = valor;
    }

    // Getters e Setters obrigatórios
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
