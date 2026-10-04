package one.dio.gof.model.repositories;

import org.springframework.data.repository.CrudRepository;

import one.dio.gof.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String>{
	
}
