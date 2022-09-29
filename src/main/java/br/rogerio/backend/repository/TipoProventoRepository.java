package br.rogerio.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.rogerio.backend.model.TipoProvento;



@Repository
public interface TipoProventoRepository extends JpaRepository<TipoProvento, Long>{		
	
}