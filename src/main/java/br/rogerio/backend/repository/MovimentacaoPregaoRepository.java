package br.rogerio.backend.repository;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.rogerio.backend.dto.AtivoQuantidadeTotalDTO;
import br.rogerio.backend.dto.MovimentacaoPorAtivoDTO;
import br.rogerio.backend.dto.MovimentacaoPorAtivoPregaoDTO;
import br.rogerio.backend.dto.MovimentacaoTotalPorAtivoPregaoDTO;
import br.rogerio.backend.dto.MovimentacoesDTO;
import br.rogerio.backend.dto.StatsDTO;
import br.rogerio.backend.model.MovimentacaoPregao;
import br.rogerio.backend.model.Pregao;

@Repository
public interface MovimentacaoPregaoRepository extends CrudRepository<MovimentacaoPregao, Long>{
	
	List<MovimentacaoPregao> findByPregao(Pregao pregao);	

	@Query("select new br.rogerio.backend.dto.StatsDTO(count(v),v.ativo )   from MovimentacaoPregao v where v.pregao = :pregao group by v.ativo order by v.ativo")
	List<StatsDTO> findByPregaoGroupByAtivo(Pregao pregao);	

	@Query(value = "SELECT new br.rogerio.backend.dto.MovimentacaoPorAtivoDTO(CONCAT(m.pregao.data, m.ativo.nome), m.pregao, m.tipoMovimentacao.nome, m.ativo.nome, " +
	"m.quantidade, m.preco, m.valorOperacao ) " +
	"from MovimentacaoPregao m group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc")	
	List<MovimentacaoPorAtivoDTO> findMovimentacaoPorAtivo();	


	@Query(value = "SELECT new br.rogerio.backend.dto.MovimentacaoPorAtivoPregaoDTO(CONCAT(m.pregao.data, m.ativo.nome), m.tipoMovimentacao.nome, m.ativo.nome, " +
	"m.quantidade, m.preco, m.valorOperacao ) " +
	"from MovimentacaoPregao m group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc")	
	List<MovimentacaoPorAtivoPregaoDTO> findMovimentacaoPorAtivoPregao();	


	@Query(value = "SELECT sum(m.quantidade)  " +
	"from MovimentacaoPregao m ")	
	Integer findMovimentacaoPorAtivoq();	

	@Query(value = "SELECT new br.rogerio.backend.dto.MovimentacaoTotalPorAtivoPregaoDTO(m.pregao, m.ativo.nome, sum(m.valorOperacao) ) " +
	"from MovimentacaoPregao m group by m.pregao, m.ativo.nome order by m.pregao.data asc")	
	List<MovimentacaoTotalPorAtivoPregaoDTO> findMovimentacaoTotalPorAtivoPregao();	

	@Query(value = "SELECT new br.rogerio.backend.dto.AtivoQuantidadeTotalDTO(m.pregao, m.ativo.nome, sum(m.valorOperacao), sum(m.quantidade))  " +
	"from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo order by m.pregao, m.ativo.nome")	
	AtivoQuantidadeTotalDTO findTotalAtivoNota(Pregao pregao, String ativo);	
}