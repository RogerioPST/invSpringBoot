package br.rogerio.backend.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumoPorAtivoPregaoDTO {

	private String ativo;

	private BigDecimal valorOutrasTaxas;

	private BigDecimal valorTaxasEmolumentos;

	private BigDecimal valorTaxaLiquidacao;

	private BigDecimal valorOperacaoTotal;

	private List<MovimentacaoPorAtivoPregaoDTO> movimentacoesPorAtivo;
	
	public ResumoPorAtivoPregaoDTO(String ativo, BigDecimal valorOutrasTaxas, BigDecimal valorTaxasEmolumentos,
			BigDecimal valorTaxaLiquidacao, BigDecimal valorOperacaoTotal,
			List<MovimentacaoPorAtivoPregaoDTO> movimentacoesPorAtivo) {
		this.ativo = ativo;
		this.valorOutrasTaxas = valorOutrasTaxas;
		this.valorTaxasEmolumentos = valorTaxasEmolumentos;
		this.valorTaxaLiquidacao = valorTaxaLiquidacao;
		this.valorOperacaoTotal = valorOperacaoTotal;
		this.movimentacoesPorAtivo = movimentacoesPorAtivo;
	}				
}
