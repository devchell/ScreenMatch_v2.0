package br.com.chell.screenmatch.models;

import br.com.chell.screenmatch.exception.ErroAnoInvalidoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoLancamento;
    private String anoLancamentoTexto;
    private boolean incluidoPremium;
    private double somaDasAvaliacoes;
    private int quantidadeAvaliacao;
    private int duracaoMinutos;
    private String duracaoMinutosTexto;
    private String nomeDiretor;

    public Titulo(TituloOmdb meuTituloOmdb) {
        String ano = meuTituloOmdb.year();
        String runtime = meuTituloOmdb.runtime();

        this.nome = meuTituloOmdb.title();

        if (ano != null && ano.length() >= 4 && ano.matches("\\d{4}.*")) {
            this.anoLancamento = Integer.parseInt(ano.substring(0, 4));
            this.anoLancamentoTexto = String.valueOf(this.anoLancamento);
        } else {
            this.anoLancamento = 0;
            this.anoLancamentoTexto = "Sem registro";
        }

        if (runtime != null && runtime.matches("\\d+.*")) {
            this.duracaoMinutos = Integer.parseInt(runtime.split(" ")[0]);
            this.duracaoMinutosTexto = String.valueOf(this.duracaoMinutos);
        } else {
            this.duracaoMinutos = 0;
            this.duracaoMinutosTexto = "Sem registro";
        }
    }


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

    public String getAnoLancamentoTexto() {
        return anoLancamentoTexto;
    }

    public String getDuracaoMinutosTexto() {
        return duracaoMinutosTexto;
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

    @Override
    public String toString() {
        return "Título: " + nome +
                " | Ano de lançamento: " + (anoLancamentoTexto.equals("Sem registro") ? "Sem registro" : anoLancamento) +
                " | Duração: " + (duracaoMinutosTexto.equals("Sem registro") ? "Sem registro" : duracaoMinutosTexto + " min");
    }
}
