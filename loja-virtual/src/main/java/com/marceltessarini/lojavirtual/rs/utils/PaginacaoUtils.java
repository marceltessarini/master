package com.marceltessarini.lojavirtual.rs.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;

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
	
	/**
	 * Valida os valores de page e limit. 
	 * @param page número da página.
	 * @param limit quantidade de itens da página.
	 */
	public static void validarValores(Long page, Long limit) {
		List<Erro> itensErro = new ArrayList<>();

		if (page == null) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_303;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			itensErro.add(erro);
		}
		
		if (limit == null) {
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

	
	private static Erro validarValorLimit(long limit) {
		if (limit <= 0) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_306;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			return erro;
		}
		return null;
	}

	private static Erro validarValorPage(long page) {
		if (page < 0) {
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_304;
			String[] parametros = null;
			
			Erro erro = CodigoAPIService.criarErro(chave, parametros);
			return erro;
		}
		return null;
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
	
}
