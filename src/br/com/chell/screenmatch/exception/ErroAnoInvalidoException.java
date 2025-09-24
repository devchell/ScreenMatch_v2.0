package br.com.chell.screenmatch.exception;

public class ErroAnoInvalidoException extends RuntimeException {
    private String mensagem;

    public ErroAnoInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
