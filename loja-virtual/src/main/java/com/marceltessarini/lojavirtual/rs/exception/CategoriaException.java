package com.marceltessarini.lojavirtual.rs.exception;

import java.util.Arrays;
import java.util.List;

import com.marceltessarini.lojavirtual.rs.model.Erro;

/**
 * Exceção para tratar regras específicas do recurso Categoria.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public class CategoriaException extends AbstractAPIRuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static void lancarSeTiverErros(List<Erro> erros) throws CategoriaException {
		if (erros != null && !erros.isEmpty()) {
			CategoriaException e = new CategoriaException();
			e.adicionarItensErro(erros);
			throw e;
		}
	}

	public static void lancarSeTiverErro(Erro erro) throws CategoriaException {
		if (erro != null) {
			List<Erro> erros = Arrays.asList(erro);
			lancarSeTiverErros(erros);
		}
	}


}
