package br.com.jprm.contas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.jprm.contas.model.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

  List<Cliente> findAll();

  Optional<Cliente> findById(Long id);

  List<Cliente> findByIdIn(List<Long> ids);

  List<Cliente> findByNome(String nome);
}
