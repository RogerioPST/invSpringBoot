package br.rogerio.backend.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.rogerio.backend.model.Pregao;

@Repository
public interface PregaoRepository extends JpaRepository<Pregao, Long>{
	
	Pregao findByData(Date data);
	
}