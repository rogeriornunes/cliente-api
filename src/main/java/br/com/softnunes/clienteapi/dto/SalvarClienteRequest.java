package br.com.softnunes.clienteapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalvarClienteRequest {
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
