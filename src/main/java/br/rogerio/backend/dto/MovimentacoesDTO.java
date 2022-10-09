package br.rogerio.backend.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacoesDTO {
	
	private Date dia;

	private List<ResumoPorAtivoDTO> resumosPorAtivo;

	public MovimentacoesDTO(Date dia, List<ResumoPorAtivoDTO> resumosPorAtivo) {
		this.dia = dia;
		this.resumosPorAtivo = resumosPorAtivo;
	}

	
	
}
