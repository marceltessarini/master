package com.marceltessarini.lojavirtual.rs.controller.ranking;

import org.springframework.http.ResponseEntity;

import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;

public interface RankingApiService {

	ResponseEntity<Rankings> getRankingsDoProduto(RankingsDoProdutoRequest request);

	ResponseEntity<Void> salvar(Ranking ranking);

	ResponseEntity<Ranking> getRanking(Long idRanking);

	ResponseEntity<Nota> getNotasDoProduto(Long idProduto);

}
