package br.rogerio.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.rogerio.backend.model.TipoMovimentacao;



@Repository
public interface TipoMovimentacaoRepository extends JpaRepository<TipoMovimentacao, Long>{		
	
}