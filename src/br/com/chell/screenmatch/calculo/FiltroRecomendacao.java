package br.com.chell.screenmatch.calculo;

public class FiltroRecomendacao {
    private String recomendacao;

    public void filtra(Classificacao classificacao){
        if (classificacao.getClassificacao() >= 4) {
            System.out.println("PREFERIDO DO MOMENTO!");
        } else if (classificacao.getClassificacao() >= 2) {
            System.out.println("HYPANDO!");
        } else {
            System.out.println("Coloque na lista para assistir mais tarde");
        }
    }
}
