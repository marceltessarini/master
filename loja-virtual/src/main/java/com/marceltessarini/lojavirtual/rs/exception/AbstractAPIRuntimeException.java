package com.marceltessarini.lojavirtual.rs.exception;

import java.util.List;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Errors;

public abstract class AbstractAPIRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Errors errors = new Errors();
	
	public void adicionarItemErro(Erro itemErro) {
		errors.addErrorsItem(itemErro);
	}

	public void adicionarItensErro(List<Erro> itensErro) {
		for (Erro erro:itensErro) {
			adicionarItemErro(erro);
		}
	}

	public Errors getErrors() {
		return errors;
	}
	
	public List<Erro> filtarErros(int codigoHttp) {
		List<Erro> erros = errors.getErrors();
		
		List<Erro> filtrado = CodigoAPIService.filtar(erros, codigoHttp);
		
		return filtrado;
	}

	@Override
	public String toString() {
		return "AbstractAPIRuntimeException [errors=" + errors + "]";
	}


}
