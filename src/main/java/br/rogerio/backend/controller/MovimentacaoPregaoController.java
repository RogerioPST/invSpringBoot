package br.rogerio.backend.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rogerio.backend.dto.AtivoQuantidadeTotalDTO;
import br.rogerio.backend.dto.MovimentacaoPorAtivoDTO;
import br.rogerio.backend.dto.MovimentacaoTotalPorAtivoPregaoDTO;
import br.rogerio.backend.dto.MovimentacoesDTO;
import br.rogerio.backend.dto.ResumoPorAtivoDTO;
import br.rogerio.backend.dto.StatsDTO;
import br.rogerio.backend.model.MovimentacaoPregao;
import br.rogerio.backend.model.Pregao;
import br.rogerio.backend.repository.MovimentacaoPregaoRepository;
import br.rogerio.backend.repository.PregaoRepository;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/movimentacao_pregao")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class MovimentacaoPregaoController {

	private final MovimentacaoPregaoRepository movimentacaoPregaoRepository;			
	private final PregaoRepository pregaoRepository;			

	@GetMapping
	public List<MovimentacaoPregao> list(){
		List<MovimentacaoPregao> students = new ArrayList<>();
		movimentacaoPregaoRepository.findAll().forEach(students::add);
		return students;

	
	}

	@GetMapping
	@RequestMapping("/total")
	public List<MovimentacaoTotalPorAtivoPregaoDTO> findMovimentacaoTotalPorAtivoPregao(){		
		return movimentacaoPregaoRepository.findMovimentacaoTotalPorAtivoPregao();	
	}

	@GetMapping	
	@RequestMapping("/ativo-nota")
	public AtivoQuantidadeTotalDTO findTotalAtivoNota(Pregao pregao, String ativo){		
		return movimentacaoPregaoRepository.findTotalAtivoNota(pregao, ativo);	
	}

	@GetMapping
	@RequestMapping("/totalq")
	public Integer findMovimentacaoPorAtivoq(){		
		return movimentacaoPregaoRepository.findMovimentacaoPorAtivoq();	
	}


	@GetMapping
	@RequestMapping("/ativo")
	public List<ResumoPorAtivoDTO> findMovimentacaoPorAtivo(){		
		List<MovimentacaoPorAtivoDTO> movimentacoesAtivo = this.findMovimentacaoPorAtivo1();

		Map<String, List<MovimentacaoPorAtivoDTO>> mapaAtivoPregao = new HashMap<>();
		Map<Date, List<ResumoPorAtivoDTO>> mapaResumoAtivoPregao = new HashMap<>();

		List<MovimentacoesDTO> movs = new ArrayList<>();
		
		//List<MovimentacaoTotalPorAtivoPregaoDTO> movimentacoesTotaisAtivo = this.findMovimentacaoTotalPorAtivoPregao();				
		
		List<ResumoPorAtivoDTO> resumos = new ArrayList<>();
		List<MovimentacaoPorAtivoDTO> listaExistente = new ArrayList<>();					
		List<ResumoPorAtivoDTO> listaExistenteResumo = new ArrayList<>();

		int quantidadeDeCadaAtivo = 0;

		for (MovimentacaoPorAtivoDTO movDTO : movimentacoesAtivo){			
			
			String ativo = movDTO.getAtivo();
			Pregao pregao = movDTO.getPregao();
			Long id = movDTO.getPregao().getId();
			String chave = String.valueOf(id)+ativo;											
			System.out.println("ativo: " + ativo);
			
			listaExistente.add(movDTO);							
			
			//if (mapaAtivoPregao.get(chave) == null){				
				
				AtivoQuantidadeTotalDTO totalAtivoNotaDTO = this.findTotalAtivoNota(pregao, ativo);
				
				
				
				quantidadeDeCadaAtivo += movDTO.getQuantidade();
				
				BigDecimal proporcaoValorAtivoNaNotaTaxa = devolveOValorDaProporcaoDaNota(movDTO, totalAtivoNotaDTO.getTotal());
				BigDecimal totalTaxaLiquidacaoPorAtivoPregao = pregao.getTaxaLiquidacao().multiply(proporcaoValorAtivoNaNotaTaxa);
				BigDecimal totalEmolumentosPorAtivoPregao = pregao.getEmolumentos().multiply(proporcaoValorAtivoNaNotaTaxa);
				BigDecimal totalOutrasTaxasComOperacional = pregao.getTaxaOperacional().add(pregao.getOutros());
				BigDecimal totalOutrasTaxasPorAtivoPregao = totalOutrasTaxasComOperacional.multiply(proporcaoValorAtivoNaNotaTaxa);								
				
				List<MovimentacaoPorAtivoDTO> unmodifiableList = List.copyOf(listaExistente);					
				ResumoPorAtivoDTO resumo = new ResumoPorAtivoDTO(ativo, totalOutrasTaxasPorAtivoPregao, totalEmolumentosPorAtivoPregao,
				totalTaxaLiquidacaoPorAtivoPregao, totalAtivoNotaDTO.getTotal(), unmodifiableList  );		
											
				if (totalAtivoNotaDTO.getTotalQuantidade() == quantidadeDeCadaAtivo ){
					quantidadeDeCadaAtivo = 0;
														
					resumos.add(resumo);
					listaExistente.clear();								
				} 			
			
	 		if (mapaResumoAtivoPregao.get(pregao.getData()) == null) {
				List<ResumoPorAtivoDTO> copyOf = List.copyOf(listaExistenteResumo);
				if (!listaExistenteResumo.isEmpty()){
					MovimentacoesDTO mov = new MovimentacoesDTO(pregao.getData(), copyOf);
					movs.add(mov);
				}
				listaExistenteResumo.clear();
			}  else{
				listaExistenteResumo = mapaResumoAtivoPregao.get(pregao.getData());				
			}
			listaExistenteResumo.add(resumo);				
			mapaResumoAtivoPregao.put(pregao.getData(), listaExistenteResumo);	 								
		}										
		
		return  resumos;

	}

	@GetMapping
	@RequestMapping("/teste")
	public List<MovimentacaoPorAtivoDTO> findMovimentacaoPorAtivo1(){		
		return movimentacaoPregaoRepository.findMovimentacaoPorAtivo();		
	}

	

	@GetMapping("/{data}")
	public List<StatsDTO> listarMovimentacoesDoDia(@PathVariable String data){
		Date dataD = new Date();
		Pregao pregao = new Pregao();
		try {
			dataD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			pregao = pregaoRepository.findByData(dataD);			
		} catch	 (ParseException e) {			
			e.printStackTrace();
		}	

		if (movimentacaoPregaoRepository.findByPregao(pregao).isEmpty()){
			try {
				dataD = new SimpleDateFormat("yyyy-MM-dd").parse(data);				
				pregao = pregaoRepository.findByData(dataD);
			} catch (ParseException e) {			
				e.printStackTrace();
			}
		}
		return movimentacaoPregaoRepository.findByPregaoGroupByAtivo(pregao);	
	}

	private BigDecimal devolveOValorDaProporcaoDaNota(MovimentacaoPorAtivoDTO negocio, BigDecimal valorAcumuladoOperacaoDeCadaAtivo) {
		Pregao nota = negocio.getPregao();
		BigDecimal proporcaoNegocioAtivoNaNota = BigDecimal.ZERO;
		if ( nota.getVendasAVista().compareTo(nota.getComprasAVista()) > 0) {
			if (negocio.getOperacao().equals("VENDA")) {
				proporcaoNegocioAtivoNaNota = valorAcumuladoOperacaoDeCadaAtivo.divide(nota.getVendasAVista(), 2, RoundingMode.HALF_UP);
			}
		} else if  (nota.getVendasAVista().compareTo(nota.getComprasAVista()) <= 0){
			if (negocio.getOperacao().equals("COMPRA")) {
				proporcaoNegocioAtivoNaNota = valorAcumuladoOperacaoDeCadaAtivo.divide(nota.getComprasAVista(), 2, RoundingMode.HALF_UP);
			}
		}
		return proporcaoNegocioAtivoNaNota;
}

	
}
