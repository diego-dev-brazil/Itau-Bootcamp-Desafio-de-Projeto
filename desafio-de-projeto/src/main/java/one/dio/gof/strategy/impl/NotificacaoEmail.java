package one.dio.gof.strategy.impl;

import org.springframework.stereotype.Component;

import one.dio.gof.model.Cliente;
import one.dio.gof.model.NotificacaoEnum;
import one.dio.gof.strategy.NotificacaoStrategy;

@Component
public class NotificacaoEmail implements NotificacaoStrategy{

	@Override
	public NotificacaoEnum getTipo() {
		return NotificacaoEnum.EMAIL;
	}

	@Override
	public String enviar(Cliente cliente, String msg) {
		StringBuilder sb = new StringBuilder();
				sb.append("==== EMAIL MESSAGE ====\n")
					.append("Cliente: " + cliente.getNome())
					.append("\nEndereco: " + cliente.getEndereco().getLogradouro())
					.append("\nCEP: " + cliente.getEndereco().getCep())
					.append("\nMessage: " + msg);
		return sb.toString();
	}

}
