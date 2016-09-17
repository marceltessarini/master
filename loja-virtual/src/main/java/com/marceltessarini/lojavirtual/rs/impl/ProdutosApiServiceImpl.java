package com.marceltessarini.lojavirtual.rs.impl;

import com.marceltessarini.lojavirtual.rs.*;
import com.marceltessarini.lojavirtual.rs.model.*;

import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Rankings;
import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Ranking;

import java.util.List;
import com.marceltessarini.lojavirtual.rs.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class ProdutosApiServiceImpl extends ProdutosApiService {
    @Override
    public Response produtosGet(Long page, Long limit, String nome, String descricao, String todos, Long idCategoria, String order, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosIdProdutoDelete(Long idProduto, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosIdProdutoGet(Long idProduto, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosIdProdutoPut(Long idProduto, Produto body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosIdProdutoRankingGet(Long idProduto, Long page, Long limit, Integer order, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosIdProdutoRankingNotasGet(Long idProduto, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosIdProdutoRankingPost(Long idProduto, Ranking body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response produtosPost(Produto body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
