package br.com.softnunes.clienteapi.controller;


import br.com.softnunes.clienteapi.dto.AtualizarClienteRequest;
import br.com.softnunes.clienteapi.dto.SalvarClienteRequest;
import br.com.softnunes.clienteapi.dto.SalvarClienteResponse;
import br.com.softnunes.clienteapi.model.Cliente;
import br.com.softnunes.clienteapi.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ObjectMapper mapper = new ObjectMapper();

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> listar() {
        return new ResponseEntity<>(clienteService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clienteService.getClientePorId(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SalvarClienteResponse> salvar(@RequestParam String clienteData) throws IOException {
        final var incluirClienteRequest = mapper.readValue(clienteData, SalvarClienteRequest.class);
        var cliente = clienteService.salvar(incluirClienteRequest);
        var clienteResponse = new SalvarClienteResponse();
        BeanUtils.copyProperties(cliente, clienteResponse);
        return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Cliente> atualizar(@RequestParam String clienteData) throws IOException {
        final var atualizarClienteRequest = mapper.readValue(clienteData, AtualizarClienteRequest.class);
        var cliente = clienteService.atualizar(atualizarClienteRequest);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        clienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
