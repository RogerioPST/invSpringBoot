package br.rogerio.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.rogerio.backend.model.Ativo;
import br.rogerio.backend.repository.AtivoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ativo")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class AtivoController {

	private final AtivoRepository ativoRepository;			

	@GetMapping
	public List<Ativo> list(){
		return ativoRepository.findAll();
	}
	
}
