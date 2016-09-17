package com.marceltessarini.lojavirtual.rs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.StringUtils;

import com.marceltessarini.lojavirtual.rs.ApiResponseMessage;
import com.marceltessarini.lojavirtual.rs.CategoriasApiService;
import com.marceltessarini.lojavirtual.rs.NotFoundException;
import com.marceltessarini.lojavirtual.rs.codigos.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigos.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.CategoriaException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.utils.ConverterNumberUtils;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class CategoriasApiServiceImpl extends CategoriasApiService {
    @Override
    public Response categoriasGet(String page, String limit, String status, String nomeCategoria, String produto, String order, SecurityContext securityContext) throws NotFoundException {
    	// Dados fakes!
    	Categorias categoriasWrapper = null;
    	try {
			validarRequestGetCategorias(page, limit, status, nomeCategoria, produto, order);
			
			// ------------------------------------------------------
			
			simularProblemasComSeguranca(produto);

	    	// Deu tudo certo!
	    	// Vamos retornar algo agora!
	    	categoriasWrapper = criarCategoriasWrapper();
	        return Response.ok().entity(categoriasWrapper).build();

			// ------------------------------------------------------
		} catch (QueryStringException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		} catch (ApiSecurityException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		} catch (Exception e) {
			Response response = ResponseRSUtil.criarResponseHttp500();
			return response;
		}
  	
    }

    // Dados Fake!!
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

	private void simularProblemasComSeguranca(String produto) throws ApiSecurityException {
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
    
    private void validarRequestGetCategorias(String page, String limit, String status, String nomeCategoria, String produto, String order) throws QueryStringException {
    	PaginacaoUtils.validarValores(page, limit);
    	validarRequestGetCategorias(status, order);
	}
    
	private void validarRequestGetCategorias(String status, String order) throws QueryStringException {
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

	@Override
    public Response categoriasIdCategoriaDelete(String idCategoria, SecurityContext securityContext) throws NotFoundException {
        try {
			validarIdCategoria(idCategoria);

			// -----------------------------------------------------------
			// Fake!
			Long numeroCategoria = Long.parseLong(idCategoria);
			simularProblemasComCategoria(numeroCategoria);
			// ----------------------------------------------------------
			
			// Tudo certo!
			
	        return Response.status(Status.NO_CONTENT).build();
		} catch (QueryStringException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		} catch (ApiSecurityException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		} catch (Exception e) {
			Response response = ResponseRSUtil.criarResponseHttp500();
			return response;
		}
    }
	
	// eh fake!
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

	private void validarIdCategoria(String idCategoria) throws QueryStringException {
		Long idCategoriaLong = ConverterNumberUtils.toLongOrNull(idCategoria);
		
		if (idCategoriaLong == null) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_302;
			String[] parametros = {"idCategoria"};
			Erro erroHttp = CodigoAPIService.criarErro(chave, parametros);
			QueryStringException.lancarSeTiverErro(erroHttp);
		}

		
	}
	
    @Override
    public Response categoriasIdCategoriaGet(String idCategoria, SecurityContext securityContext) throws NotFoundException {
        try {
			validarIdCategoria(idCategoria);

			// -----------------------------------------------------------
			// Fake!
			Long numeroCategoria = Long.parseLong(idCategoria);
			simularProblemasComCategoria(numeroCategoria);
			// ----------------------------------------------------------
			
			// Tudo certo!
			Categoria categoria = criarCategoria(2L, 1L, "Livros de TI", "ATIVO", "Categoria Livros de TI");
	        return Response.ok().entity(categoria).build();
		} catch (QueryStringException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		} catch (ApiSecurityException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		} catch (Exception e) {
			Response response = ResponseRSUtil.criarResponseHttp500();
			return response;
		}
    }
    @Override
    public Response categoriasIdCategoriaPut(Long idCategoria, Categoria body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response categoriasPost(Categoria categoria, SecurityContext securityContext) throws NotFoundException {
    	
    	try {
			validarCriarCategoria(categoria);
	        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
		} catch (CategoriaException e) {
			Response response = ResponseRSUtil.criarResponse(e);
			return response;
		}
    	
    }

	private void validarCriarCategoria(Categoria categoria) throws CategoriaException {
		// TODO terminar de validar o que foi implementado ate aqui!
		
		String nome = categoria.getNome();
		String descricao = categoria.getDescricao();
		String status = categoria.getStatus();
		Long idCategoria = categoria.getIdCategoria();
		
		Erro erroNomeObrigatorio = null;
		Erro erroNomeMaior500 = null;
		Erro erroDescricaoObrigatorio = null;
		Erro erroIdCategoriaObrigatorio = null;
		Erro erroIdCategoriaInvalida = null;
		
		if (StringUtils.isBlank(nome)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.CATEGORIA_001_001;
			erroNomeObrigatorio = CodigoAPIService.criarErro(chaveErro, parametros);
		} else if (nome.length() > 500) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.CATEGORIA_001_002;
			erroNomeMaior500 = CodigoAPIService.criarErro(chaveErro, parametros);
		}

		if (StringUtils.isBlank(descricao)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.CATEGORIA_001_003;
			erroDescricaoObrigatorio = CodigoAPIService.criarErro(chaveErro, parametros);
		}
		
		// ------------------- FAKE simulando categoria invalida ------------------------------
		if (idCategoria != null && idCategoria == 100) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.CATEGORIA_001_004;
			erroIdCategoriaInvalida = CodigoAPIService.criarErro(chaveErro, parametros);
			
		}
		// ------------------------------------------------------------------------------------

		
		List<Erro> itensErro = new ArrayList<>();

		if (erroNomeObrigatorio != null) {
			itensErro.add(erroNomeObrigatorio);
		}

		if (erroNomeMaior500 != null) {
			itensErro.add(erroNomeMaior500);
		}

		if (erroDescricaoObrigatorio != null) {
			itensErro.add(erroDescricaoObrigatorio);
		}

		if (erroIdCategoriaInvalida != null) {
			itensErro.add(erroIdCategoriaInvalida);
		}

		CategoriaException.lancarSeTiverErros(itensErro);
		
	}
}
