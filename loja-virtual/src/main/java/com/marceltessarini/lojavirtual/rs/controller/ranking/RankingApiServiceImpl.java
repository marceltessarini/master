package com.marceltessarini.lojavirtual.rs.controller.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.exception.RankingException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;
import com.marceltessarini.lojavirtual.rs.utils.PaginacaoUtils;

@Service
public class RankingApiServiceImpl implements RankingApiService {

	@Override
	public ResponseEntity<Rankings> getRankingsDoProduto(RankingsDoProdutoRequest request) {
		validarRankingsDoProdutoRequest(request);

		Long idProduto = request.getIdProduto();
		// -----------------------------------------------------------
		// Fake
		simmulandoProblemasComSeguranca(idProduto);
		
		Rankings rankings = criarRankings(idProduto);
		
		// -----------------------------------------------------------
		ResponseEntity<Rankings> response = new ResponseEntity<Rankings>(rankings, HttpStatus.OK);
		return response;
	}
	
	private Rankings criarRankings(Long idProduto) {
		Rankings rakingsWrapper = new  Rankings();
		
		List<Ranking> rankings = rakingsWrapper.getRankings();

		Ranking r1 = criarRanking(1L, idProduto, 8, "Bom livro");
		Ranking r2 = criarRanking(2L, idProduto, 1, "Ruim!");
		Ranking r3 = criarRanking(3L, idProduto, 8, "Recomendo");
		Ranking r4 = criarRanking(4L, idProduto, 5, "Razoável!");
		Ranking r5 = criarRanking(5L, idProduto, 8, "Joia!");
		
		rankings.add(r1);
		rankings.add(r2);
		rankings.add(r3);
		rankings.add(r4);
		rankings.add(r5);
		

		String url = "/api/loja/v1/produtos/" + idProduto + "/ranking";
		List<Metadata> paginacao = PaginacaoUtils.criarMetadataPaginacao(10L, 10L, 10L, url);
		rakingsWrapper.setMetadata(paginacao);		

		return rakingsWrapper;
	}
	
	private Ranking criarRanking(Long id, Long idProduto, Integer nota, String comentario) {
		Ranking r1 = new Ranking();
		r1.setId(id);
		r1.setIdProduto(idProduto);
		r1.setNota(nota);
		r1.setComentario(comentario);
		return r1;
	}



	private void simmulandoProblemasComSeguranca(Long idProduto) {
		List<Erro> itensErro = new ArrayList<>();

		if (idProduto == 403) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_403_201;
			Erro erro403 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro403);
		}
		
		if (idProduto == 401) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_401_201;
			Erro erro401 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro401);
		}
		
		
		ApiSecurityException.lancarSeTiverErros(itensErro);
	}

	private void validarRankingsDoProdutoRequest(RankingsDoProdutoRequest request) {
    	Long page = request.getPage();
    	Long limit = request.getLimit();
		PaginacaoUtils.validarValores(page, limit);
		
		String order = request.getOrder();
		Erro erroOrder = null;
		if (!isOrderValida(order)) {
			String[] parametros = {"nota", "-nota"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_301;
			erroOrder = CodigoAPIService.criarErro(chave, parametros);
		}
		
		
		List<Erro> itensErro = new ArrayList<>();
		
		if (erroOrder != null) {
			itensErro.add(erroOrder);
		}
		
		QueryStringException.lancarSeTiverErros(itensErro);
	}

	private boolean isOrderValida(String order) {
		if (StringUtils.isNotBlank(order)) {
			// order por vir separado por vírgula: order=nota
			String[] itensOrder = order.split(",");
			List<String> valoresValidos = Arrays.asList("nota", "-nota");
			for (String itemOrder:itensOrder) {
				String orderTrim = itemOrder.trim();
				boolean orderValida = valoresValidos.contains(orderTrim);
				if (!orderValida) {
					return false;
				}
			}
		}
		
		// Blank eh valido!
		return true;
	}

	@Override
	public ResponseEntity<Void> salvar(Ranking ranking) {
		// ------------------------------
		// simulando, fake!
		Long idProduto = ranking.getIdProduto();
		simulandoErroAoSalvar(idProduto);
		
		simmulandoProblemasComSeguranca(idProduto);
		// ------------------------------
		ResponseEntity<Void> response = adicionarRanking(ranking);
		return response;
	}

	private void simulandoErroAoSalvar(Long idProduto) {
		if (idProduto == 10) {
			// Produto nao existe!
			// RANKING_003_003
			List<Erro> itensErro = new ArrayList<>();
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.RANKING_003_003;
			Erro erro = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro);
			
			RankingException.lancarSeTiverErros(itensErro);

		}
	}

	private ResponseEntity<Void> adicionarRanking(Ranking ranking) {
		// Fake!
		String location = "/api/loja/v1/ranking/456";
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Location", location);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Ranking> getRanking(Long idRanking) {
		Ranking r1 = criarRanking(idRanking, 50L, 8, "Bom livro");
		ResponseEntity<Ranking> response = new ResponseEntity<Ranking>(r1, HttpStatus.OK);
		return response;
	}


}
