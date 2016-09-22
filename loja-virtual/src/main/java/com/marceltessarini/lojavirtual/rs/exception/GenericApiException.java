package com.marceltessarini.lojavirtual.rs.exception;

import java.util.Arrays;
import java.util.List;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.model.Erro;

public class GenericApiException extends AbstractAPIRuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static void lancarSeTiverErros(List<Erro> erros) {
		if (erros != null && !erros.isEmpty()) {
			GenericApiException e = new GenericApiException();
			e.adicionarItensErro(erros);
			throw e;
		}
	}

	public static void lancarSeTiverErro(Erro erro) {
		if (erro != null) {
			List<Erro> erros = Arrays.asList(erro);
			lancarSeTiverErros(erros);
		}
	}
	
	public static GenericApiException criarGenericApiExceptionComHttpStatus500() {
		String[] parametros = null;
		CodigoStatusAPI chave = CodigoStatusAPI.HTTP_500;
		Erro erro = CodigoAPIService.criarErro(chave, parametros);

		
		GenericApiException ex = new GenericApiException();
		ex.adicionarItemErro(erro);
		return ex;
	}



}
