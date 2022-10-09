package br.rogerio.backend.dto;

import java.util.Date;
import java.util.List;

import br.rogerio.backend.model.Pregao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacoesPregaoDTO {
	
	private Pregao pregao;

	private List<ResumoPorAtivoPregaoDTO> resumosPorAtivo;

	public MovimentacoesPregaoDTO(Pregao pregao, List<ResumoPorAtivoPregaoDTO> resumosPorAtivo) {
		this.pregao = pregao;
		this.resumosPorAtivo = resumosPorAtivo;
	}

	
	
}
