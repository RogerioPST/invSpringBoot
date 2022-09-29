package br.rogerio.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.rogerio.backend.model.AtivoUsuario;
import br.rogerio.backend.repository.AtivoUsuarioRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ativo_usuario")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class AtivoUsuarioController {

	private final AtivoUsuarioRepository ativoUsuarioRepository;			

	@GetMapping
	public List<AtivoUsuario> list(){
		return ativoUsuarioRepository.findAll();
	}
	
}
