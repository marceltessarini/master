package com.marceltessarini.lojavirtual.negocio.dao;

public interface CrudRepository <E, ID> {

	E get(ID id);
	
	E save(E entity);
	
	void delete(ID id);
	
}
