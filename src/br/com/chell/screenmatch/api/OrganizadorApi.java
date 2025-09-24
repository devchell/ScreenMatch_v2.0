package br.com.chell.screenmatch.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class OrganizadorApi {
    private String filmeLink;
    private String api;

    Scanner s = new Scanner(System.in);

    public String getApi() {
        return api;
    }

    public String getFilmeLink() {
        return filmeLink;
    }

    public void pegaFilmeLink(){
        System.out.print("Digite o nome do filme: ");
        String filmeDigitado = s.nextLine();
        try {
            this.filmeLink = URLEncoder.encode(filmeDigitado, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.filmeLink = filmeDigitado.replace(" ", "+");
        }
    }

    public void pegaApi() {
        System.out.print("Digite sua APIKey do OMDb: ");
        api = s.next();
    }

    public String toStringFilme() {
        return "Filme: " + filmeLink;
    }

    public String toStringApi() {
        return "Api: " + api;
    }

}
