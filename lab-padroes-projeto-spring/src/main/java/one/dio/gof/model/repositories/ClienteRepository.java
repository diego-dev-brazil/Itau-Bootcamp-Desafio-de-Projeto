package one.dio.gof.model.repositories;

import org.springframework.data.repository.CrudRepository;

import one.dio.gof.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
}
