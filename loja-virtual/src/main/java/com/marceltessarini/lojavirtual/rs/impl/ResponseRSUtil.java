package com.marceltessarini.lojavirtual.rs.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.marceltessarini.lojavirtual.rs.codigos.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigos.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.APIException;
import com.marceltessarini.lojavirtual.rs.exception.AbstractAPIException;
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.CategoriaException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Erro;

/**
 * Classe utilitária para se gerar response da camada Rest.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public final class ResponseRSUtil {

	private ResponseRSUtil() {
		
	}
	
	public static Response criarResponseHttp500() {
		CodigoStatusAPI chave = CodigoStatusAPI.HTTP_500;
		String[] parametros = null;
		Erro erroHttp500 = CodigoAPIService.criarErro(chave, parametros);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(erroHttp500).build();
	}
	
	/**
	 * Esperado o seguinte código HTTP de  erro:
	 * 
	 * 400 - Bad request.
	 * 422 - Regras de negócio.
	 * 
	 * @param e exceção que contém a lista de erros.
	 * @return response com uma lista de erros e código HTTP de erro da lista.
	 */
	public static Response criarResponse(CategoriaException e) {
		String codigoHttp400 = "400";
		Response responseHttp400 = criarResponse(codigoHttp400, e);
		if (responseHttp400 != null) {
			return responseHttp400;
		}
		
		String codigoHttp422 = "422";
		Response responseHttp422 = criarResponse(codigoHttp422, e);
		if (responseHttp422 != null) {
			return responseHttp422;
		}

		throw new IllegalArgumentException("Ops! Código não esperado em CategoriaException.");
	}


	/**
	 * Esperado o seguinte código HTTP de  erro:
	 * 
	 * 405 - Método não permitido.
	 * 
	 * @param e exceção que contém a lista de erros.
	 * @return response com uma lista de erros e código HTTP de erro da lista.
	 */
	public static Response criarResponse(APIException e) {
		String codigoHttp405 = "405";
		Response responseHttp405 = criarResponse(codigoHttp405, e);
		if (responseHttp405 != null) {
			return responseHttp405;
		}
		throw new IllegalArgumentException("Ops! Código não esperado em APIException.");
	}

	
	/**
	 * Esperado o seguinte código HTTP de erro:
	 * 
	 * 400 - Bad Request
	 * 
	 * @param e exceção que contém a lista de erros.
	 * @return response com uma lista de erros e código HTTP de erro da lista.
	 */
	public static Response criarResponse(QueryStringException e) {
		String codigoHttp400 = "400";
		Response responseHttp400 = criarResponse(codigoHttp400, e);
		if (responseHttp400 != null) {
			return responseHttp400;
		}
		
		throw new IllegalArgumentException("Ops! Código não esperado em QueryStringException.");
	}
	
	/**
	 * Aqui são esperados os seguintes códigos HTTP de erro:
	 * 
	 * 403 - Forbidden
	 * 401 - Unauthorized
	 * 
	 * @param e exceção que contém a lista de erros.
	 * @return response com uma lista de erros e código HTTP de erro da lista.
	 */
	public static Response criarResponse(ApiSecurityException e) {
		// 403 - Forbidden 
		String codigoHttp403 = "403";
		Response response403 = criarResponse(codigoHttp403, e);
		
		if (response403 != null) {
			return response403;
		}
		
		// 401 - Unauthorized 
		String codigoHttp401 = "401";
		Response response401 = criarResponse(codigoHttp401, e);
		if (response401 != null) {
			return response401;
		}
		
		
		throw new IllegalArgumentException("Ops! Código não esperado em ApiSecurityException.");
	}
	
	private static Response criarResponse(String codigoHttp, AbstractAPIException e) {
		List<Erro> erros = e.filtarErros(codigoHttp);
		
		if (!erros.isEmpty()) {
			int codigo = Integer.parseInt(codigoHttp);
			return Response.status(codigo).entity(erros).build();
		}
		
		return null;
		
	}

}
