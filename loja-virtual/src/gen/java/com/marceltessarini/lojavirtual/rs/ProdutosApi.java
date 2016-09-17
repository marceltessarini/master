package com.marceltessarini.lojavirtual.rs;

import com.marceltessarini.lojavirtual.rs.model.*;
import com.marceltessarini.lojavirtual.rs.ProdutosApiService;
import com.marceltessarini.lojavirtual.rs.factories.ProdutosApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Rankings;
import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Ranking;

import java.util.List;
import com.marceltessarini.lojavirtual.rs.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/produtos")


@io.swagger.annotations.Api(description = "the produtos API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class ProdutosApi  {
   private final ProdutosApiService delegate = ProdutosApiServiceFactory.getProdutosApi();

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para listar produtos.", notes = "Operação utilizada para listar produtos.", response = Produtos.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucesso.", response = Produtos.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = Produtos.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Produtos.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = Produtos.class) })
    public Response produtosGet(@ApiParam(value = "Número da página.",required=true) @QueryParam("page") Long page
,@ApiParam(value = "Total de registros de uma página.",required=true) @QueryParam("limit") Long limit
,@ApiParam(value = "Filtra produtos por nome.") @QueryParam("nome") String nome
,@ApiParam(value = "Filtra produtos por descrição.") @QueryParam("descricao") String descricao
,@ApiParam(value = "Filtra produtos por nome e descrição. Se esta opção for escolhida, os filtros nome e descricao serão ignorados.") @QueryParam("todos") String todos
,@ApiParam(value = "Filtra produtos da categoria informada.") @QueryParam("idCategoria") Long idCategoria
,@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) do produto  a ser ordenado. Campos disponível são: nome e preco") @QueryParam("order") String order
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosGet(page,limit,nome,descricao,todos,idCategoria,order,securityContext);
    }
    @DELETE
    @Path("/{idProduto}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para desativar o produto informado.", notes = "Operação utilizada para desativar o produto informado.", response = void.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Registro inativado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class) })
    public Response produtosIdProdutoDelete(@ApiParam(value = "Identificador do Produto.",required=true) @PathParam("idProduto") Long idProduto
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosIdProdutoDelete(idProduto,securityContext);
    }
    @GET
    @Path("/{idProduto}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para consultar o produto informado.", notes = "Operação utilizada para consultar o produto informado.", response = Produto.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucesso.", response = Produto.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = Produto.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Produto.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = Produto.class) })
    public Response produtosIdProdutoGet(@ApiParam(value = "Identificador do Produto.",required=true) @PathParam("idProduto") Long idProduto
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosIdProdutoGet(idProduto,securityContext);
    }
    @PUT
    @Path("/{idProduto}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para atualizar o produto informado.", notes = "Operação utilizada para atualizar o produto informado.", response = void.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Atualizado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 422, message = "Exceções de negócio.", response = void.class) })
    public Response produtosIdProdutoPut(@ApiParam(value = "Identificador do Produto.",required=true) @PathParam("idProduto") Long idProduto
,@ApiParam(value = "" ) Produto body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosIdProdutoPut(idProduto,body,securityContext);
    }
    @GET
    @Path("/{idProduto}/ranking")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para consultar os rankings do produto informado.", notes = "Operação utilizada para consultar os rankings do produto informado.", response = Rankings.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucesso.", response = Rankings.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = Rankings.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Rankings.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = Rankings.class) })
    public Response produtosIdProdutoRankingGet(@ApiParam(value = "Identificador do Produto.",required=true) @PathParam("idProduto") Long idProduto
,@ApiParam(value = "Número da página.",required=true) @QueryParam("page") Long page
,@ApiParam(value = "Total de registros de uma página.",required=true) @QueryParam("limit") Long limit
,@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) do ranking do produto  a ser ordenado. Campos disponível são: nota") @QueryParam("order") Integer order
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosIdProdutoRankingGet(idProduto,page,limit,order,securityContext);
    }
    @GET
    @Path("/{idProduto}/ranking/notas")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para calcular as notas do ranking do produto.", notes = "Operação utilizada para calcular as notas do ranking do produto.", response = Nota.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucesso.", response = Nota.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = Nota.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Nota.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = Nota.class) })
    public Response produtosIdProdutoRankingNotasGet(@ApiParam(value = "Identificador do produto.",required=true) @PathParam("idProduto") Long idProduto
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosIdProdutoRankingNotasGet(idProduto,securityContext);
    }
    @POST
    @Path("/{idProduto}/ranking")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para criar um ranking do produto.", notes = "Operação utilizada para criar um ranking do produto.", response = void.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Criado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class) })
    public Response produtosIdProdutoRankingPost(@ApiParam(value = "Identificador do Produto.",required=true) @PathParam("idProduto") Long idProduto
,@ApiParam(value = "" ) Ranking body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosIdProdutoRankingPost(idProduto,body,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Operação utilizada para criar um produto.", notes = "Operação utilizada para criar um produto.", response = void.class, tags={ "Produtos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Criado com sucesso.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Requisição mal formada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Requisição requer autenticação.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Requisição negada.", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 422, message = "Exceções de negócio.", response = void.class) })
    public Response produtosPost(@ApiParam(value = "" ) Produto body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.produtosPost(body,securityContext);
    }
}
