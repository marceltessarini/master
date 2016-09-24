package com.marceltessarini.lojavirtual.rs.controller.produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

@Controller
public class ProdutosApiController implements ProdutosApi {

	@Autowired
	private ProdutoApiService produtoApiService;
	
	@Override
	public ResponseEntity<Produtos> produtosGet(Long page, Long limit, String nome, String descricao, String todos,
			Long idCategoria, String order) {
		GetProdutosRequest request = new GetProdutosRequest(page, limit, nome, descricao, todos, idCategoria, order);
		ResponseEntity<Produtos> produtos = produtoApiService.getProdutos(request);
		return produtos;
	}

	@Override
	public ResponseEntity<Void> produtosIdProdutoDelete(
			@ApiParam(value = "Identificador do Produto.", required = true) @PathVariable("idProduto") Long idProduto) {
		ResponseEntity<Void> response = produtoApiService.deleteProduto(idProduto);
		return response;
	}

	@Override
	public ResponseEntity<Produto> produtosIdProdutoGet(
			@ApiParam(value = "Identificador do Produto.", required = true) @PathVariable("idProduto") Long idProduto) {
		ResponseEntity<Produto> response = produtoApiService.getProdutos(idProduto);
		return response;
	}

	@Override
	public ResponseEntity<Void> produtosIdProdutoPut(
			@ApiParam(value = "Identificador do Produto.", required = true) @PathVariable("idProduto") Long idProduto,
			@Valid @RequestBody Produto body) {
		body.setId(idProduto);
		ResponseEntity<Void> response = produtoApiService.salvar(body);
		return response;
	}

	@Override
	public ResponseEntity<Rankings> produtosIdProdutoRankingGet(
			@ApiParam(value = "Identificador do Produto.", required = true) @PathVariable("idProduto") Long idProduto,
			Long page, Long limit, Integer order) {
		return produtoApiService.getRankingsDoProduto(idProduto);
	}

	@Override
	public ResponseEntity<Nota> produtosIdProdutoRankingNotasGet(
			@ApiParam(value = "Identificador do produto.", required = true) @PathVariable("idProduto") Long idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> produtosIdProdutoRankingPost(
			@ApiParam(value = "Identificador do Produto.", required = true) @PathVariable("idProduto") Long idProduto,
			@Valid @RequestBody Ranking body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> produtosPost(@Valid @RequestBody Produto body) {
		body.setId(null);
		ResponseEntity<Void> response = produtoApiService.salvar(body);
		return response;
	}

}
