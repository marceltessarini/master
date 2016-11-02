package com.marceltessarini.lojavirtual.rs.codigo;

import java.util.ArrayList;
import java.util.List;

import com.marceltessarini.lojavirtual.rs.model.Erro;

/**
 * Códigos de erro da camada Rest.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public class CodigoAPIService {

	public enum CodigoStatusAPI {
		// GenericApiException
		HTTP_500,
		
		// APIException
		HTTP_404, HTTP_405, HTTP_415, HTTP_400_101, HTTP_400_102,
		
		// ApiSecurityException
		HTTP_403_201, HTTP_401_201,
		
		// QueryStringException
		HTTP_400_301, HTTP_400_302, HTTP_400_303, HTTP_400_304, HTTP_400_305, HTTP_400_306,
		
		// CategoriaException
		CATEGORIA_001_001,
		CATEGORIA_001_002,
		CATEGORIA_001_003,
		CATEGORIA_001_004,
		CATEGORIA_001_005,
		CATEGORIA_001_006,
		
		// ProdutoException
		PRODUTO_002_001,
		PRODUTO_002_002,
		PRODUTO_002_003,
		PRODUTO_002_004,
		PRODUTO_002_005,
		PRODUTO_002_006,
		PRODUTO_002_007,
		PRODUTO_002_008,
		PRODUTO_002_009,
		// TODO remover
		RANKING_002_010,
		RANKING_002_011,
		RANKING_002_012,
		
		// RankingException
		RANKING_003_001,
		RANKING_003_002,
		RANKING_003_003;
		
		public static CodigoStatusAPI getCodigoStatusAPI(String codigo) {
			CodigoStatusAPI[] values = CodigoStatusAPI.values();
			for (CodigoStatusAPI value:values) {
				if (value.toString().equals(codigo)) {
					return value;
				}
			}
			throw new IllegalArgumentException("Código não esperado: " + codigo);
		}

	}
	
	public static List<Erro> filtar(List<Erro> erros, int codigoHttp) {
		List<Erro> filtrado = new ArrayList<>();
		
		for (Erro erro:erros) {
			int codigo = erro.getCodigoHttp();
			if (codigo == codigoHttp) {
				filtrado.add(erro);
			}
		}
		
		return filtrado;
	}
	
	public static Erro criarErro(CodigoStatusAPI chave, String[] parametros) {

		Integer codigoHttp = null;
		String codigoDaAPI = null;
		String mensagem = null;
		String tipo = null;
		
		switch (chave) {
		
		// GenericApiException
		case HTTP_500:
			codigoHttp = 500;
			codigoDaAPI = "500";
			mensagem = "Erro no servidor.";
			tipo = "GenericApiException";
			break;

		// APIException
		case HTTP_404:
			codigoHttp = 404;
			codigoDaAPI = "404";
			mensagem = "Recurso não encontrado.";
			tipo = "APIException";
			break;

		case HTTP_405:
			codigoHttp = 405;
			codigoDaAPI = "405";
			mensagem = "Método não permitido.";
			tipo = "APIException";
			break;

		case HTTP_415:
			codigoHttp = 415;
			codigoDaAPI = "415";
			mensagem = "Tipo de mídia inválida.";
			tipo = "APIException";
			break;

		case HTTP_400_101:
			// O atributo solicitado não existe: NOME_DO_ATRIBUTO.
			validarParametros(CodigoStatusAPI.HTTP_400_101, parametros);
			codigoHttp = 400;
			codigoDaAPI = "400.101";
			String nomeAtributoAPI = parametros[0];
			mensagem = String.format("O atributo solicitado não existe: '%s'.", nomeAtributoAPI);
			tipo = "APIException";
			break;

		case HTTP_400_102:
			// Atributo informado não existe ou inválido: NOME_DO_ATRIBUTO.
			validarParametros(CodigoStatusAPI.HTTP_400_102, parametros);
			codigoHttp = 400;
			codigoDaAPI = "400.102";
			String nomeAtributoAP2 = parametros[0];
			mensagem = String.format("Atributo informado não existe ou inválido: '%s'.", nomeAtributoAP2);
			tipo = "APIException";
			break;

		// ApiSecurityException
		case HTTP_403_201:
			codigoHttp = 403;
			codigoDaAPI = "403.201";
			mensagem = "Requisição negada. Sem permissão para acessar o recurso.";
			tipo = "ApiSecurityException";
			break;

		case HTTP_401_201:
			codigoHttp = 401;
			codigoDaAPI = "401.201";
			mensagem = "Acesso negado. Requisição requer autenticação.";
			tipo = "ApiSecurityException";
			break;

		// QueryStringException
		case HTTP_400_301:
			codigoHttp = 400;
			codigoDaAPI = "400.301";
			String nomeAtributo3 = parametros[0];
			String pattern = parametros[1];
			mensagem = String.format("Parâmetro com formato incorreto. Para o parâmetro '%s' o formato correto é '%s'.", nomeAtributo3, pattern);
			tipo = "QueryStringException";
			break;

		case HTTP_400_302:
			codigoHttp = 400;
			codigoDaAPI = "400.302";
			String nomeAtributo4 = parametros[0];
			mensagem = String.format("Parâmetro não informado ou inválido : '%s'.", nomeAtributo4);
			tipo = "QueryStringException";
			break;

		case HTTP_400_303:
			codigoHttp = 400;
			codigoDaAPI = "400.303";
			mensagem = "Parâmetro de queryString page é obrigatório.";
			tipo = "QueryStringException";
			break;

		case HTTP_400_304:
			codigoHttp = 400;
			codigoDaAPI = "400.304";
			mensagem = "Parâmetro de queryString page deve ser inteiro e positivo.";
			tipo = "QueryStringException";
			break;

		case HTTP_400_305:
			codigoHttp = 400;
			codigoDaAPI = "400.305";
			mensagem = "Parâmetro de queryString limit é obrigatório.";
			tipo = "QueryStringException";
			break;

		case HTTP_400_306:
			codigoHttp = 400;
			codigoDaAPI = "400.306";
			mensagem = "Parâmetro de queryString limit deve ser inteiro e positivo.";
			tipo = "QueryStringException";
			break;

		// CategoriaException
		case CATEGORIA_001_001:
			codigoHttp = 400;
			codigoDaAPI = "001.001";
			mensagem = "Campo nome é obrigatório.";
			tipo = "CategoriaException";
			break;

		case CATEGORIA_001_002:
			codigoHttp = 400;
			codigoDaAPI = "001.002";
			mensagem = "O campo nome deve ter até 500 caracteres.";
			tipo = "CategoriaException";
			break;

		case CATEGORIA_001_003:
			codigoHttp = 400;
			codigoDaAPI = "001.003";
			mensagem = "Campo descricao é obrigatório.";
			tipo = "CategoriaException";
			break;

		case CATEGORIA_001_004:
			codigoHttp = 400;
			codigoDaAPI = "001.004";
			mensagem = "Campo idCategoria informado não existe.";
			tipo = "CategoriaException";
			break;



		case CATEGORIA_001_005:
			codigoHttp = 400;
			codigoDaAPI = "001.005";
			mensagem = "Campo status deve ser ATIVO ou INATIVO.";
			tipo = "CategoriaException";
			break;

		case CATEGORIA_001_006:
			codigoHttp = 422;
			codigoDaAPI = "001.006";
			mensagem = "Já existe uma categoria com o nome informado.";
			tipo = "CategoriaException";
			break;

		// ProdutoException
		case PRODUTO_002_001:
			codigoHttp = 400;
			codigoDaAPI = "002.001";
			mensagem = "O campo nome é obrigatório.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_002:
			codigoHttp = 400;
			codigoDaAPI = "002.002";
			mensagem = "O campo nome deve ter até 500 caracteres.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_003:
			codigoHttp = 400;
			codigoDaAPI = "002.003";
			mensagem = "O campo descrição é obrigatório.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_004:
			codigoHttp = 400;
			codigoDaAPI = "002.004";
			mensagem = "O campo preco é obrigatório.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_005:
			codigoHttp = 400;
			codigoDaAPI = "002.005";
			mensagem = "O campo preco deve ser maior do que zero.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_006:
			codigoHttp = 400;
			codigoDaAPI = "002.006";
			mensagem = "O campo preco deve ter até duas casas decimais.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_007:
			codigoHttp = 400;
			codigoDaAPI = "002.007";
			mensagem = "Deve-se informar ao mesmo uma categoria do produto.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_008:
			codigoHttp = 422;
			codigoDaAPI = "002.008";
			mensagem = "Já existe um produto com o nome informado.";
			tipo = "ProdutoException";
			break;

		case PRODUTO_002_009:
			codigoHttp = 422;
			codigoDaAPI = "002.009";
			String categoriasNaoExistentes = parametros[0];
			mensagem = String.format("A(s) categoria(s) '%s' informada(s) não existe(m).", categoriasNaoExistentes);
			tipo = "ProdutoException";
			break;

		case RANKING_002_010:
			codigoHttp = 422;
			codigoDaAPI = "002.010";
			mensagem = "O valor da nota do ranking deve estar entre 0 e 10.";
			tipo = "ProdutoException";
			break;

		case RANKING_002_011:
			codigoHttp = 400;
			codigoDaAPI = "002.011";
			mensagem = "O campo nota do ranking é obrigatório.";
			tipo = "ProdutoException";
			break;

		case RANKING_002_012:
			codigoHttp = 422;
			codigoDaAPI = "002.012";
			mensagem = "O campo idProduto informado não existe.";
			tipo = "ProdutoException";
			break;
			
		case RANKING_003_001:
			codigoHttp = 400;
			codigoDaAPI = "003.001";
			mensagem = "O campo nota do ranking é obrigatório.";
			tipo = "RankingException";
			break;

		case RANKING_003_002:
			codigoHttp = 422;
			codigoDaAPI = "003.002";
			mensagem = "O valor da nota do ranking deve estar entre 0 e 10.";
			tipo = "RankingException";
			break;

		case RANKING_003_003:
			codigoHttp = 422;
			codigoDaAPI = "003.003";
			mensagem = "O campo idProduto informado não existe.";
			tipo = "RankingException";
			break;

		default:
			throw new IllegalArgumentException("Código da API não esperadao: " + chave);
		}

		Erro erro = new Erro();
		erro.setCodigoDaAPI(codigoDaAPI);
		erro.setCodigoHttp(codigoHttp);
		erro.setMensagem(mensagem);
		erro.setTipo(tipo);
		
		return erro;
	}

	private static void validarParametros(CodigoStatusAPI codigoStatus, String[] parametros) {
		if (parametros == null || parametros.length == 0) {
			throw new IllegalArgumentException("Nenhum parâmetro informado para o código: " + codigoStatus);
		}	
	}
	
}
