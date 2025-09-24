package br.com.chell.screenmatch.main;

import br.com.chell.screenmatch.api.InicializadorDebugApi;
import br.com.chell.screenmatch.api.OrganizadorApi;
import br.com.chell.screenmatch.api.OrganizadorHttp;

import java.io.IOException;

public class MainBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        OrganizadorApi filmeLink = new OrganizadorApi();
        OrganizadorApi api = new OrganizadorApi();

        InicializadorDebugApi iniciar = new InicializadorDebugApi();

        iniciar.inicializador();


    }
}
