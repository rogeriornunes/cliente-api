package br.com.softnunes.clienteapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtualizarClienteRequest {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String cnpj;
    private String ie;
    private String telefonePrincipal;
    private String telefoneAlternativo;
    private Boolean status;
    private String tipo;
}
