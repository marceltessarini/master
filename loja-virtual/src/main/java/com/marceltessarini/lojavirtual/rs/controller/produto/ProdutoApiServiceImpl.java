package com.marceltessarini.lojavirtual.rs.controller.produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.utils.PaginacaoUtils;

@Service
public class ProdutoApiServiceImpl implements ProdutoApiService {

	@Override
	public ResponseEntity<Produtos> getProdutos(GetProdutosRequest request) {
		validarGetProdutosRequest(request);
		
		// Sucesso! retornando alguma coisa Fake!
		Produtos produtoWrapper = criarProdutoWrapper();
		ResponseEntity<Produtos> response = new ResponseEntity<Produtos>(produtoWrapper, HttpStatus.OK);
		return response;
	}

	// Fake!
	private Produtos criarProdutoWrapper() {
		Produtos produtosWrapper = new Produtos();
		List<Produto> produtos = produtosWrapper.getProdutos();
		
		Produto produto1 = criarProdutos(1L, "Apreda a programar com C++", 99.99, Arrays.asList(1L, 2L), "Descrição: Apreda a programar com C++");
		Produto produto2 = criarProdutos(2L, "A revolta de Atlas", 150.00, Arrays.asList(3L), "Descrição: A revolta de Atlas");
		Produto produto3 = criarProdutos(3L, "O efeito Médici", 30.99, Arrays.asList(4L), "Descrição: O efeito Médici");
		Produto produto4 = criarProdutos(4L, "Dom Quixote", 45.00, Arrays.asList(5L), "Descrição: Dom Quixote");
		Produto produto5 = criarProdutos(5L, "Mentes perigosas. O psicopata mora ao lado", 99.99, Arrays.asList(10L), "Descrição: Mentes perigosas. O psicopata mora ao lado");
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		produtos.add(produto5);
		
		
		String url = "/api/loja/v1/produtos";
		List<Metadata> paginacao = PaginacaoUtils.criarMetadataPaginacao(10L, 10L, 10L, url);
		produtosWrapper.setMetadata(paginacao);		
		
		return produtosWrapper;
	}

	private Produto criarProdutos(Long id, String nome, Double preco, List<Long> categorias, String descricao) {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setCategorias(categorias);
		produto.setDescricao(descricao);
		return produto;
	}

	private void validarGetProdutosRequest(GetProdutosRequest request) {
    	Long page = request.getPage();
    	Long limit = request.getLimit();
		PaginacaoUtils.validarValores(page, limit);
		
		String order = request.getOrder();
		Erro erroOrder = null;
		if (!isOrderValida(order)) {
			String[] parametros = {"order", "nome, preco, -nome ou -preco"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_301;
			erroOrder = CodigoAPIService.criarErro(chave, parametros);
		}
		
		
		List<Erro> itensErro = new ArrayList<>();
		
		if (erroOrder != null) {
			itensErro.add(erroOrder);
		}
		
		QueryStringException.lancarSeTiverErros(itensErro);
	}

	private boolean isOrderValida(String order) {
		if (StringUtils.isNotBlank(order)) {
			// order por vir separado por vírgula: order=nome, preco ou somente order=nome
			String[] itensOrder = order.split(",");
			List<String> valoresValidos = Arrays.asList("nome", "+nome", "-nome", "preco", "+preco", "-preco");
			for (String itemOrder:itensOrder) {
				String orderTrim = itemOrder.trim();
				boolean orderValida = valoresValidos.contains(orderTrim);
				if (!orderValida) {
					return false;
				}
			}
		}
		
		// Blank eh valido!
		return true;
	}

}
