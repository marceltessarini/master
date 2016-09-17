package com.marceltessarini.lojavirtual.rs;

import com.marceltessarini.lojavirtual.rs.model.*;
import com.marceltessarini.lojavirtual.rs.CategoriasApiService;
import com.marceltessarini.lojavirtual.rs.factories.CategoriasApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import com.marceltessarini.lojavirtual.rs.model.Categorias;
import com.marceltessarini.lojavirtual.rs.model.Categoria;

import java.util.List;
import com.marceltessarini.lojavirtual.rs.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/categorias")


@io.swagger.annotations.Api(description = "the categorias API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class CategoriasApi  {
   private final CategoriasApiService delegate = CategoriasApiServiceFactory.getCategoriasApi();

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para listar categorias.", notes = "Operação utilizada para listar categorias.", response = Categorias.class, tags={ "Categorias", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Lista de categorias.", response = Categorias.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = Categorias.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Categorias.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = Categorias.class) })
    public Response categoriasGet(@ApiParam(value = "Número da página.",required=true) @QueryParam("page") String page
,@ApiParam(value = "Total de registros de uma página.",required=true) @QueryParam("limit") String limit
,@ApiParam(value = "Filtra categorias por status: ATIVO, INATIVO ou TODOS. Valor padrão é ATIVO.") @QueryParam("status") String status
,@ApiParam(value = "Filtra categorias por nome.") @QueryParam("nomeCategoria") String nomeCategoria
,@ApiParam(value = "Filtra categorias pelo nome ou descrição do produto associada a categoria.") @QueryParam("produto") String produto
,@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) da categoria  a ser ordenado. Campos disponível são: nomeCategoria.") @QueryParam("order") String order
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.categoriasGet(page,limit,status,nomeCategoria,produto,order,securityContext);
    }
    @DELETE
    @Path("/{idCategoria}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para inativar a categoria informada.", notes = "Operação utilizada para inativar a categoria informada.", response = void.class, tags={ "Categorias", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Registro inativado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class) })
    public Response categoriasIdCategoriaDelete(@ApiParam(value = "Identificador da Categoria.",required=true) @PathParam("idCategoria") String idCategoria
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.categoriasIdCategoriaDelete(idCategoria,securityContext);
    }
    @GET
    @Path("/{idCategoria}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para consultar a categoria informada.", notes = "Operação utilizada para consultar a categoria informada.", response = Categoria.class, tags={ "Categorias", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucesso.", response = Categoria.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = Categoria.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Categoria.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = Categoria.class) })
    public Response categoriasIdCategoriaGet(@ApiParam(value = "Identificador da Categoria.",required=true) @PathParam("idCategoria") String idCategoria
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.categoriasIdCategoriaGet(idCategoria,securityContext);
    }
    @PUT
    @Path("/{idCategoria}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para atualizar a categoria informada.", notes = "Operação utilizada para atualizar a categoria informada.", response = void.class, tags={ "Categorias", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Atualizado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 422, message = "Exceções de negócio.", response = void.class) })
    public Response categoriasIdCategoriaPut(@ApiParam(value = "Identificador da Categoria.",required=true) @PathParam("idCategoria") Long idCategoria
,@ApiParam(value = "" ) Categoria body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.categoriasIdCategoriaPut(idCategoria,body,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para criar uma categoria.", notes = "Operação utilizada para criar uma categoria.", response = void.class, tags={ "Categorias", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Criado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 422, message = "Exceções de negócio.", response = void.class) })
    public Response categoriasPost(@ApiParam(value = "" ) Categoria body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.categoriasPost(body,securityContext);
    }
}
