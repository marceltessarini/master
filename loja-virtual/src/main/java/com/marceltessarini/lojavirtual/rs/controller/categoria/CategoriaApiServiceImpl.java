package com.marceltessarini.lojavirtual.rs.controller.categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.GenericApiException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.utils.PaginacaoUtils;

@Service
public class CategoriaApiServiceImpl implements CategoriaApiService {

	@Override
	public ResponseEntity<Categorias> getCategorias(GetCategoriasRequest request) {
		try {
			validarGetCategoriasRequest(request);
			Categorias categorias = criarCategoriasWrapper();
			
			// -----------------------------
			// Simulando algum problema
			String produto = request.getProduto();
			simularProblemasComSeguranca(produto);
			// -----------------------------
			
			// Ok, deu tudo certo!
			// Enviando alguma  coisa! Dados  fake
			ResponseEntity<Categorias> response = new ResponseEntity<Categorias>(categorias, HttpStatus.OK);
			return response;
			
		} catch (ApiSecurityException | QueryStringException e) {
			// Apenas relançando para ser a exceção ser tratada em RestResponseEntityExceptionHandler
			throw e;
		} catch (Exception e) {
			
			String[] parametros = null;
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_500;
			Erro erro = CodigoAPIService.criarErro(chave, parametros);

			
			GenericApiException ex = new GenericApiException();
			ex.adicionarItemErro(erro);
			throw ex;
		}
	}
	
	private void simularProblemasComSeguranca(String produto) {
		List<Erro> itensErro = new ArrayList<>();
		// Simulando problemas com segurança!
		if ("403".equals(produto)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_403_201;
			Erro erro403 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro403);
			
		}
		
		if ("401".equals(produto)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_401_201;
			Erro erro401 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro401);
		}
		
		ApiSecurityException.lancarSeTiverErros(itensErro);
	}

	
	private void validarGetCategoriasRequest(GetCategoriasRequest request) {
    	Long page = request.getPage();
    	Long limit = request.getLimit();
		PaginacaoUtils.validarValores(page, limit);
		
		String status = request.getStatus();
		String order = request.getOrder();
		validarGetCategoriasRequest(status, order);
	}
	
	private void validarGetCategoriasRequest(String status, String order) throws QueryStringException {
		Erro erroStatus = null;
		if (!isStatusValido(status)) {
			String[] parametros = {"status"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_302;
			erroStatus = CodigoAPIService.criarErro(chave, parametros);
		}
		
		Erro erroOrder = null;
		if (!isOrderValida(order)) {
			String[] parametros = {"order"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_302;
			erroOrder = CodigoAPIService.criarErro(chave, parametros);
		}
		
		List<Erro> itensErro = new ArrayList<>();
		if (erroStatus != null) {
			itensErro.add(erroStatus);
		}
		
		if (erroOrder != null) {
			itensErro.add(erroOrder);
		}
		
		QueryStringException.lancarSeTiverErros(itensErro);
	}
	
	private boolean isOrderValida(String order) {
		if (StringUtils.isNotBlank(order)) {
			List<String> valoresValidos = Arrays.asList("nomeCategoria", "+nomeCategoria", "-nomeCategoria");
			String orderTrim = order.trim();
			
			boolean orderValida = valoresValidos.contains(orderTrim);
			return orderValida;
		}
		
		// Blank eh valido!
		return true;
	}

	
	private boolean isStatusValido(String status) {
		if (StringUtils.isNotBlank(status)) {
			String statusTrim = status.trim().toUpperCase();
			
			return "ATIVO".equals(statusTrim) || "INATIVO".equals(statusTrim) || "TODOS".equals(statusTrim);
		}
		
		// null eh valido!
		return true;
	}



	private Categorias criarCategoriasWrapper() {
		Categorias categoriasWrapper = new Categorias();
		
		
		Categoria c1 = criarCategoria(1L, null, "Livro", "ATIVO", "Categoria Livro");
		Categoria c2 = criarCategoria(2L, 1L, "Livros de TI", "ATIVO", "Categoria Livros de TI");
		Categoria c3 = criarCategoria(3L, null, "Eletrônicos", "ATIVO", "Categoria Eletrônicos");
		Categoria c4 = criarCategoria(4L, null, "Promoção", "ATIVO", "Categoria Promoção");
		Categoria c5 = criarCategoria(5L, null, "Roupas", "ATIVO", "Categoria Roupas");
		
		List<Categoria> categorias = categoriasWrapper.getCategorias();
		categorias.add(c1);
		categorias.add(c2);
		categorias.add(c3);
		categorias.add(c4);
		categorias.add(c5);
		
		String url = "/api/loja/v1/categorias";
		List<Metadata> paginacao = PaginacaoUtils.criarMetadataPaginacao(10L, 10L, 10L, url);
		categoriasWrapper.setMetadata(paginacao);
		
		return categoriasWrapper;
	}
	
	private Categoria criarCategoria(Long id, Long idCategoria, String nome, String status, String descricao) {
		Categoria c1 = new Categoria();
		c1.setId(id);
		c1.setIdCategoria(idCategoria);
		c1.setNome(nome);
		c1.setStatus(status);
		c1.setDescricao(descricao);
		return c1;
	}

	@Override
	public ResponseEntity<Void> salvar(Categoria categoria) {
		validarSalvarCategoria(categoria);
		// TODO retornar o id no response
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	private void validarSalvarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}



}
