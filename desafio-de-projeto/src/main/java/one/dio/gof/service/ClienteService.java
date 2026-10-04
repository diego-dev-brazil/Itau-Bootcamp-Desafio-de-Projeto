package one.dio.gof.service;

import one.dio.gof.dto.ClienteDTO;
import one.dio.gof.model.Cliente;
import one.dio.gof.model.NotificacaoEnum;

public interface ClienteService {
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	ClienteDTO inserir (Cliente cliente, NotificacaoEnum canal);
	
	void atualizar (Long id, Cliente cliente);
	void deletar (Long id);
}
