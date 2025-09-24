package br.com.chell.screenmatch.models;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoLancamento;
    private boolean incluidoPremium;
    private double somaDasAvaliacoes;
    private int quantidadeAvaliacao;
    private int duracaoMinutos;
    private String nomeDiretor;

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public void avaliaFilme(double nota) {
        somaDasAvaliacoes += nota;
        quantidadeAvaliacao++;
    }

    public void avaliaSerie(double nota){
        somaDasAvaliacoes += nota;
        quantidadeAvaliacao++;
    }

    public double obterMediaAvaliacao(){
        return somaDasAvaliacoes/quantidadeAvaliacao;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluidoPremium() {
        return incluidoPremium;
    }

    public int pegaDuracaoMinutos() {
        return duracaoMinutos;
    }

    public int getQuantidadeAvaliacao() {
        return quantidadeAvaliacao;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setIncluidoPremium(boolean incluidoPremium) {
        this.incluidoPremium = incluidoPremium;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
