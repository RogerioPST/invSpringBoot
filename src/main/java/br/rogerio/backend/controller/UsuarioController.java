package br.rogerio.backend.controller;

import java.util.List;






import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rogerio.backend.model.Usuario;
import br.rogerio.backend.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;			

	@GetMapping
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}
	
}
