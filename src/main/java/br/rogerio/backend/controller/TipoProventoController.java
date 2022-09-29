package br.rogerio.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.rogerio.backend.model.TipoProvento;
import br.rogerio.backend.repository.TipoProventoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tipo_provento")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class TipoProventoController {

	private final TipoProventoRepository tipoProventoRepository;			

	@GetMapping
	public List<TipoProvento> list(){
		return tipoProventoRepository.findAll();
	}
	
}
