package com.marceltessarini.lojavirtual.rs.controller.produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService;
import com.marceltessarini.lojavirtual.rs.codigo.CodigoAPIService.CodigoStatusAPI;
import com.marceltessarini.lojavirtual.rs.exception.ApiSecurityException;
import com.marceltessarini.lojavirtual.rs.exception.ProdutoException;
import com.marceltessarini.lojavirtual.rs.exception.QueryStringException;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Rankings;
import com.marceltessarini.lojavirtual.rs.utils.PaginacaoUtils;

@Service
public class ProdutoApiServiceImpl implements ProdutoApiService {

	@Override
	public ResponseEntity<Produtos> getProdutos(GetProdutosRequest request) {
		validarGetProdutosRequest(request);
		
		// --------------------------------------------------
		// Simulando problemas com seguranca
		Long idCategoria = request.getIdCategoria();
		simularProblemasComSeguranca(idCategoria);
		// --------------------------------------------------
		
		// Sucesso! retornando alguma coisa Fake!
		Produtos produtoWrapper = criarProdutoWrapper();
		ResponseEntity<Produtos> response = new ResponseEntity<Produtos>(produtoWrapper, HttpStatus.OK);
		return response;
	}
	
	// Fake
	private void simularProblemasComSeguranca(Long idCategoria) {
		if (idCategoria == null) {
			return;
		}
		List<Erro> itensErro = new ArrayList<>();
		// Simulando problemas com segurança!
		if (idCategoria == 403) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_403_201;
			Erro erro403 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro403);
			
		}
		
		if (idCategoria == 401) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_401_201;
			Erro erro401 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro401);
		}
		
		ApiSecurityException.lancarSeTiverErros(itensErro);
	}


	// Fake!
	private Produtos criarProdutoWrapper() {
		Produtos produtosWrapper = new Produtos();
		List<Produto> produtos = produtosWrapper.getProdutos();
		
		Produto produto1 = criarProdutos(1L, "Apreda a programar com C++", 99.99, Arrays.asList(1L, 2L), "Descrição: Apreda a programar com C++");
		Produto produto2 = criarProdutos(2L, "A revolta de Atlas", 150.00, Arrays.asList(3L), "Descrição: A revolta de Atlas");
		Produto produto3 = criarProdutos(3L, "O efeito Médici", 30.99, Arrays.asList(4L), "Descrição: O efeito Médici");
		Produto produto4 = criarProdutos(4L, "Dom Quixote", 45.00, Arrays.asList(5L), "Descrição: Dom Quixote");
		Produto produto5 = criarProdutos(5L, "Mentes perigosas. O psicopata mora ao lado", 99.99, Arrays.asList(10L), "Descrição: Mentes perigosas. O psicopata mora ao lado");
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		produtos.add(produto5);
		
		
		String url = "/api/loja/v1/produtos";
		List<Metadata> paginacao = PaginacaoUtils.criarMetadataPaginacao(10L, 10L, 10L, url);
		produtosWrapper.setMetadata(paginacao);		
		
		return produtosWrapper;
	}

	private Produto criarProdutos(Long id, String nome, Double preco, List<Long> categorias, String descricao) {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setCategorias(categorias);
		produto.setDescricao(descricao);
		return produto;
	}

	private void validarGetProdutosRequest(GetProdutosRequest request) {
    	Long page = request.getPage();
    	Long limit = request.getLimit();
		PaginacaoUtils.validarValores(page, limit);
		
		String order = request.getOrder();
		Erro erroOrder = null;
		if (!isOrderValida(order)) {
			String[] parametros = {"order", "nome, preco, -nome ou -preco"};
			CodigoStatusAPI chave = CodigoStatusAPI.HTTP_400_301;
			erroOrder = CodigoAPIService.criarErro(chave, parametros);
		}
		
		
		List<Erro> itensErro = new ArrayList<>();
		
		if (erroOrder != null) {
			itensErro.add(erroOrder);
		}
		
		QueryStringException.lancarSeTiverErros(itensErro);
	}

	private boolean isOrderValida(String order) {
		if (StringUtils.isNotBlank(order)) {
			// order por vir separado por vírgula: order=nome, preco ou somente order=nome
			String[] itensOrder = order.split(",");
			List<String> valoresValidos = Arrays.asList("nome", "+nome", "-nome", "preco", "+preco", "-preco");
			for (String itemOrder:itensOrder) {
				String orderTrim = itemOrder.trim();
				boolean orderValida = valoresValidos.contains(orderTrim);
				if (!orderValida) {
					return false;
				}
			}
		}
		
		// Blank eh valido!
		return true;
	}

	@Override
	public ResponseEntity<Void> salvar(Produto produto) {
		validarProduto(produto);

		// --------------------------------------------------------------------------
		// Fake 
		simulandoProblemasComSeguranca(produto);
		// ---------------------------------------------------------------------------

		Long idProduto = produto.getId();
		
		if (idProduto == null) {
			// Novo produto

			// Algo fake
			return adicionarProduto(produto);
		} else {
			// atualizando produto

			// Algo fake
			return atualizarProduto(produto);
		}
	}

	private ResponseEntity<Void> atualizarProduto(Produto produto) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Fake!
	private void simulandoProblemasComSeguranca(Produto produto) {
		List<Erro> itensErro = new ArrayList<>();

		String nome = produto.getNome();
		if ("403".equals(nome)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_403_201;
			Erro erro403 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro403);
		}
		
		if ("401".equals(nome)) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_401_201;
			Erro erro401 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro401);
		}
		
		
		ApiSecurityException.lancarSeTiverErros(itensErro);

	}

	private void validarProduto(Produto produto) {
		validarDadosDoProduto(produto);
		validarRegrasDeNegorio(produto);
	}
	
	private void validarRegrasDeNegorio(Produto produto) {
		Erro erroNomeJaExiste = null;
		Erro erroCategoriaNaoExistente = null;

		
		// ----------------------------------------------------
		// Fake! Simulando um nome de produto ja existente
		String nome = produto.getNome();
		if ("nome".equals(nome)) {
			String[] parametros = null;
			CodigoStatusAPI chave = CodigoStatusAPI.PRODUTO_002_008;
			erroNomeJaExiste = CodigoAPIService.criarErro(chave, parametros);
		}
		
		// Simulando uma categoria nao existente
		Long idCategoriaNaoExistente = 100L;
		List<Long> categorias = produto.getCategorias();
		if (categorias.contains(idCategoriaNaoExistente)) {
			String[] parametros = {"[100]"};
			CodigoStatusAPI chave = CodigoStatusAPI.PRODUTO_002_009;
			erroCategoriaNaoExistente = CodigoAPIService.criarErro(chave, parametros);
		}
		
		// -----------------------------------------------------

		List<Erro> itensErro = new ArrayList<>();

		
		if (erroNomeJaExiste != null) {
			itensErro.add(erroNomeJaExiste);
		}
		
		if (erroCategoriaNaoExistente != null) {
			itensErro.add(erroCategoriaNaoExistente);
		}
		
		ProdutoException.lancarSeTiverErros(itensErro);
	}
	
	private void validarDadosDoProduto(Produto produto) {
		Erro erroPrecoMenorOuIgualZero = null;
		Erro erroPrecoCasasDecimais = null;
		
		Double preco = produto.getPreco();

		// Preco deve ser maior do que zero.
		if (preco <= 0.0) {
			String[] parametros = null;
			CodigoStatusAPI chave = CodigoStatusAPI.PRODUTO_002_005;
			erroPrecoMenorOuIgualZero = CodigoAPIService.criarErro(chave, parametros);
		}
		
		// Preco deve ter ate duas casas decimais.
		if (!isValorTemAteDuasCasasDecimais(preco)) {
			String[] parametros = null;
			CodigoStatusAPI chave = CodigoStatusAPI.PRODUTO_002_006;
			erroPrecoCasasDecimais = CodigoAPIService.criarErro(chave, parametros);
		}
		
		List<Erro> itensErro = new ArrayList<>();
		
		if (erroPrecoMenorOuIgualZero != null) {
			itensErro.add(erroPrecoMenorOuIgualZero);
		}
		
		if (erroPrecoCasasDecimais != null) {
			itensErro.add(erroPrecoCasasDecimais);
		}
		

		ProdutoException.lancarSeTiverErros(itensErro);

	}
	
	private boolean isValorTemAteDuasCasasDecimais(Double valor) {
		if (valor != null) {
			String[] split = valor.toString().split("\\.");
			String casasDecimais = split[1];
			int numeroCasasDecimais = casasDecimais.length();
			return numeroCasasDecimais <= 2;
		}
		
		// Zero casas decimais!
		return true;
	}
	
	private ResponseEntity<Void> adicionarProduto(Produto produto) {
		// Fake!
		String location = "/api/loja/v1/produtos/456";
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Location", location);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteProduto(Long idProduto) {
		// -----------------------------------------------------------
		// Fake
		simmulandoProblemasComSeguranca(idProduto);
		// -----------------------------------------------------------
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	private void simmulandoProblemasComSeguranca(Long idProduto) {
		List<Erro> itensErro = new ArrayList<>();

		if (idProduto == 403) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_403_201;
			Erro erro403 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro403);
		}
		
		if (idProduto == 401) {
			String[] parametros = null;
			CodigoStatusAPI chaveErro = CodigoStatusAPI.HTTP_401_201;
			Erro erro401 = CodigoAPIService.criarErro(chaveErro, parametros);
			itensErro.add(erro401);
		}
		
		
		ApiSecurityException.lancarSeTiverErros(itensErro);
	}

	@Override
	public ResponseEntity<Produto> getProdutos(Long idProduto) {
		// -----------------------------------------------------------
		// Fake
		simmulandoProblemasComSeguranca(idProduto);
		Produto produto1 = criarProdutos(1L, "Apreda a programar com C++", 99.99, Arrays.asList(1L, 2L), "Descrição: Apreda a programar com C++");
		ResponseEntity<Produto> response = new ResponseEntity<Produto>(produto1, HttpStatus.OK);
		return response;
		// -----------------------------------------------------------
		
	}

	@Override
	public ResponseEntity<Rankings> getRankingsDoProduto(Long idProduto) {
		// -----------------------------------------------------------
		// Fake
		simmulandoProblemasComSeguranca(idProduto);
		
		Rankings rankings = criarRankings(idProduto);
		
		// -----------------------------------------------------------
		ResponseEntity<Rankings> response = new ResponseEntity<Rankings>(rankings, HttpStatus.OK);
		return response;
	}

	private Rankings criarRankings(Long idProduto) {
		Rankings rakingsWrapper = new  Rankings();
		
		List<Ranking> rankings = rakingsWrapper.getRankings();

		Ranking r1 = criarRanking(1L, idProduto, 8, "Bom livro");
		Ranking r2 = criarRanking(2L, idProduto, 1, "Ruim!");
		Ranking r3 = criarRanking(3L, idProduto, 8, "Recomendo");
		Ranking r4 = criarRanking(4L, idProduto, 5, "Razoável!");
		Ranking r5 = criarRanking(5L, idProduto, 8, "Joia!");
		
		rankings.add(r1);
		rankings.add(r2);
		rankings.add(r3);
		rankings.add(r4);
		rankings.add(r5);
		

		String url = "/api/loja/v1/produtos/" + idProduto + "/ranking";
		List<Metadata> paginacao = PaginacaoUtils.criarMetadataPaginacao(10L, 10L, 10L, url);
		rakingsWrapper.setMetadata(paginacao);		

		return rakingsWrapper;
	}

	private Ranking criarRanking(Long id, Long idProduto, Integer nota, String comentario) {
		Ranking r1 = new Ranking();
		r1.setId(id);
		r1.setIdProduto(idProduto);
		r1.setNota(nota);
		r1.setComentario(comentario);
		return r1;
	}


}
