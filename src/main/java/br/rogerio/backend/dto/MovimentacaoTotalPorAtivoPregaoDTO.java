package br.rogerio.backend.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.rogerio.backend.model.Pregao;

public class MovimentacaoTotalPorAtivoPregaoDTO {
	
	private Pregao pregao;
	private String ativo;	
	private BigDecimal total;
	
	
	public MovimentacaoTotalPorAtivoPregaoDTO(Pregao pregao, String ativo, BigDecimal total) {
		this.pregao = pregao;
		this.ativo = ativo;
		this.total = total;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Pregao getPregao() {
		return pregao;
	}
	public void setPregao(Pregao pregao) {
		this.pregao = pregao;
	}

	

	
}
