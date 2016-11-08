package com.marceltessarini.lojavirtual.negocio.catagolo.dao.impl;

import org.springframework.stereotype.Repository;

import com.marceltessarini.lojavirtual.negocio.catagolo.dao.api.CategoriaDAO;
import com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria;
import com.marceltessarini.lojavirtual.negocio.dao.BasicRepositoryImpl;

@Repository
public class CatalogoDAOImpl extends BasicRepositoryImpl<Categoria, Long> implements CategoriaDAO {

	public CatalogoDAOImpl() {
		super(Categoria.class);
	}

	
}
