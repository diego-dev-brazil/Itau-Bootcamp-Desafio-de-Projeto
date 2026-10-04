package one.dio.gof.strategy.impl;

import org.springframework.stereotype.Component;

import one.dio.gof.model.Cliente;
import one.dio.gof.model.NotificacaoEnum;
import one.dio.gof.strategy.NotificacaoStrategy;

@Component
public class NotificacaoSms implements NotificacaoStrategy{

	@Override
	public NotificacaoEnum getTipo() {
		return NotificacaoEnum.SMS;
	}

	@Override
	public String enviar(Cliente cliente, String msg) {
		StringBuilder sb = new StringBuilder();
				sb.append("==== SMS MESSAGE ====")
					.append("Cliente: " + cliente.getNome())
					.append("Endereco: " + cliente.getEndereco().getLogradouro())
					.append("CEP: " + cliente.getEndereco().getCep())
					.append("Message: " + msg);
		return sb.toString();
	}

}
