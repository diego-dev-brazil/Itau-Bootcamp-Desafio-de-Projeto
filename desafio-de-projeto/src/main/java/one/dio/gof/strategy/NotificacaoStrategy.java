package one.dio.gof.strategy;

import one.dio.gof.model.Cliente;
import one.dio.gof.model.NotificacaoEnum;

public interface NotificacaoStrategy {
	NotificacaoEnum getTipo();
	
	String enviar (Cliente cliente, String msg);
}
