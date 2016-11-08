package com.marceltessarini.lojavirtual.rs.controller.categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import com.marceltessarini.lojavirtual.negocio.catagolo.service.api.CatalogoService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.CategoriaException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.utils.PaginacaoUtils;

/**
 * Trata as requisições do recurso Categoria.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
@Service
@Transactional(propagation = Propagation.NEVER)
public class CategoriaApiServiceImpl implements CategoriaApiService {
	
	@Autowired
	private CatalogoService catalogoService; 

	@Override
	public ResponseEntity<Categorias> getCategorias(GetCategoriasRequest request) {
		validarGetCategoriasRequest(request);
		
		// -----------------------------
		// Simulando algum problema
		String produto = request.getProduto();
		simularProblemasComSeguranca(produto);
		// -----------------------------
		
		// Ok, deu tudo certo!
		// Enviando alguma  coisa! Dados  fake
		Categorias categorias = criarCategoriasWrapper();
		ResponseEntity<Categorias> response = new ResponseEntity<Categorias>(categorias, HttpStatus.OK);
		return response;
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
		if (!isStatusValidoParaConsulta(status)) {
			String[] parametros = {"status", "ATIVO, INATIVO ou TODOS"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_301;
			erroStatus = CodigoAPIService.criarErro(chave, parametros);
		}
		
		Erro erroOrder = null;
		if (!isOrderValida(order)) {
			String[] parametros = {"order", "nomeCategoria ou -nomeCategoria"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_301;
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

	
	private boolean isStatusValidoParaConsulta(String status) {
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
		// TODO melhorar codigo
		validarCategoria(categoria);
		
		com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria c = criarCategoria(categoria);
		
		com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria categoriaSalva;
		try {
			categoriaSalva = catalogoService.salvar(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Long idCategoriaSalva = categoriaSalva.getId();
		
		String location = "/api/loja/v1/categorias/" + idCategoriaSalva;
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Location", location);
		ResponseEntity<Void> response =  new ResponseEntity<Void>(headers, HttpStatus.CREATED);

		return response;
		
	}

	private com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria criarCategoria(Categoria categoria) {
		Long id = categoria.getId();
		String nome = categoria.getNome();
		String descricao = categoria.getDescricao();
		String status = categoria.getStatus();
		Long idCategoriaMae = categoria.getIdCategoria();
		
		com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria categoriaMae = null;
		if (idCategoriaMae != null) {
			categoriaMae = new com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria();
			categoriaMae.setId(idCategoriaMae);
		}
		
		if (status == null) {
			status = "ATIVO";
		}
		
		com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria categoriaCriada = new com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria();
		categoriaCriada.setId(id);
		categoriaCriada.setDescricao(descricao);
		categoriaCriada.setCategoriaMae(categoriaMae);
		categoriaCriada.setNome(nome);
		categoriaCriada.setStatus(status);
		
		return categoriaCriada;
	}

	private ResponseEntity<Void> atualizarCategoria(Categoria categoria) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private ResponseEntity<Void> adicionarCategoria(Categoria categoria) {
		// Fake!
		String location = "/api/loja/v1/categorias/123";
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Location", location);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	private void validarCategoria(Categoria categoria) {
		Long idCategoria = categoria.getIdCategoria();
		String nome = categoria.getNome();

		Erro erroIdCategoriaInvalido = null;
		Erro erroNomeCategoriaJaExiste = null;

		// ------------------- FAKE simulando categoria invalida ------------------------------
		
		// simulando id categoria que não existe.
		if (idCategoria != null && idCategoria == 100) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.CATEGORIA_001_004;
			erroIdCategoriaInvalido = CodigoAPIService.criarErro(chaveErro, parametros);
			
		}
		
		// simulando um nome de categoria que já existe
		if ("ferramentas".equals(nome)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.CATEGORIA_001_006;
			erroNomeCategoriaJaExiste = CodigoAPIService.criarErro(chaveErro, parametros);
		}
		// ------------------------------------------------------------------------------------
		
		List<Erro> itensErro = new ArrayList<>();
	
		if (erroIdCategoriaInvalido != null) {
			itensErro.add(erroIdCategoriaInvalido);
		}

		if (erroNomeCategoriaJaExiste != null) {
			itensErro.add(erroNomeCategoriaJaExiste);
		}
		
		CategoriaException.lancarSeTiverErros(itensErro);
		

	}

	@Override
	public ResponseEntity<Categoria> getCategoria(Long idCategoria) {
		// ----------------------------------------
		simularProblemasComCategoria(idCategoria);
		// Fake
		Categoria c2 = criarCategoria(2L, 1L, "Livros de TI", "ATIVO", "Categoria Livros de TI");
		// -----------------------------------------
		
		return new ResponseEntity<Categoria>(c2, HttpStatus.OK);
	}
	
	private void simularProblemasComCategoria(Long numeroCategoria) throws ApiSecurityException {
		List<Erro> itensErro = new ArrayList<>();
		// Simulando problemas com segurança!
		if (numeroCategoria == 403) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_403_201;
			Erro erro403 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro403);
			
		}
		
		if (numeroCategoria == 401) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_401_201;
			Erro erro401 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro401);
		}
		
		ApiSecurityException.lancarSeTiverErros(itensErro);
	}

	@Override
	public ResponseEntity<Void> deleteCategoria(Long idCategoria) {
		// --------------------------------------------
		// Fake
		simularProblemasComCategoria(idCategoria);
		// ----------------------------------------------
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
