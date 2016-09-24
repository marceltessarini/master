package com.marceltessarini.lojavirtual.rs.exception.handler;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.AbstractAPIRuntimeException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Errors;

// TODO comentar a classe e retornar erro http 500 no final para todos caso algo sai do controle.

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Trata uma exceção lançada na API e não esperada.
	 * @param ex exceção.
	 * @param request
	 * @return response com http status 500.
	 */
	@ExceptionHandler({ Throwable.class} )
	public final ResponseEntity<Object> handleApiException(Throwable ex, WebRequest request) {
		ResponseEntity<Object> erroInterno = responseHttpStatus500();
		return erroInterno;
	}

	
	/**
	 * Trata as exceção lançadas pela API.
	 * @param ex Exceção lançada pela API.
	 * @param request
	 * @return Mensagem de erro.
	 */
	@ExceptionHandler({ AbstractAPIRuntimeException.class} )
	public final ResponseEntity<Object> handleApiException(AbstractAPIRuntimeException ex, WebRequest request) {
		ResponseEntity<Object> response = handleAbstractAPIRuntimeException(ex);
		return response;
	}
	
	
	/**
	 * Realiza o tratamento das exceções da API.
	 * 
	 * @param ex exceção da API.
	 * @return response contendo uma mensagem de erro e código do protocolo HTTP para o client.
	 */
	private ResponseEntity<Object> handleAbstractAPIRuntimeException(AbstractAPIRuntimeException ex) {
		// 403 - Forbidden
		int codigoHttp403 = 403;
		List<Erro> erros403 = ex.filtarErros(codigoHttp403);
		if (!erros403.isEmpty()) {
			Errors erroWrapper = new Errors();
			erroWrapper.setErrors(erros403);
			ResponseEntity<Object> forbidden = new ResponseEntity<Object>(erroWrapper, HttpStatus.FORBIDDEN);
			return forbidden;
		}
		
		// 401 - Unauthorized
		int codigoHttp401 = 401;
		List<Erro> erros401 = ex.filtarErros(codigoHttp401);
		if (!erros401.isEmpty()) {
			Errors erroWrapper = new Errors();
			erroWrapper.setErrors(erros401);
			ResponseEntity<Object> unauthorized = new ResponseEntity<Object>(erroWrapper, HttpStatus.UNAUTHORIZED);
			return unauthorized;
		}
	

		// Http status 400
		int codigoHttp400 = 400;
		List<Erro> erros400 = ex.filtarErros(codigoHttp400);
		if (!erros400.isEmpty()) {
			Errors erroWrapper = new Errors();
			erroWrapper.setErrors(erros400);
			ResponseEntity<Object> badRequest = new ResponseEntity<Object>(erroWrapper, HttpStatus.BAD_REQUEST);
			return badRequest;
		}
		
		// Http status 422
		int codigoHttp422 = 422;
		List<Erro> errosHttp422 = ex.filtarErros(codigoHttp422);
		if (!errosHttp422.isEmpty()) {
			Errors erroWrapper = new Errors();
			erroWrapper.setErrors(errosHttp422);
			ResponseEntity<Object> regraDeNegocio = new ResponseEntity<Object>(erroWrapper, HttpStatus.UNPROCESSABLE_ENTITY);
			return regraDeNegocio;
			
		}
		
		// Http status nao esperado, retornando Http status 500 como padrao.
		ResponseEntity<Object> erroInterno = responseHttpStatus500();
		return erroInterno;
	}


	private ResponseEntity<Object> responseHttpStatus500() {
		String[] parametros = null;
		CodigoStatusAPI chave = CodigoStatusAPI.HTTP_500;
		Erro erroStatus500 = CodigoAPIService.criarErro(chave, parametros);
		Errors erroWrapper = new Errors();
		erroWrapper.addErrorsItem(erroStatus500);
		ResponseEntity<Object> erroInterno = new ResponseEntity<Object>(erroWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
		return erroInterno;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Errors erroWrapper = extrairErros(ex);
		return new ResponseEntity<Object>(erroWrapper, HttpStatus.BAD_REQUEST);
	}

	private Errors extrairErros(MethodArgumentNotValidException ex) {
		Errors erroWrapper = new Errors();
		
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		
		for (FieldError fieldErro:fieldErrors) {
			String codigoErro = fieldErro.getDefaultMessage();
			
			CodigoStatusAPI codigoStatusAPI = CodigoAPIService.CodigoStatusAPI.getCodigoStatusAPI(codigoErro);
			String[] parametros = null;
			Erro erro = CodigoAPIService.criarErro(codigoStatusAPI, parametros);
			erroWrapper.addErrorsItem(erro);
		}
		return erroWrapper;
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String nomeParametro = ex.getName();
		Errors erroWrapper = new Errors(); 
		List<Erro> errors = erroWrapper.getErrors();
		
		if ("page".equals(nomeParametro)) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_304;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			errors.add(erro);
		}
		
		if ("limit".equals(nomeParametro)) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_306;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			errors.add(erro);
		}
		
		if ("idCategoria".equals(nomeParametro)) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_301;
			String[] parametros = {"idCategoria", "Numérico"};
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			errors.add(erro);
		}
			
		if (!errors.isEmpty()) {
			return new ResponseEntity<Object>(erroWrapper, HttpStatus.BAD_REQUEST);
		}
			
		
		// Ops, nome de parametro nao esperado!
		return null;
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String nomeParametroQueFalta = ex.getParameterName();
		String error = nomeParametroQueFalta + " parameter is missing";

//		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		// TODO o que vai fazer???
		return null;
	}

}

