package br.com.softnunes.clienteapi.service;


import br.com.softnunes.clienteapi.dto.AtualizarClienteRequest;
import br.com.softnunes.clienteapi.dto.SalvarClienteRequest;
import br.com.softnunes.clienteapi.exception.ClienteCadastradoException;
import br.com.softnunes.clienteapi.exception.ClienteNaoEncontradoException;
import br.com.softnunes.clienteapi.model.Cliente;
import br.com.softnunes.clienteapi.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente getClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado " + id));
    }

    public Cliente salvar(SalvarClienteRequest clienteRequest) {
        var data = Instant.now();
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        cliente.setDataCadastro(data);
        cliente.setUltimaAtualizacao(data);
        validarClienteParaSalvar(cliente);
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente atualizar(AtualizarClienteRequest atualizarClienteRequest) {
        validarClienteParaAtualizar(atualizarClienteRequest);
        var cliente = getClientePorId(atualizarClienteRequest.getId());
        BeanUtils.copyProperties(atualizarClienteRequest, cliente);
        cliente.setUltimaAtualizacao(Instant.now());
        clienteRepository.save(cliente);
        return new Cliente();
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void validarClienteParaSalvar(Cliente cliente) {
        var cpf = cliente.getCpf();
        var cnpj = cliente.getCnpj();

        if (!cpf.isEmpty()) {
            if (clienteRepository.findClienteByCpf(cpf).isPresent()) {
                throw new ClienteCadastradoException("Cliente já cadastrado");
            }
        } else if (!cnpj.isEmpty()) {
            if (clienteRepository.findClienteByCnpj(cnpj).isPresent()) {
                throw new ClienteCadastradoException("Cliente já cadastrado");
            }
        }
    }

    private void validarClienteParaAtualizar(AtualizarClienteRequest cliente) {
        List<Cliente> clientes = clienteRepository.findAll();
        List<Cliente> clientesFiltrados = filtrarClientesCadastrados(cliente, clientes);
        if (isCadastrado(cliente, clientesFiltrados)) {
            throw new ClienteCadastradoException("Dados de informado CPF/CNPJ, já cadastrado em outro cliente!");
        }
    }

    private boolean isCadastrado(AtualizarClienteRequest cliente, List<Cliente> clientesFiltrados) {
        boolean isCadastrado = clientesFiltrados.stream().anyMatch(clienteCadastrado -> {
            return (!cliente.getCpf().isEmpty()) && cliente.getCpf().equals(clienteCadastrado.getCpf()) ||
                   (!cliente.getCnpj().isEmpty()) && cliente.getCnpj().equals(clienteCadastrado.getCnpj());
        });
        return isCadastrado;
    }

    private List<Cliente> filtrarClientesCadastrados(AtualizarClienteRequest cliente, List<Cliente> clientes) {
        List<Cliente> clientesFiltrados;
        clientesFiltrados = clientes.stream().filter(filterClienteCadastrado ->
                !cliente.getId().equals(filterClienteCadastrado.getId())).collect(Collectors.toList());
        return clientesFiltrados;
    }
}
