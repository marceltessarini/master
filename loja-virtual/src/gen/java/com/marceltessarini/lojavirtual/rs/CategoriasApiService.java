package com.marceltessarini.lojavirtual.rs;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.marceltessarini.lojavirtual.rs.model.Categoria;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public abstract class CategoriasApiService {
    public abstract Response categoriasGet(String page,String limit,String status,String nomeCategoria,String produto,String order,SecurityContext securityContext) throws NotFoundException;
    public abstract Response categoriasIdCategoriaDelete(String idCategoria,SecurityContext securityContext) throws NotFoundException;
    public abstract Response categoriasIdCategoriaGet(String idCategoria,SecurityContext securityContext) throws NotFoundException;
    public abstract Response categoriasIdCategoriaPut(Long idCategoria,Categoria body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response categoriasPost(Categoria body,SecurityContext securityContext) throws NotFoundException;
}
