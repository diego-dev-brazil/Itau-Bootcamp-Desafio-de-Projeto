package one.dio.gof.dto;

import one.dio.gof.model.Cliente;
import one.dio.gof.strategy.NotificacaoStrategy;

public record ClienteDTO(Cliente cliente, String notificacao) {

}
