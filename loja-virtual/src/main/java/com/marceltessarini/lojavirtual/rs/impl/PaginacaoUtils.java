package com.marceltessarini.lojavirtual.rs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.marceltessarini.lojavirtual.rs.codigos.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigos.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.utils.ConverterNumberUtils;

/**
 * Utilitario para validar campos referentes à paginação e geração de metainformações sobre paginação.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 * 
 *
 */
public final class PaginacaoUtils {
	
	private PaginacaoUtils() {
		
	}
	
	public static List<Metadata> criarMetadataPaginacao(Long totalRegistros, Long page, Long limit, String url) {
		
		// DADOS FAKE NO MOMENTO!!!
		totalRegistros = 50L;
		page = 6L;
		limit = 5L;

		long indexPrimeiraPagina = 0L;
		long indexPaginaAnterior = 5L;
		long indexProximaPagina = 7L;
		long indexUltimaPagina = 10L;

		
		Metadata registros = new Metadata();
		registros.setChave("totalRegistros");
		registros.setValor(totalRegistros.toString());
		
		Metadata pageMetadata = new Metadata();
		pageMetadata.setChave("page");
		pageMetadata.setValor(page.toString());

		Metadata limitMetadata = new Metadata();
		limitMetadata.setChave("limit");
		limitMetadata.setValor(limit.toString());
		
		String linkPrimeiro = gerarLinkPaginacao(url, indexPrimeiraPagina, limit);
		Metadata primeiro = new Metadata();
		primeiro.setChave("primeiro");
		primeiro.setValor(linkPrimeiro);
		
		String linkAnterior = gerarLinkPaginacao(url, indexPaginaAnterior, limit);
		Metadata anterior = new Metadata();
		anterior.setChave("anterior");
		anterior.setValor(linkAnterior);

		String linkProximo = gerarLinkPaginacao(url, indexProximaPagina, limit);
		Metadata proximo = new Metadata();
		proximo.setChave("proximo");
		proximo.setValor(linkProximo);

		String linkUltimo = gerarLinkPaginacao(url, indexUltimaPagina, limit);
		Metadata ultimo = new Metadata();
		ultimo.setChave("ultimo");
		ultimo.setValor(linkUltimo);


		List<Metadata> metadataPaginacao = Arrays.asList(registros, pageMetadata, limitMetadata, primeiro, anterior, proximo, ultimo);
		
		return metadataPaginacao;
	}
	
	private static String gerarLinkPaginacao(String url, Long page, Long limit) {
		String dadosPaginacao = String.format("?page=%s&limit=%s", page, limit);
		StringBuilder link = new StringBuilder(url).append(dadosPaginacao);
		return link.toString();
	}
	
	/**
	 * Valida os valores de page e limit. 
	 * @param page número da página.
	 * @param limit quantidade de itens da página.
	 */
	public static void validarValores(String page, String limit) throws QueryStringException {
		List<Erro> itensErro = new ArrayList<>();

		if (StringUtils.isBlank(page)) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_303;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			itensErro.add(erro);
		}
		
		if (StringUtils.isBlank(limit)) {
			
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_305;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			itensErro.add(erro);
		}
		
		// Os parâmetros page e limit devem ser informados para se prosseguir.
		QueryStringException.lancarSeTiverErros(itensErro);
		
		// Valores informados. Validando cada um.
		
		// page
		Erro erroValorPage = validarValorPage(page);
		if (erroValorPage != null) {
			itensErro.add(erroValorPage);
		}

		// limit
		Erro erroValorLimit = validarValorLimit(limit);
		if (erroValorLimit != null) {
			itensErro.add(erroValorLimit);
		}

		QueryStringException.lancarSeTiverErros(itensErro);

		
	}

	private static Erro validarValorLimit(String limit) {
		Long numeroLimit = ConverterNumberUtils.toLongOrNull(limit);
		if (numeroLimit != null) {
			if (numeroLimit.compareTo(0L) <= 0) {
				CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_306;
				String[] parametros = null;
				
				Erro erro = CodigoAPIService.criarErro(chave, parametros);
				return erro;
			}
		} else {
			String[] parametros = {"limit"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_302;
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			return erro;
		}
		
		// Valido
		return null;
	}

	private static Erro validarValorPage(String page) {
		Long numeroPage = ConverterNumberUtils.toLongOrNull(page);
		if (numeroPage != null) {
			if (numeroPage.compareTo(0L) < 0) {
				CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_304;
				String[] parametros = null;
				
				Erro erro = CodigoAPIService.criarErro(chave, parametros);
				return erro;
			}
		} else {
			String[] parametros = {"page"};

			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_302;
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			return erro;
		}
		
		// Valido
		return null;
	}

}
