package one.dio.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.dio.gof.model.EmpresaDTO;

@FeignClient(name = "brasilapi-cnpj", url = "https://brasilapi.com.br/api/cnpj/v1")
public interface BrasilApiService {
	@GetMapping ("/{cnpj}")
	EmpresaDTO consultarCnpj(@PathVariable("cnpj") String cnpj);
}
