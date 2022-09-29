package br.rogerio.backend.dto;

import java.math.BigDecimal;

import br.rogerio.backend.model.Pregao;

public class MovimentacaoPorAtivoDTO {	

	private Pregao pregao;
	private String operacao;
	private String ativo;	

	private int quantidade;
	
	private BigDecimal preco;
	
	private BigDecimal valorOperacao;			

	
	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(BigDecimal valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	

	


	public MovimentacaoPorAtivoDTO(Pregao pregao, String operacao, String ativo, int quantidade, BigDecimal preco,
			BigDecimal valorOperacao) {
		this.pregao = pregao;
		this.operacao = operacao;
		this.ativo = ativo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.valorOperacao = valorOperacao;				
	}

	public Pregao getPregao() {
		return pregao;
	}

	public void setPregao(Pregao pregao) {
		this.pregao = pregao;
	}




	

	
	
}
