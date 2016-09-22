package com.marceltessarini.lojavirtual.rs.controller.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

@Controller
public class CategoriasApiController implements CategoriasApi {
	
	@Autowired
	private CategoriaApiService categoriaApiService;

	@Override
	public ResponseEntity<Categorias> categoriasGet(Long page, Long limit, String status, String nomeCategoria,
			String produto, String order) {
		
		GetCategoriasRequest request = new GetCategoriasRequest(page, limit, status, nomeCategoria, produto, order);
		ResponseEntity<Categorias> response = categoriaApiService.getCategorias(request);
		
		return response;
	}

	@Override
	public ResponseEntity<Void> categoriasPost(@Valid @RequestBody Categoria body) {
		return categoriaApiService.salvar(body);
	}

	@Override
	public ResponseEntity<Void> categoriasIdCategoriaDelete(
			@ApiParam(value = "Identificador da Categoria.", required = true) @PathVariable("idCategoria") Long idCategoria) {
		return categoriaApiService.deleteCategoria(idCategoria);
	}

	@Override
	public ResponseEntity<Categoria> categoriasIdCategoriaGet(
			@ApiParam(value = "Identificador da Categoria.", required = true) @PathVariable("idCategoria") Long idCategoria) {
		return categoriaApiService.getCategoria(idCategoria);
	}

	@Override
	public ResponseEntity<Void> categoriasIdCategoriaPut(Long idCategoria, Categoria body) {
		// TODO Auto-generated method stub
		return null;
	}

}
