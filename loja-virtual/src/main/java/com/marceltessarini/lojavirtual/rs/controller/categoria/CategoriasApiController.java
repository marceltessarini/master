package com.marceltessarini.lojavirtual.rs.controller.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;


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
	public ResponseEntity<Void> categoriasPost(@Valid Categoria body) {
		return categoriaApiService.salvar(body);
	}

}
