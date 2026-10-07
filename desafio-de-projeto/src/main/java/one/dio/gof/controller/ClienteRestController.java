package one.dio.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import one.dio.gof.dto.ClienteDTO;
import one.dio.gof.model.Cliente;
import one.dio.gof.model.NotificacaoEnum;
import one.dio.gof.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;

	ClienteRestController (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ResponseEntity <Iterable<Cliente>> buscarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Cliente> buscarPorId (@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> inserir (@RequestBody Cliente cliente, @RequestParam NotificacaoEnum notificacao) {
		ClienteDTO resposta = clienteService.inserir(cliente, notificacao);
				
		return ResponseEntity.ok(resposta);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<ClienteDTO> atualizar (@PathVariable Long id, @RequestBody Cliente cliente, @RequestParam NotificacaoEnum notificacao) {
		ClienteDTO resposta = clienteService.atualizar(id,cliente, notificacao);
		return ResponseEntity.ok(resposta);
	}
	 
	@DeleteMapping ("/{id}")
	public ResponseEntity<ClienteDTO> deletar (@PathVariable Long id, @RequestParam NotificacaoEnum notificacao) {
		ClienteDTO resposta = clienteService.deletar(id, notificacao);
		return ResponseEntity.ok(resposta);
	}
}
