package com.marceltessarini.lojavirtual.rs.controller.ranking;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-02T10:32:41.079-02:00")

@Controller
public class RankingApiController implements RankingApi {

	/**
	 * Lista os rankings de um produto.
	 */
	@Override
	public ResponseEntity<Rankings> rankingGet(Long page, Long limit, Long idProduto, Integer order) {
		return null;
	}

	/**
	 * Obtem um ranking.
	 */
	@Override
	public ResponseEntity<Ranking> rankingIdRankingGet(Long idRanking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Nota> rankingNotasIdProdutoGet(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> rankingPost(Ranking body) {
		// TODO Auto-generated method stub
		return null;
	}

}
