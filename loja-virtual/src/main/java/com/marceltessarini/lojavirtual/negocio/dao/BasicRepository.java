package com.marceltessarini.lojavirtual.negocio.dao;

import java.io.Serializable;

public interface BasicRepository <E, ID extends Serializable> {

	E get(ID id);
	
	E save(E entity);
	
}
