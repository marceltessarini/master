package com.marceltessarini.lojavirtual.rs.controller.ranking;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-02T10:32:41.079-02:00")

@Controller
public class RankingApiController implements RankingApi {
	
	@Autowired
	private RankingApiService rankingApiService;

	/**
	 * Lista os rankings de um produto.
	 */
	@Override
	public ResponseEntity<Rankings> rankingGet(Long page, Long limit, Long idProduto, String order) {
		RankingsDoProdutoRequest request = new RankingsDoProdutoRequest(page, limit, idProduto, order);
		ResponseEntity<Rankings> response = rankingApiService.getRankingsDoProduto(request);
		return response;
	}

	/**
	 * Obtem um ranking.
	 */
	@Override
	public ResponseEntity<Ranking> rankingIdRankingGet(
			@ApiParam(value = "Identificador do Ranking.", required = true) @PathVariable("idRanking") Long idRanking) {
		ResponseEntity<Ranking> response = rankingApiService.getRanking(idRanking);
		return response;
	}

	@Override
	public ResponseEntity<Nota> rankingNotasIdProdutoGet(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> rankingPost(@Valid @RequestBody Ranking ranking) {
		ranking.setId(null);
		ResponseEntity<Void> response = rankingApiService.salvar(ranking);
		return response;
	}

}
