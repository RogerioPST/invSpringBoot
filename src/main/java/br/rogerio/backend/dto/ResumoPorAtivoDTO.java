package br.rogerio.backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class ResumoPorAtivoDTO {

	private String ativo;

	private BigDecimal valorOutrasTaxas;

	private BigDecimal valorTaxasEmolumentos;

	private BigDecimal valorTaxaLiquidacao;

	private BigDecimal valorOperacaoTotal;

	private List<MovimentacaoPorAtivoDTO> movimentacoesPorAtivo;

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public BigDecimal getValorOutrasTaxas() {
		return valorOutrasTaxas;
	}

	public void setValorOutrasTaxas(BigDecimal valorOutrasTaxas) {
		this.valorOutrasTaxas = valorOutrasTaxas;
	}

	public BigDecimal getValorTaxasEmolumentos() {
		return valorTaxasEmolumentos;
	}

	public void setValorTaxasEmolumentos(BigDecimal valorTaxasEmolumentos) {
		this.valorTaxasEmolumentos = valorTaxasEmolumentos;
	}

	public BigDecimal getValorTaxaLiquidacao() {
		return valorTaxaLiquidacao;
	}

	public void setValorTaxaLiquidacao(BigDecimal valorTaxaLiquidacao) {
		this.valorTaxaLiquidacao = valorTaxaLiquidacao;
	}

	public BigDecimal getValorOperacaoTotal() {
		return valorOperacaoTotal;
	}

	public void setValorOperacaoTotal(BigDecimal valorOperacaoTotal) {
		this.valorOperacaoTotal = valorOperacaoTotal;
	}

	public List<MovimentacaoPorAtivoDTO> getMovimentacoesPorAtivo() {
		return movimentacoesPorAtivo;
	}

	public void setMovimentacoesPorAtivo(List<MovimentacaoPorAtivoDTO> movimentacoesPorAtivo) {
		this.movimentacoesPorAtivo = movimentacoesPorAtivo;
	}

	public ResumoPorAtivoDTO(String ativo, BigDecimal valorOutrasTaxas, BigDecimal valorTaxasEmolumentos,
			BigDecimal valorTaxaLiquidacao, BigDecimal valorOperacaoTotal,
			List<MovimentacaoPorAtivoDTO> movimentacoesPorAtivo) {
		this.ativo = ativo;
		this.valorOutrasTaxas = valorOutrasTaxas;
		this.valorTaxasEmolumentos = valorTaxasEmolumentos;
		this.valorTaxaLiquidacao = valorTaxaLiquidacao;
		this.valorOperacaoTotal = valorOperacaoTotal;
		this.movimentacoesPorAtivo = movimentacoesPorAtivo;
	}

	


	
	

	
}
