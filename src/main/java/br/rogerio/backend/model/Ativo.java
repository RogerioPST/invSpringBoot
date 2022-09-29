package br.rogerio.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
//@Table(name = "ativos")
public class Ativo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@JsonFormat(locale="zh", timezone="GMT-3", pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	private Date horaAbertura;

	@JsonFormat(locale="zh", timezone="GMT-3", pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	private Date horaFechamento;
	
}
