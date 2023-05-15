package br.com.softnunes.clienteapi.exception;

public class ClienteCadastradoException extends RuntimeException {
    public ClienteCadastradoException(String mensagem) {
        super(mensagem);
    }
}
