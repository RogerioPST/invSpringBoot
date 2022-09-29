package br.rogerio.backend.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
//@Table(name = "movimentacao_pregao")
public class MovimentacaoPregao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		

	@ManyToOne
	private Pregao pregao;
	
	@ManyToOne
	private Ativo ativo;		

	@ManyToOne
	private TipoMovimentacao tipoMovimentacao;	

	private int quantidade;

	private BigDecimal preco;
	
	private BigDecimal valorOperacao;

	
}
