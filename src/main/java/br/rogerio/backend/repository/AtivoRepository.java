package br.rogerio.backend.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.rogerio.backend.model.Ativo;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long>{

	Ativo findByData(Date data);
	
}
