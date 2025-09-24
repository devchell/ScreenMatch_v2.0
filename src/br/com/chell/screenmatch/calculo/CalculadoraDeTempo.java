package br.com.chell.screenmatch.calculo;

import br.com.chell.screenmatch.models.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotalMinutos;

//    public void inclui(Filme f) {
//        tempoTotalMinutos += f.pegaDuracaoMinutos();
//    }
//    public void inclui(Serie s) {
//        tempoTotalMinutos += s.pegaDuracaoMinutos();
//    }

    public void inclui(Titulo titulo) {
        tempoTotalMinutos += titulo.pegaDuracaoMinutos();
    }

    public int transformaMinutosHoras() {
        return tempoTotalMinutos/60;
    }

    public int transformaHorasDias() {
        return transformaMinutosHoras()/24;
    }

    public void exibeFichaLista() {
        if (tempoTotalMinutos < 60) {
            System.out.println("Sua lista tem um total de: " + tempoTotalMinutos + " minutos.");
        } if (tempoTotalMinutos >= 60 && tempoTotalMinutos < 1440) {
            if (transformaMinutosHoras() == 1) {
                System.out.println("Sua lista tem um total de: " + tempoTotalMinutos + " minutos | " + transformaMinutosHoras() + " hora.");
            } else {
                System.out.println("Sua lista tem um total de: " + tempoTotalMinutos + " minutos | " + transformaMinutosHoras() + " horas.");
            }
        } else {
            if (transformaHorasDias() == 1) {
                System.out.println("Sua lista tem um total de: " + tempoTotalMinutos + " minutos | " + transformaMinutosHoras() + " horas | "
                        + transformaHorasDias() + " dia.");
            } else {
                System.out.println("Sua lista tem um total de: " + tempoTotalMinutos + " minutos | " + transformaMinutosHoras() + " horas | "
                        + transformaHorasDias() + " dias.");
            }
        }

    }
}
