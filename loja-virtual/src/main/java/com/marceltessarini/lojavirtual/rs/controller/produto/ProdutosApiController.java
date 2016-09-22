package com.marceltessarini.lojavirtual.rs.controller.produto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

@Controller
public class ProdutosApiController implements ProdutosApi {

	@Override
	public ResponseEntity<Produtos> produtosGet(Long page, Long limit, String nome, String descricao, String todos,
			Long idCategoria, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> produtosIdProdutoDelete(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Produto> produtosIdProdutoGet(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> produtosIdProdutoPut(Long idProduto, Produto body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Rankings> produtosIdProdutoRankingGet(Long idProduto, Long page, Long limit, Integer order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Nota> produtosIdProdutoRankingNotasGet(Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> produtosIdProdutoRankingPost(Long idProduto, Ranking body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> produtosPost(Produto body) {
		// TODO Auto-generated method stub
		return null;
	}

}
