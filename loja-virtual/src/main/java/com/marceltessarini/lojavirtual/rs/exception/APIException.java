package com.marceltessarini.lojavirtual.rs.exception;

import java.util.Arrays;
import java.util.List;

import com.marceltessarini.lojavirtual.rs.model.Erro;

/**
 * Exceção para tratar os códigos HTTP de erro mais comuns:
 * 
 * 	Status - HTTP Código - Mensagem
 *	404 - 404 - Recurso não encontrado.
 *	405 - 405 - Método não permitido.
 *	415 - 415 - Tipo de mídia inválida.
 *	400 - 400.001 - O atributo solicitado não existe: NOME_DO_ATRIBUTO
 *	400 - 400.002 - Atributo informado não existe ou inválido: NOME_DO_ATRIBUTO
 *
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public class APIException extends AbstractAPIException {

	private static final long serialVersionUID = 1L;

	public static void lancarSeTiverErros(List<Erro> erros) throws APIException {
		if (erros != null && !erros.isEmpty()) {
			APIException e = new APIException();
			e.adicionarItensErro(erros);
			throw e;
		}
	}

	public static void lancarSeTiverErro(Erro erro) throws APIException {
		List<Erro> erros = Arrays.asList(erro);
		lancarSeTiverErros(erros);
	}

}
