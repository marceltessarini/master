package com.marceltessarini.lojavirtual.rs.controller.ranking;

import com.marceltessarini.lojavirtual.rs.model.Rankings;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import com.marceltessarini.lojavirtual.rs.model.Nota;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-02T10:32:41.079-02:00")

@Api(value = "ranking", description = "the ranking API")
public interface RankingApi {

	@ApiOperation(value = "Operação utilizada para consultar os rankings do produto informado.", notes = "Operação utilizada para consultar os rankings do produto informado.", response = Rankings.class, tags = {
			"Rankings", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso.", response = Rankings.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Rankings.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Rankings.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Rankings.class) })
	@RequestMapping(value = "/ranking", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Rankings> rankingGet(
			@ApiParam(value = "Número da página.", required = true) @RequestParam(value = "page", required = true) Long page

			,
			@ApiParam(value = "Total de registros de uma página.", required = true) @RequestParam(value = "limit", required = true) Long limit

			,
			@ApiParam(value = "Identificador do produto.", required = true) @RequestParam(value = "idProduto", required = true) Long idProduto

			,
			@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) do ranking do produto  a ser ordenado. Campos disponível são: nota") @RequestParam(value = "order", required = false) Integer order

	);

	@ApiOperation(value = "Operação utilizada para se obter um ranking.", notes = "", response = Ranking.class, tags = {
			"Rankings", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso", response = Ranking.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Ranking.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Ranking.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Ranking.class),
			@ApiResponse(code = 404, message = "Recurso não encontrado.", response = Ranking.class) })
	@RequestMapping(value = "/ranking/{idRanking}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Ranking> rankingIdRankingGet(
			@ApiParam(value = "Identificador do Ranking.", required = true) @PathVariable("idRanking") Long idRanking

	);

	@ApiOperation(value = "Operação utilizada para calcular as notas do ranking do produto.", notes = "Operação utilizada para calcular as notas do ranking do produto.", response = Nota.class, tags = {
			"Rankings", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso.", response = Nota.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Nota.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Nota.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Nota.class) })
	@RequestMapping(value = "/ranking/notas/{idProduto}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Nota> rankingNotasIdProdutoGet(
			@ApiParam(value = "Identificador do produto.", required = true) @PathVariable("idProduto") Long idProduto

	);

	@ApiOperation(value = "Operação utilizada para criar um ranking do produto.", notes = "Operação utilizada para criar um ranking do produto.", response = Void.class, tags = {
			"Rankings", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Criado com sucesso.", response = Void.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Void.class) })
	@RequestMapping(value = "/ranking", consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> rankingPost(

			@ApiParam(value = "") @RequestBody Ranking body

	);

}
