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
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.GenericApiException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Errors;

// TODO comentar a classe e retornar erro http 500 no final para todos caso algo sai do controle.

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Trata as exceção lançadas pela API.
	 * @param ex Exceção lançada pela API.
	 * @param request
	 * @return Mensagem de erro.
	 */
	@ExceptionHandler({ QueryStringException.class, ApiSecurityException.class, GenericApiException.class })
	public final ResponseEntity<Object> handleApiException(Exception ex, WebRequest request) {
		ResponseEntity<Object> response;
		
		if (ex instanceof QueryStringException) {
			response = handleQueryStringException((QueryStringException) ex, request);
		} else if (ex instanceof ApiSecurityException) {
			response = handleApiSecurityException((ApiSecurityException) ex, request);
		} else {
			response = handleGenericApiException((GenericApiException) ex, request);
		}
		
		return response;
	}
	
	private ResponseEntity<Object> handleQueryStringException(QueryStringException ex, WebRequest request) {
		Errors erros = ex.getErrors();
		return new ResponseEntity<Object>(erros, HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<Object> handleApiSecurityException(ApiSecurityException ex, WebRequest request) {
		Errors erros = new Errors();
		// Dois códigos de status de erro esperados:
		
		// 403 - Forbidden
		int codigoHttp403 = 403;
		List<Erro> erros403 = ex.filtarErros(codigoHttp403);
		if (!erros403.isEmpty()) {
			erros.setErrors(erros403);
			return new ResponseEntity<Object>(erros, HttpStatus.FORBIDDEN);
		}
		
		// 401 - Unauthorized
		int codigoHttp401 = 401;
		List<Erro> erros401 = ex.filtarErros(codigoHttp401);
		if (!erros401.isEmpty()) {
			erros.setErrors(erros401);
			return new ResponseEntity<Object>(erros, HttpStatus.UNAUTHORIZED);
		}
	
		throw new IllegalArgumentException("Código de erro não esperado.");
	}

	private ResponseEntity<Object> handleGenericApiException(GenericApiException ex, WebRequest request) {
		Errors errors = ex.getErrors();
		return new ResponseEntity<Object>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
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

