package com.marceltessarini.lojavirtual.rs.exception;

import java.util.Arrays;
import java.util.List;

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


}
