package br.rogerio.backend.dto;

import java.math.BigDecimal;

import br.rogerio.backend.model.Pregao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoPorAtivoDTO {	

	private String diaAtivo;
	private Pregao pregao;
	private String operacao;
	private String ativo;	

	private int quantidade;
	
	private BigDecimal preco;
	
	private BigDecimal valorOperacao;

	public MovimentacaoPorAtivoDTO(String diaAtivo, Pregao pregao, String operacao, String ativo, int quantidade,
			BigDecimal preco, BigDecimal valorOperacao) {
		this.diaAtivo = diaAtivo;
		this.pregao = pregao;
		this.operacao = operacao;
		this.ativo = ativo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.valorOperacao = valorOperacao;
	}					

	
}
