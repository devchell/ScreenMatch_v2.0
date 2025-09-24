package br.com.chell.screenmatch.models;

import java.util.Locale;

public class Serie extends Titulo {
    private int quantidadeEpisodios;
    private int quantidadeTemporadas;
    private double minutosPorEpisodio;
    private boolean ativa;

    public Serie(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

    public void exibeFichaSerie(){
        System.out.println("Nome da Série: " + getNome());
        System.out.println("Ano de Lançamento: " + getAnoLancamento());
        System.out.println("Quantidade de Episódios: " + getQuantidadeEpisodios() + " episódios");
        System.out.println("Quantidade de Temporadas: " + getQuantidadeTemporadas() + " temporadas");

        //Duração completa
        if (pegaDuracaoMinutos() < 60) {
            System.out.println("Duração completa: " + pegaDuracaoMinutos() + " minutos.");
        } else if (pegaDuracaoMinutos() >= 60 && pegaDuracaoMinutos() < 1440) {
            if (pegaMediaTemporadasHoras() == 1){
                System.out.println("Duração completa: " + pegaDuracaoMinutos() + " minutos | " + pegaMediaTemporadasHoras() +
                        " hora.");
            } else {
                System.out.println("Duração completa: " + pegaDuracaoMinutos() + " minutos | " + pegaMediaTemporadasHoras() +
                        " horas.");
            }

        } else {
            if (pegaDuracaoDias() == 1) {
                System.out.println("Duração completa: " + pegaDuracaoMinutos() + " minutos | " + pegaDuracaoHoras() +
                        " horas | " + pegaDuracaoDias() + " dia.");
            } else {
                System.out.println("Duração completa: " + pegaDuracaoMinutos() + " minutos | " + pegaDuracaoHoras() +
                        " horas | " + pegaDuracaoDias() + " dias.");
            }

        }

        //Média da duração
        if (pegaMediaTemporadasMinutos() < 60) {
            System.out.println("Média por temporada: " + pegaMediaTemporadasMinutos() + " minutos.");
        } else if (pegaMediaTemporadasMinutos() >= 60 && pegaMediaTemporadasMinutos() < 1440) {
            if (pegaMediaTemporadasHoras() == 1){
                System.out.println("Média por temporada: " + pegaMediaTemporadasMinutos() + " minutos | " + pegaMediaTemporadasHoras() +
                        " hora.");
            } else {
                System.out.println("Média por temporada: " + pegaMediaTemporadasMinutos() + " minutos | " + pegaMediaTemporadasHoras() +
                        " horas.");
            }

        } else {
            if (pegaMediaTemporadaDias() == 1){
                System.out.println("Média por temporada: " + pegaMediaTemporadasMinutos() + " minutos | " + pegaMediaTemporadasHoras() +
                        " horas | " + pegaMediaTemporadaDias() + " dia.");
            } else {
                System.out.println("Média por temporada: " + pegaMediaTemporadasMinutos() + " minutos | " + pegaMediaTemporadasHoras() +
                        " horas | " + pegaMediaTemporadaDias() + " dias.");
            }

        }
        System.out.println("Diretor: " + getNomeDiretor());
        System.out.println("Média das avaliações: " + String.format(Locale.US, "%.2f", obterMediaAvaliacao()));
        System.out.println("Quantidade de avaliação: " + getQuantidadeAvaliacao());
        if (isIncluidoPremium()) {
            System.out.println("Esta série faz parte do plano: Premium.");
        } else {
            System.out.println("Esta séria faz parte do plano: Gratuito.");
        }
    }

    //Getters
    public int getQuantidadeEpisodios() {
        return quantidadeEpisodios;
    }

    public int getQuantidadeTemporadas() {
        return quantidadeTemporadas;
    }

    public double getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public double retornaMediaEp;
        ;

    //Setters
    public void setQuantidadeEpisodios(int quantidadeEpisodios) {
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    public void setQuantidadeTemporadas(int quantidadeTemporadas) {
        this.quantidadeTemporadas = quantidadeTemporadas;
    }

    public void setMinutosPorEpisodio(double minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public int pegaDuracaoMinutos() {
        return (int) (quantidadeTemporadas * quantidadeEpisodios * minutosPorEpisodio);
    }

    public int pegaDuracaoHoras() {
        return pegaDuracaoMinutos() / 60;
    }

    public int pegaDuracaoDias() {
        return pegaDuracaoHoras() / 24;
    }

    public int pegaMediaTemporadasMinutos() {
        return pegaDuracaoMinutos() / getQuantidadeTemporadas();
    }

    public int pegaMediaTemporadasHoras() {
        return pegaMediaTemporadasMinutos() / 60;
    }

    public int pegaMediaTemporadaDias() {
        return pegaMediaTemporadasHoras() / 24;
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome() + " (" + this.getAnoLancamento() + ")";
    }
}
