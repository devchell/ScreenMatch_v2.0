package br.com.chell.screenmatch.main;

import br.com.chell.screenmatch.models.Filme;
import br.com.chell.screenmatch.models.Serie;
import br.com.chell.screenmatch.models.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainLista {
    public static void main(String[] args) {
        Filme filme01 = new Filme("Meu Malvado Favorito", 2010);
        filme01.avaliaFilme(8);
        var filme02 = new Filme("O Estrangeiro", 2017);
        filme02.avaliaFilme(8.5);
        Serie serie01 = new Serie("Supernatural", 2005);
        serie01.avaliaSerie(9);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme01);
        lista.add(filme02);
        lista.add(serie01);
        for (Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaArtista = new ArrayList<>();
        buscaArtista.add("Adam Sandler");
        buscaArtista.add("Will Smith");
        buscaArtista.add("Jackie Chan");

        System.out.println(buscaArtista);
        //Ordem Alfabética
        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);
        //Ordenas por títulos
        Collections.sort(lista);
        System.out.println(lista);
        //Ordenar por anos
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println(lista);

    }
}
