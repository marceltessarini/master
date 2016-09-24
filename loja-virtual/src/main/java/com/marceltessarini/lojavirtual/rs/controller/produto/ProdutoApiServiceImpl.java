package com.marceltessarini.lojavirtual.rs.controller.produto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.model.Erro;
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
		
		String order = request.getOrder();
		Erro erroOrder = null;
		if (!isOrderValida(order)) {
//			String[] parametros = {"order"};
//			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_302;
//			erroOrder = CodigoAPIService.criarErro(chave, parametros);
		}
		
	}

	private boolean isOrderValida(String order) {
		// TODO Auto-generated method stub
		return false;
	}

}
