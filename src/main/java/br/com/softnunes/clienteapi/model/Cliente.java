package br.com.softnunes.clienteapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
