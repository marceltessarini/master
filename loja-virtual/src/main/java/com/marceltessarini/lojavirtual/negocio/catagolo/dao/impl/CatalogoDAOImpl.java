package com.marceltessarini.lojavirtual.negocio.catagolo.dao.impl;

import org.springframework.stereotype.Repository;

import com.marceltessarini.lojavirtual.negocio.catagolo.dao.api.CatalogoDAO;
import com.marceltessarini.lojavirtual.negocio.catagolo.domain.Catalogo;
import com.marceltessarini.lojavirtual.negocio.dao.BasicRepositoryImpl;

@Repository
public class CatalogoDAOImpl extends BasicRepositoryImpl<Catalogo, Long> implements CatalogoDAO {

	public CatalogoDAOImpl() {
		super(Catalogo.class);
	}

	
}
