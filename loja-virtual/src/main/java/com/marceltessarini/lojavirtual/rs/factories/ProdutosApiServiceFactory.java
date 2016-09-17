package com.marceltessarini.lojavirtual.rs.factories;

import com.marceltessarini.lojavirtual.rs.ProdutosApiService;
import com.marceltessarini.lojavirtual.rs.impl.ProdutosApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class ProdutosApiServiceFactory {
    private final static ProdutosApiService service = new ProdutosApiServiceImpl();

    public static ProdutosApiService getProdutosApi() {
        return service;
    }
}
