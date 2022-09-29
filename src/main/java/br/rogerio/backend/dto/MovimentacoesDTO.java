package br.rogerio.backend.dto;

import java.util.Date;
import java.util.List;

public class MovimentacoesDTO {
	
	private Date dia;

	private List<ResumoPorAtivoDTO> resumosPorAtivo;

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public List<ResumoPorAtivoDTO> getResumosPorAtivo() {
		return resumosPorAtivo;
	}

	public void setResumosPorAtivo(List<ResumoPorAtivoDTO> resumosPorAtivo) {
		this.resumosPorAtivo = resumosPorAtivo;
	}

	public MovimentacoesDTO(Date dia, List<ResumoPorAtivoDTO> resumosPorAtivo) {
		this.dia = dia;
		this.resumosPorAtivo = resumosPorAtivo;
	}

	

	
}
