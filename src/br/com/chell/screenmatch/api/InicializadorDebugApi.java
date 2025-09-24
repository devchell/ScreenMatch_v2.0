package br.com.chell.screenmatch.api;

import java.io.IOException;
import java.util.Scanner;

public class InicializadorDebugApi {
    private boolean ativo;

    OrganizadorApi filmeLink = new OrganizadorApi();
    OrganizadorApi apiLink = new OrganizadorApi();

    public void inicializador() throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.print("Ativar o modo debug? (1 = Sim | 0 = Não): ");
        int i = s.nextInt();

        if (i == 1) {
            ativo = true;
            filmeLink.pegaFilmeLink();
            System.out.println(filmeLink.toStringFilme());
            apiLink.pegaApi();
            System.out.println(apiLink.toStringApi());
        } else {
            filmeLink.pegaFilmeLink();
            apiLink.pegaApi();
        }
        OrganizadorHttp apiFicha = new OrganizadorHttp(filmeLink.getFilmeLink(), apiLink.getApi());
        apiFicha.exibiFichaApi();
    }
}
