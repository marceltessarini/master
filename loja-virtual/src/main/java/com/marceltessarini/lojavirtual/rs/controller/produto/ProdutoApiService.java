package com.marceltessarini.lojavirtual.rs.controller.produto;

import org.springframework.http.ResponseEntity;

import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Produtos;

/**
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public interface ProdutoApiService {

	ResponseEntity<Produtos> getProdutos(GetProdutosRequest request);

	ResponseEntity<Void> salvar(Produto ranking);

	ResponseEntity<Void> deleteProduto(Long idProduto);

	ResponseEntity<Produto> getProduto(Long idProduto);

}
