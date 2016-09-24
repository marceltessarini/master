package com.marceltessarini.lojavirtual.rs.controller.produto;

import org.springframework.http.ResponseEntity;

import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Produtos;

public interface ProdutoApiService {

	ResponseEntity<Produtos> getProdutos(GetProdutosRequest request);

	ResponseEntity<Void> salvar(Produto produto);

	ResponseEntity<Void> deleteProduto(Long idProduto);

	ResponseEntity<Produto> getProdutos(Long idProduto);
	

}
