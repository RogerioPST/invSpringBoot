package br.rogerio.backend.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rogerio.backend.dto.ProventoAnoDTO;
import br.rogerio.backend.dto.ProventoAnoMesDTO;
import br.rogerio.backend.dto.ProventoMesDTO;
import br.rogerio.backend.dto.StatsDTO;
import br.rogerio.backend.dto.TotalProventoDTO;
import br.rogerio.backend.model.Ativo;
import br.rogerio.backend.model.Provento;
import br.rogerio.backend.repository.AtivoRepository;
import br.rogerio.backend.repository.ProventoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/provento")
@AllArgsConstructor //com isso, n precisa do construtor inicializando/injecao de dependencia do usuarioRepository
public class ProventoController {
	
	private final ProventoRepository proventoRepository;			
	private final AtivoRepository ativoRepository;			
	
	@GetMapping
	
	public List<Provento> list(){
		return proventoRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
	}
	@GetMapping
	@RequestMapping("/tudo2")
	public List<StatsDTO> listTudo(){
		;
	//	List<ProventoMesDTO> todosProventosAgrupadosPorData = proventoRepository.findAllAgrupadoPorData();
	//	for(ProventoMesDTO cada : todosProventosAgrupadosPorData){
			//new SimpleDateFormat("yyyy-MM-dd").parse(cada.getData().toString());
	//	}

		List<StatsDTO> dtos = new ArrayList<StatsDTO>();
		//ativoRepository.findByNome("BBAS3");
		Ativo ativo = new Ativo();
		dtos.add(new StatsDTO(1L, ativo));
		dtos.add(new StatsDTO(1L, ativo));
		return dtos;

		//return proventoRepository.findAllAgrupadoPorData();
	}

	@GetMapping
	@RequestMapping("/tudo")
	public TotalProventoDTO findProvento(){
		List<ProventoMesDTO> meses = proventoRepository.findProventoPorMes();	

		Comparator<ProventoMesDTO> comparadorPorAnoDesc = Comparator.comparing(
			ProventoMesDTO::getAnoMes, (s1, s2) -> { return s2.substring(0,4)
				.compareTo(s1.substring(0,4));});
		
		Collections.sort(meses, comparadorPorAnoDesc);

		List<ProventoAnoDTO> anos = new ArrayList<>();				
		BigDecimal total = BigDecimal.ZERO;		

		Map<String, List<ProventoMesDTO>> mapasAnosDTO = new HashMap<>();
		
		for(ProventoMesDTO mesDTO : meses){			
			total = total.add(mesDTO.getTotal());
			String ano = mesDTO.getAnoMes().substring(0,4);
			String mes = mesDTO.getAnoMes().substring(5,7);

			ProventoMesDTO novoMesDTO = new ProventoMesDTO(mes, mesDTO.getTotal());

			List<ProventoMesDTO> listaExistente = new ArrayList<>();
			if (mapasAnosDTO.get(ano) != null) {
				listaExistente = mapasAnosDTO.get(ano);				
			} 
			listaExistente.add(novoMesDTO);				
			mapasAnosDTO.put(ano, listaExistente);						
		}
		
		//System.out.println(listaExistente);														

		for (Map.Entry<String, List<ProventoMesDTO>> entry : mapasAnosDTO.entrySet()) {						
			ProventoAnoDTO anoDTO = new ProventoAnoDTO(Integer.valueOf(entry.getKey()), entry.getValue());
			anos.add(anoDTO);			
		}		
		return 	new TotalProventoDTO( total, anos);
}

	/* @GetMapping
	@RequestMapping("/tudoano")
	public List<ProventoAnoDTO> findProventoPorAno(){
		return proventoRepository.findProventoPorAno();	
} */

	@GetMapping
	@RequestMapping("/mes")
	public List<ProventoMesDTO> findProventoPorMes(){
		return proventoRepository.findProventoPorMes();	
}

	@GetMapping
	@RequestMapping("/ano-mes")
	public List<ProventoAnoMesDTO> findProventoPorAnoMes(){
		List<ProventoAnoMesDTO> proventoAnoMes = proventoRepository.findProventoPorAnoMes();

		Comparator<ProventoAnoMesDTO> comparadorPorAnoDesc = Comparator.comparing(
			ProventoAnoMesDTO::getAno, (s1, s2) -> { return s2.compareTo(s1);});
		
			Collections.sort(proventoAnoMes, comparadorPorAnoDesc);
		
		return proventoAnoMes;
}
}
