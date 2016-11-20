package br.com.jprm.contas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jprm.contas.model.Cliente;
import br.com.jprm.contas.repository.ClienteRepository;

@Service
public class ClienteService {

  private static Logger log = LoggerFactory.getLogger(ClienteService.class);

  private ClienteRepository clienteRepository;

  @Autowired
  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public List<Cliente> getClientes() {
    List<Cliente> clientes = clienteRepository.findAll();
    log.info(String.format("Listing %s", clientes.toString()));
    return clientes;
  }

  public Cliente saveCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public void generateMockData() {
    log.info("Genereate Mock Data");
    List<Cliente> clientes = new ArrayList<>();
    clientes.add(new Cliente("Acme"));
    clientes.add(new Cliente("Monster Inc"));
    clientes.add(new Cliente("Oscorp"));
    clientes.add(new Cliente("Wayne Inc"));
    log.info(String.format("Saving %s", clientes.toString()));
    clienteRepository.save(clientes);
  }
}
