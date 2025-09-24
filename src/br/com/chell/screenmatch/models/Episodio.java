package br.com.chell.screenmatch.models;

import br.com.chell.screenmatch.calculo.Classificacao;

public class Episodio implements Classificacao {
    private int ep;
    private String nome;
    private Serie serie;
    private int totalVisualizacao;

    //Getters & Setters
    public void setTotalVisualizacao(int totalVisualizacao) {
        this.totalVisualizacao = totalVisualizacao;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        if (totalVisualizacao >= 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
