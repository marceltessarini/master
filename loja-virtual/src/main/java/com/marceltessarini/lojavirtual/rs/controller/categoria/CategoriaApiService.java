package com.marceltessarini.lojavirtual.rs.controller.categoria;

import org.springframework.http.ResponseEntity;

import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Categorias;

public interface CategoriaApiService {

	ResponseEntity<Categorias> getCategorias(GetCategoriasRequest request);
	
	ResponseEntity<Void> salvar(Categoria categoria);
	
	ResponseEntity<Categoria> getCategoria(Long idCategoria);

	ResponseEntity<Void> deleteCategoria(Long idCategoria);
	
}
