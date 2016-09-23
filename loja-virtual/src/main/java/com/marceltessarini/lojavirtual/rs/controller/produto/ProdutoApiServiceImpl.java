package com.marceltessarini.lojavirtual.rs.controller.produto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.utils.PaginacaoUtils;

@Service
public class ProdutoApiServiceImpl implements ProdutoApiService {

	@Override
	public ResponseEntity<Produtos> getProdutos(GetProdutosRequest request) {
		validarGetProdutosRequest(request);
		return null;
	}

	private void validarGetProdutosRequest(GetProdutosRequest request) {
    	Long page = request.getPage();
    	Long limit = request.getLimit();
		PaginacaoUtils.validarValores(page, limit);
	}

}
