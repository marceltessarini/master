package com.marceltessarini.lojavirtual.rs.controller.produto;

import org.springframework.http.ResponseEntity;

import com.marceltessarini.lojavirtual.rs.model.Produtos;

public interface ProdutoApiService {

	ResponseEntity<Produtos> getProdutos(GetProdutosRequest request);

}
