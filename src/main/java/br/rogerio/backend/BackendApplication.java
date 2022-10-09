package br.rogerio.backend;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.rogerio.backend.model.Ativo;
import br.rogerio.backend.model.MovimentacaoPregao;
import br.rogerio.backend.model.Pregao;
import br.rogerio.backend.model.Provento;
import br.rogerio.backend.model.TipoMovimentacao;
import br.rogerio.backend.model.TipoProvento;
import br.rogerio.backend.model.Usuario;
import br.rogerio.backend.repository.AtivoRepository;
import br.rogerio.backend.repository.AtivoUsuarioRepository;
import br.rogerio.backend.repository.MovimentacaoPregaoRepository;
import br.rogerio.backend.repository.PregaoRepository;
import br.rogerio.backend.repository.ProventoRepository;
import br.rogerio.backend.repository.TipoMovimentacaoRepository;
import br.rogerio.backend.repository.TipoProventoRepository;
import br.rogerio.backend.repository.UsuarioRepository;



@SpringBootApplication
public class BackendApplication {

	

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	//essa opcao eh acessada qdo o projeto eh inicializado e foi soh usada p teste enquanto n existe o bd
	/*
	fetch('http://localhost:8080/api/rotinas', options).then((resp) => resp.json()).then( dado => console.log(dado))
	*/
	@Bean
	CommandLineRunner initDatabase(AtivoRepository ativoRepository,
	AtivoUsuarioRepository ativoUsuarioRepository, 
	MovimentacaoPregaoRepository movimentacaoPregaoRepository, 
	PregaoRepository pregaoRepository, 
	ProventoRepository proventoRepository, 
	TipoMovimentacaoRepository tipoMovimentacaoRepository, 
	TipoProventoRepository tipoProventoRepository, 
	UsuarioRepository usuarioRepository){
		return args -> {
			usuarioRepository.deleteAll();
			ativoRepository.deleteAll();
			tipoProventoRepository.deleteAll();
			tipoMovimentacaoRepository.deleteAll();
			pregaoRepository.deleteAll();
			proventoRepository.deleteAll();
			movimentacaoPregaoRepository.deleteAll();
			ativoUsuarioRepository.deleteAll();
			
			Usuario u = new Usuario();
			u.setNome("Rogerio");
			u.setLogin("roger");
			usuarioRepository.save(u);

			Ativo a = new Ativo();
			a.setNome("PETR4");
			ativoRepository.save(a);						
			Ativo bbas3 = new Ativo();
			bbas3.setNome("BBAS3");
			ativoRepository.save(bbas3);						
			Ativo enbr3 = new Ativo();
			enbr3.setNome("ENBR3");
			ativoRepository.save(enbr3);						
			Ativo itsa4 = new Ativo();
			itsa4.setNome("ITSA4");
			ativoRepository.save(itsa4);						
			Ativo taee11 = new Ativo();
			taee11.setNome("TAEE11");
			ativoRepository.save(taee11);
			

			TipoProvento tp = new TipoProvento();
			tp.setNome("RENDIMENTO");
			tp.setSigla("REND");
			tipoProventoRepository.save(tp);

			TipoMovimentacao tm = new TipoMovimentacao();
			tm.setNome("COMPRA");			
			tipoMovimentacaoRepository.save(tm);

			TipoMovimentacao tm2 = new TipoMovimentacao();
			tm2.setNome("VENDA");			
			tipoMovimentacaoRepository.save(tm2);


			Pregao p = new Pregao();
			p.setUsuario(u);						
			p.setData(SDF.parse("2021-12-30"));			
			p.setComprasAVista(BigDecimal.valueOf(47723.04));
			p.setVendasAVista(BigDecimal.valueOf(0));
			p.setValorOperacoes(BigDecimal.valueOf(47723.04));
			p.setValorLiquidoOperacoes(BigDecimal.valueOf(47723.04));
			p.setTaxaLiquidacao(BigDecimal.valueOf(11.93));
			p.setTotalCblc(BigDecimal.valueOf(47734.97));			
			p.setEmolumentos(BigDecimal.valueOf(2.38));			
			p.setTaxaOperacional(BigDecimal.valueOf(53.90));			
			p.setImpostos(BigDecimal.valueOf(5.75));			
			p.setOutros(BigDecimal.valueOf(2.10));			
			p.setTotalCustosDespesas(BigDecimal.valueOf(61.75));			
			p.setDataLiquidoPara(SDF.parse("2022-01-04"));			
			p.setValorLiquidoPara(BigDecimal.valueOf(47799.10));			
			pregaoRepository.save(p);


			Pregao p2 = new Pregao();
			p2.setUsuario(u);						
			p2.setData(SDF.parse("2022-02-27"));			
			p2.setComprasAVista(BigDecimal.valueOf(47723.04));
			p2.setVendasAVista(BigDecimal.valueOf(0));
			p2.setValorOperacoes(BigDecimal.valueOf(47723.04));
			p2.setValorLiquidoOperacoes(BigDecimal.valueOf(47723.04));
			p2.setTaxaLiquidacao(BigDecimal.valueOf(11.93));
			p2.setTotalCblc(BigDecimal.valueOf(47734.97));			
			p2.setEmolumentos(BigDecimal.valueOf(2.38));			
			p2.setTaxaOperacional(BigDecimal.valueOf(53.90));			
			p2.setImpostos(BigDecimal.valueOf(5.75));			
			p2.setOutros(BigDecimal.valueOf(2.10));			
			p2.setTotalCustosDespesas(BigDecimal.valueOf(61.75));			
			p2.setDataLiquidoPara(SDF.parse("2022-03-02"));			
			p2.setValorLiquidoPara(BigDecimal.valueOf(47799.10));			
			pregaoRepository.save(p2);

			Pregao p3 = new Pregao();
			p3.setUsuario(u);						
			p3.setData(SDF.parse("2022-01-11"));			
			p3.setComprasAVista(BigDecimal.valueOf(47723.04));
			p3.setVendasAVista(BigDecimal.valueOf(0));
			p3.setValorOperacoes(BigDecimal.valueOf(47723.04));
			p3.setValorLiquidoOperacoes(BigDecimal.valueOf(47723.04));
			p3.setTaxaLiquidacao(BigDecimal.valueOf(11.93));
			p3.setTotalCblc(BigDecimal.valueOf(47734.97));			
			p3.setEmolumentos(BigDecimal.valueOf(2.38));			
			p3.setTaxaOperacional(BigDecimal.valueOf(53.90));			
			p3.setImpostos(BigDecimal.valueOf(5.75));			
			p3.setOutros(BigDecimal.valueOf(2.10));			
			p3.setTotalCustosDespesas(BigDecimal.valueOf(61.75));			
			p3.setDataLiquidoPara(SDF.parse("2022-01-13"));			
			p3.setValorLiquidoPara(BigDecimal.valueOf(47799.10));			
			pregaoRepository.save(p3);

			
			MovimentacaoPregao mp = new MovimentacaoPregao();
			mp.setPregao(p);					
			mp.setAtivo(bbas3);	
			mp.setQuantidade(9);
			mp.setPreco(BigDecimal.valueOf(28.88));
			mp.setValorOperacao(BigDecimal.valueOf(259.92));
			mp.setTipoMovimentacao(tm);	
			movimentacaoPregaoRepository.save(mp);

			MovimentacaoPregao mp3 = new MovimentacaoPregao();
			mp3.setPregao(p);					
			mp3.setAtivo(bbas3);	
			mp3.setQuantidade(1);
			mp3.setPreco(BigDecimal.valueOf(28.88));
			mp3.setValorOperacao(BigDecimal.valueOf(28.88));
			mp3.setTipoMovimentacao(tm);	
			movimentacaoPregaoRepository.save(mp3);

			MovimentacaoPregao mp4 = new MovimentacaoPregao();
			mp4.setPregao(p3);					
			mp4.setAtivo(bbas3);	
			mp4.setQuantidade(500);
			mp4.setPreco(BigDecimal.valueOf(28.87));
			mp4.setValorOperacao(BigDecimal.valueOf(14439.32));
			mp4.setTipoMovimentacao(tm);	
			movimentacaoPregaoRepository.save(mp4);

			MovimentacaoPregao mpPregao2 = new MovimentacaoPregao();
			mpPregao2.setPregao(p2);					
			mpPregao2.setAtivo(a);	
			mpPregao2.setQuantidade(100);
			mpPregao2.setPreco(BigDecimal.valueOf(26.50));
			mpPregao2.setValorOperacao(new BigDecimal(2600));
			mpPregao2.setTipoMovimentacao(tm);	
			movimentacaoPregaoRepository.save(mpPregao2);
			

			MovimentacaoPregao mp2 = new MovimentacaoPregao();
			mp2.setPregao(p);					
			mp2.setAtivo(a);	
			mp2.setQuantidade(100);
			mp2.setPreco(new BigDecimal(26));
			mp2.setValorOperacao(BigDecimal.valueOf(2600.50));
			mp2.setTipoMovimentacao(tm2);	
			movimentacaoPregaoRepository.save(mp2);
			
			Provento provento = new Provento();
			provento.setUsuario(u);			
			provento.setTipoProvento(tp);		
			provento.setAtivo(a);					
			provento.setValor(new BigDecimal(70));		
			provento.setQuantidadeCotas(50);			
			provento.setData(SDF.parse("2022-01-30"));			
			proventoRepository.save(provento);

			Provento provento1 = new Provento();
			provento1.setUsuario(u);			
			provento1.setTipoProvento(tp);		
			provento1.setAtivo(a);					
			provento1.setValor(new BigDecimal(70));		
			provento1.setQuantidadeCotas(50);			
			provento1.setData(SDF.parse("2021-01-30"));			
			proventoRepository.save(provento1);															

			Provento provento2 = new Provento();
			provento2.setUsuario(u);			
			provento2.setTipoProvento(tp);		
			provento2.setAtivo(a);					
			provento2.setValor(new BigDecimal(50));		
			provento2.setQuantidadeCotas(50);			
			provento2.setData(SDF.parse("2021-03-30"));			
			proventoRepository.save(provento2);	

			Provento provento3 = new Provento();
			provento3.setUsuario(u);			
			provento3.setTipoProvento(tp);		
			provento3.setAtivo(a);					
			provento3.setValor(new BigDecimal(50));		
			provento3.setQuantidadeCotas(50);			
			provento3.setData(SDF.parse("2022-02-30"));			
			proventoRepository.save(provento3);															


			 /* Rotina r1 = new Rotina();
			r1.setDescricao("Rotina2");			
			rotinaRepository.save(r1);
			Rotina r2 = new Rotina();
			r2.setDescricao("Rotina31");			
			rotinaRepository.save(r2);  */


/* 			statusRepository.deleteAll();
			TipoMovimentacao s = new TipoMovimentacao();
			s.setNome("NÃO INICIADO");			
			statusRepository.save(s);
			TipoMovimentacao s1 = new TipoMovimentacao();
			s1.setNome("FINALIZADO");			
			statusRepository.save(s1);
			TipoMovimentacao s2 = new TipoMovimentacao();
			s2.setNome("EM ANDAMENTO");		
			statusRepository.save(s2);

			usuarioRepository.deleteAll();
			Usuario u = new Usuario();
			u.setNome("Roger");
			u.setMatricula("c007007");
			u.setTipo("ADM");
			usuarioRepository.save(u);
			Usuario u1 = new Usuario();
			u1.setNome("Vanessa");
			u1.setMatricula("c999091");
			u1.setTipo("NOR");
			usuarioRepository.save(u1);

			

			rotinaDoDiaRepository.deleteAll();
			







 *//* 
			 diaRepository.deleteAll();
			Dia d = new Dia();
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-11");

			d.setData(data);			
			Date horaAbertura = new SimpleDateFormat("HH:mm").parse("10:15");
			Date horaFechamento = new SimpleDateFormat("HH:mm").parse("18:15");
			d.setHoraAbertura(horaAbertura);			
			d.setHoraFechamento(horaFechamento);			
			d.setUsuarioAbertura(u);
			d.setUsuarioFechamento(u);
			d.setStatus(s);
			diaRepository.save(d);

			rotinaDoDiaRepository.deleteAll();
			RotinasDia rd = new RotinasDia();		
			Date horaInicio = new SimpleDateFormat("HH:mm").parse("10:15");
			Date horaFim = new SimpleDateFormat("HH:mm").parse("18:15");	
			rd.setHoraInicio(horaInicio);									
			rd.setUsuarioInicioRotina(u);			
			rd.setStatus(s2);
			rd.setDia(d);
			rd.setRotina(r);

			rotinaDoDiaRepository.save(rd);
			RotinasDia rd1 = new RotinasDia();		
			
			rd1.setHoraInicio(horaInicio);			
			rd1.setHoraFim(horaFim);			

			rd1.setUsuarioFimRotina(u1);
			rd1.setUsuarioInicioRotina(u1);			
			rd1.setStatus(s1);
			rd1.setDia(d);
			rd1.setRotina(r1);

			rotinaDoDiaRepository.save(rd1);

			RotinasDia rd2 = new RotinasDia();												
			rd2.setStatus(s);
			rd2.setDia(d);
			rd2.setRotina(r2);

			rotinaDoDiaRepository.save(rd2);  */
		};
	}
}
		