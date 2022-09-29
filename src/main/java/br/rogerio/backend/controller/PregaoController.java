package br.rogerio.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.rogerio.backend.model.Pregao;
import br.rogerio.backend.repository.PregaoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pregao")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class PregaoController {

	private final PregaoRepository pregaoRepository;			

	@GetMapping
	public List<Pregao> list(){
		return pregaoRepository.findAll();
	}
	
}
