package com.marceltessarini.lojavirtual.rs.factories;

import com.marceltessarini.lojavirtual.rs.CategoriasApiService;
import com.marceltessarini.lojavirtual.rs.impl.CategoriasApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class CategoriasApiServiceFactory {
    private final static CategoriasApiService service = new CategoriasApiServiceImpl();

    public static CategoriasApiService getCategoriasApi() {
        return service;
    }
}
