package com.marceltessarini.lojavirtual.rs.controller.categoria;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

@Api(value = "categorias", description = "the categorias API")
public interface CategoriasApi {

	@ApiOperation(value = "Operação utilizada para listar categorias.", notes = "Operação utilizada para listar categorias.", response = Categorias.class, tags = {
			"Categorias", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de categorias.", response = Categorias.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Categorias.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Categorias.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Categorias.class) })
	@RequestMapping(value = "/categorias", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Categorias> categoriasGet(
			@ApiParam(value = "Número da página.", required = true) @RequestParam(value = "page", required = true) Long page

			,
			@ApiParam(value = "Total de registros de uma página.", required = true) @RequestParam(value = "limit", required = true) Long limit

			,
			@ApiParam(value = "Filtra categorias por status: ATIVO, INATIVO ou TODOS. Valor padrão é ATIVO.")  @RequestParam(value = "status", required = false) String status

			,
			@ApiParam(value = "Filtra categorias por nome.") @RequestParam(value = "nomeCategoria", required = false) String nomeCategoria

			,
			@ApiParam(value = "Filtra categorias pelo nome ou descrição do produto associada a categoria.") @RequestParam(value = "produto", required = false) String produto

			,
			@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) da categoria  a ser ordenado. Campos disponível são: nomeCategoria.") @RequestParam(value = "order", required = false) String order

	);

	@ApiOperation(value = "Operação utilizada para inativar a categoria informada.", notes = "Operação utilizada para inativar a categoria informada.", response = Void.class, tags = {
			"Categorias", })
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Registro inativado com sucesso.", response = Void.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Void.class) })
	@RequestMapping(value = "/categorias/{idCategoria}", method = RequestMethod.DELETE)
	ResponseEntity<Void> categoriasIdCategoriaDelete(
			@ApiParam(value = "Identificador da Categoria.", required = true) @PathVariable("idCategoria") Long idCategoria

	);

	@ApiOperation(value = "Operação utilizada para consultar a categoria informada.", notes = "Operação utilizada para consultar a categoria informada.", response = Categoria.class, tags = {
			"Categorias", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso.", response = Categoria.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Categoria.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Categoria.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Categoria.class) })
	@RequestMapping(value = "/categorias/{idCategoria}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Categoria> categoriasIdCategoriaGet(
			@ApiParam(value = "Identificador da Categoria.", required = true) @PathVariable("idCategoria") Long idCategoria

	);

	@ApiOperation(value = "Operação utilizada para atualizar a categoria informada.", notes = "Operação utilizada para atualizar a categoria informada.", response = Void.class, tags = {
			"Categorias", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Atualizado com sucesso.", response = Void.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Void.class),
			@ApiResponse(code = 422, message = "Exceções de negócio.", response = Void.class) })
	@RequestMapping(value = "/categorias/{idCategoria}", consumes = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> categoriasIdCategoriaPut(
			@ApiParam(value = "Identificador da Categoria.", required = true) @PathVariable("idCategoria") Long idCategoria

			,

			@ApiParam(value = "") @RequestBody Categoria body

	);

	@ApiOperation(value = "Operação utilizada para criar uma categoria.", notes = "Operação utilizada para criar uma categoria.", response = Void.class, tags = {
			"Categorias", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Criado com sucesso.", response = Void.class),
			@ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
			@ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
			@ApiResponse(code = 403, message = "Requisição negada.", response = Void.class),
			@ApiResponse(code = 422, message = "Exceções de negócio.", response = Void.class) })
	@RequestMapping(value = "/categorias", consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> categoriasPost(

			@ApiParam(value = "") @Valid @RequestBody Categoria body

	);

}
