package one.dio.gof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.dio.gof.dto.ClienteDTO;
import one.dio.gof.model.Cliente;
import one.dio.gof.model.Endereco;
import one.dio.gof.model.NotificacaoEnum;
import one.dio.gof.model.repositories.ClienteRepository;
import one.dio.gof.model.repositories.EnderecoRepository;
import one.dio.gof.service.ClienteService;
import one.dio.gof.service.ViaCepService;
import one.dio.gof.strategy.NotificacaoStrategy;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viacep;
	
	@Autowired
	List <NotificacaoStrategy> notificacoes;  

	@Override
	public Iterable<Cliente> buscarTodos() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public ClienteDTO inserir(Cliente cliente, NotificacaoEnum canal) {
		
		salvarClienteComCep(cliente);
		NotificacaoStrategy notificacao = notificacoes.stream().filter(s -> s.getTipo() == canal ).findFirst().orElseThrow();
		
		String statusEnvio = notificacao.enviar(cliente, "Ciente inserido com sucesso!");
		return new ClienteDTO (cliente, statusEnvio);
	}

	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viacep.consultarCep(cep);
			
			if (novoEndereco == null || novoEndereco.getCep() == null) {
	            throw new IllegalArgumentException("CEP não encontrado: " + cep);
	        }
			
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});	
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteUP = clienteRepository.findById(id);
		if (clienteUP.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

}
