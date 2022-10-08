package br.rogerio.backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.rogerio.backend.dto.ProventoAnoDTO;
import br.rogerio.backend.dto.ProventoAnoMesDTO;
import br.rogerio.backend.dto.ProventoMesDTO;

import br.rogerio.backend.model.Provento;

@Repository
public interface ProventoRepository extends JpaRepository<Provento, Long>{		

	/*  @Query("select new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),p.data )   from Provento p " + 
	"group by p.data order by p.data desc")
	List<ProventoMesDTO> findAllAgrupadoPorData();	  */



	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),to_char(p.data, 'YYYY-MM') as n )   from Provento p group by n")
	@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(substring(p.data, 1, 7) as anoMes, sum(p.valor) ) " +
	"from Provento p group by anoMes order by p.data asc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	List<ProventoMesDTO> findProventoPorMes();

	@Query(value = "SELECT p from Provento p order by p.data asc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	List<Provento> findProventoPorMesMapping();
	

	@Query(value = "SELECT new br.rogerio.backend.dto.ProventoAnoMesDTO(year(p.data) as ano, substring(p.data, 1, 7) as anoMes, sum(p.valor) ) " +
	"from Provento p group by ano, anoMes order by p.data asc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	List<ProventoAnoMesDTO> findProventoPorAnoMes();

	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoAnoDTO(year(p.data) as ano, " +
	//"new br.rogerio.backend.dto.ProventoMesDTO(substring(p.data, 1, 7) as anoMes, sum(p.valor) ) " +
	//"from Provento p group by ano, anoMes order by p.data desc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	//List<ProventoAnoDTO> findProventoPorAno();

	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoAnoDTO(year(p.data) as ano, sum(p.valor) ) " +
	//"from Provento p group by ano order by p.data desc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
//	List<ProventoAnoDTO> findProventoPorAno();

	/*  @Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor), DATE_FORMAT(p.data,'%Y-%m')) FROM Provento p " +
        "GROUP BY DATE_FORMAT(p.data,'%Y-%m') order by p.data desc") */
	 //@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor), function('date_format', p.data, '%Y, %m')) FROM Provento p " +
     //   "GROUP BY function('date_format', p.data, '%Y, %m') order by p.data desc")
//	List<ProventoMesDTO> findAllAgrupado2();	 


	
}