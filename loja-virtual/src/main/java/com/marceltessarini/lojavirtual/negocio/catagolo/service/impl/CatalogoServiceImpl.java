package com.marceltessarini.lojavirtual.negocio.catagolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marceltessarini.lojavirtual.negocio.catagolo.dao.api.CatalogoDAO;
import com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria;
import com.marceltessarini.lojavirtual.negocio.catagolo.service.api.CatalogoService;

@Service
public class CatalogoServiceImpl implements CatalogoService {

	@Autowired
	private CatalogoDAO catalogoDAO;
	
	@Override
	@Transactional
	public Categoria salvar(Categoria catalogo) {
		Categoria retorno = catalogoDAO.save(catalogo);
		return retorno;
	}

}
