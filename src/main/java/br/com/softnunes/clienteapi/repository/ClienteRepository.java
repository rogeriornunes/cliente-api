package br.com.softnunes.clienteapi.repository;


import br.com.softnunes.clienteapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAll();

    @Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
    Optional<Cliente> findClienteByCpf(String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.cnpj = ?1")
    Optional<Cliente> findClienteByCnpj(String cnpj);
}
