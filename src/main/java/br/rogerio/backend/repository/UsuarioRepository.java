package br.rogerio.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.rogerio.backend.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{		
	
}