package br.com.softnunes.clienteapi.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class SalvarClienteResponse {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String cnpj;
    private String ie;
    private String telefonePrincipal;
    private String telefoneAlternativo;
    private Instant dataCadastro;
    private Boolean status;
    private String tipo;
    private Instant ultimaAtualizacao;
}
