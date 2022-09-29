package br.rogerio.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.rogerio.backend.model.TipoMovimentacao;
import br.rogerio.backend.repository.TipoMovimentacaoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tipo_movimentacao")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class TipoMovimentacaoController {

	private final TipoMovimentacaoRepository tipoMovimentacaoRepository;			

	@GetMapping
	public List<TipoMovimentacao> list(){
		return tipoMovimentacaoRepository.findAll();
	}
	
}
