package br.rogerio.backend.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
//@Table(name = "pregao")
public class Pregao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		

	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	private Usuario usuario;

	private BigDecimal comprasAVista;
	private BigDecimal vendasAVista;
	private BigDecimal valorOperacoes;
	private BigDecimal valorLiquidoOperacoes;
	private BigDecimal taxaLiquidacao;
	private BigDecimal totalCblc;
	private BigDecimal emolumentos;	
	private BigDecimal taxaOperacional;
	private BigDecimal impostos;
	private BigDecimal outros;
	private BigDecimal totalCustosDespesas;
	
	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataLiquidoPara;
	private BigDecimal valorLiquidoPara;
}
