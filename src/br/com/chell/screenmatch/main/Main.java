package br.com.chell.screenmatch.main;
import br.com.chell.screenmatch.calculo.CalculadoraDeTempo;
import br.com.chell.screenmatch.calculo.FiltroRecomendacao;
import br.com.chell.screenmatch.models.Episodio;
import br.com.chell.screenmatch.models.Filme;
import br.com.chell.screenmatch.models.Serie;

public class Main {

    public static void main(String[] args) {

        //Séries
        Serie serie01 = new Serie("Supernatural", 2005);
        serie01.setQuantidadeEpisodios(327);
        serie01.setQuantidadeTemporadas(15);
        serie01.setAtiva(false);
        serie01.setAnoLancamento(2005);
        serie01.setIncluidoPremium(false);
        serie01.setNomeDiretor("Eric Kripke");
        serie01.setMinutosPorEpisodio(35);
        serie01.avaliaSerie(10);
        serie01.avaliaSerie(9);
        serie01.avaliaSerie(9.33);
        serie01.avaliaSerie(9.87);
        serie01.exibeFichaSerie();

        System.out.println("\n");

        //Filmes
        Filme filme01 = new Filme("Meu Malvado Favorito", 2010);
        filme01.setDuracaoMinutos(95);
        filme01.setNomeDiretor("Chris Renaud");
        filme01.setIncluidoPremium(true);
        filme01.setPossuiSaga(true);
        filme01.avaliaFilme(7);
        filme01.avaliaFilme(9);
        filme01.avaliaFilme(10);
        filme01.avaliaFilme(8.5);
        filme01.exibeFichaFilme();

        System.out.println("\n");

        var filme02 = new Filme("O Estrangeiro", 2017);
        filme02.setDuracaoMinutos(113);
        filme02.setNomeDiretor("Martin Campbell");
        filme02.setIncluidoPremium(true);
        filme02.setPossuiSaga(false);
        filme02.exibeFichaFilme();

        System.out.println("\n");

        //Calculadora
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme01);
        calculadora.inclui(serie01);
        calculadora.exibeFichaLista();

        Episodio ep01 = new Episodio();
        ep01.setTotalVisualizacao(101);
        System.out.println("Avaliação: " + ep01.getClassificacao());

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        System.out.print("Status: ");
        filtroRecomendacao.filtra(ep01);
    }

}
