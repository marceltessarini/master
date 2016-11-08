package com.marceltessarini.lojavirtual.negocio.catagolo.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marceltessarini.lojavirtual.negocio.catagolo.dao.api.CategoriaDAO;
import com.marceltessarini.lojavirtual.negocio.catagolo.domain.Categoria;
import com.marceltessarini.lojavirtual.negocio.catagolo.service.api.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria) {
		validandoCategoria(categoria);
		Categoria retorno = categoriaDAO.save(categoria);
		return retorno;
	}

	private void validandoCategoria(Categoria categoria) {
		Categoria categoriaMae = categoria.getCategoriaMae();
		validandoCategoriaMae(categoriaMae);
	}

	private void validandoCategoriaMae(Categoria categoriaMae) {
		if (categoriaMae != null) {
			Long idCategoriaMae = categoriaMae.getId();
			if (idCategoriaMae != null) {
				Categoria categoria = categoriaDAO.get(idCategoriaMae);
				if (categoria == null) {
					throw new EntityNotFoundException("Categoria mae " + idCategoriaMae + " nao encontrada.");
				}
			}
		}
	}

}
