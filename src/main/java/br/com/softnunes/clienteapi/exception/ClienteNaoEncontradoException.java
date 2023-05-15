package br.com.softnunes.clienteapi.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
