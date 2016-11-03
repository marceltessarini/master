package com.marceltessarini.lojavirtual.negocio.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BasicRepositoryImpl<E, ID extends Serializable> implements BasicRepository<E, ID> {

	@PersistenceContext
	protected EntityManager em;
	
	private final Class<E> clazz;
	
	public BasicRepositoryImpl(Class<E> clazz) {
		this.clazz = clazz;
	}

	@Override
	public E get(ID id) {
		return em.find(clazz, id);
	}

	@Override
	public E save(E entity) {
		return em.merge(entity);
	}
	
}
