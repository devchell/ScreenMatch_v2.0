package br.com.chell.screenmatch.models;

import br.com.chell.screenmatch.calculo.Classificacao;

import java.util.Locale;

public class Filme extends Titulo implements Classificacao {

    private boolean possuiSaga;

    public Filme(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

//    public Filme(String nome) {
//        this.setNome(nome);
//    }

//    public Filme() { (Pode utilizar sem passar um parâmetro)
//    }

    public void exibeFichaFilme(){
        System.out.println("Nome do filme: " + getNome());
        System.out.println("Ano de lançamento: " + getAnoLancamento());
        if (isPossuiSaga()) {
            System.out.println("Este filme contém uma Saga.");
        } else {
            System.out.println("Este filme não contém uma Saga.");
        }
        System.out.println("Duração: " + pegaDuracaoMinutos() + " minutos");
        System.out.println("Diretor: " + getNomeDiretor());
        System.out.println("Média das avaliações: " + String.format(Locale.US, "%.2f", obterMediaAvaliacao()));
        System.out.println("Quantidade de avaliação: " + getQuantidadeAvaliacao());
        if (isIncluidoPremium()) {
            System.out.println("Este filme faz parte do plano: Premium.");
        } else {
            System.out.println("Este filme faz parte do plano: Gratuito.");
        }
    }



    public boolean isPossuiSaga() {
        return possuiSaga;
    }

    public void setPossuiSaga(boolean possuiSaga) {
        this.possuiSaga = possuiSaga;
    }

    @Override
    public int getClassificacao() {
        return (int) obterMediaAvaliacao()/2;
    }


    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoLancamento() + ")";
    }
}
