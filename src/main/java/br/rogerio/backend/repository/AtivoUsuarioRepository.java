package br.rogerio.backend.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.rogerio.backend.model.AtivoUsuario;

@Repository
public interface AtivoUsuarioRepository extends JpaRepository<AtivoUsuario, Long>{

	AtivoUsuario findByData(Date data);
	
	
}