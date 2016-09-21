package com.marceltessarini.lojavirtual.rs.controller.produto;

import com.marceltessarini.lojavirtual.rs.model.Produtos;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import com.marceltessarini.lojavirtual.rs.model.Rankings;
import com.marceltessarini.lojavirtual.rs.model.Nota;
import com.marceltessarini.lojavirtual.rs.model.Ranking;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

@Api(value = "produtos", description = "the produtos API")
public interface ProdutosApi {

    @ApiOperation(value = "Operação utilizada para listar produtos.", notes = "Operação utilizada para listar produtos.", response = Produtos.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso.", response = Produtos.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Produtos.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Produtos.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Produtos.class) })
    @RequestMapping(value = "/produtos",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Produtos> produtosGet(@ApiParam(value = "Número da página.", required = true) @RequestParam(value = "page", required = true) Long page



,@ApiParam(value = "Total de registros de uma página.", required = true) @RequestParam(value = "limit", required = true) Long limit



,@ApiParam(value = "Filtra produtos por nome.") @RequestParam(value = "nome", required = false) String nome



,@ApiParam(value = "Filtra produtos por descrição.") @RequestParam(value = "descricao", required = false) String descricao



,@ApiParam(value = "Filtra produtos por nome e descrição. Se esta opção for escolhida, os filtros nome e descricao serão ignorados.") @RequestParam(value = "todos", required = false) String todos



,@ApiParam(value = "Filtra produtos da categoria informada.") @RequestParam(value = "idCategoria", required = false) Long idCategoria



,@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) do produto  a ser ordenado. Campos disponível são: nome e preco") @RequestParam(value = "order", required = false) String order



) {
        // do some magic!
        return new ResponseEntity<Produtos>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para desativar o produto informado.", notes = "Operação utilizada para desativar o produto informado.", response = Void.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Registro inativado com sucesso.", response = Void.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Void.class) })
    @RequestMapping(value = "/produtos/{idProduto}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> produtosIdProdutoDelete(
@ApiParam(value = "Identificador do Produto.",required=true ) @PathVariable("idProduto") Long idProduto


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para consultar o produto informado.", notes = "Operação utilizada para consultar o produto informado.", response = Produto.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso.", response = Produto.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Produto.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Produto.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Produto.class) })
    @RequestMapping(value = "/produtos/{idProduto}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Produto> produtosIdProdutoGet(
@ApiParam(value = "Identificador do Produto.",required=true ) @PathVariable("idProduto") Long idProduto


) {
        // do some magic!
        return new ResponseEntity<Produto>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para atualizar o produto informado.", notes = "Operação utilizada para atualizar o produto informado.", response = Void.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Atualizado com sucesso.", response = Void.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Void.class),
        @ApiResponse(code = 422, message = "Exceções de negócio.", response = Void.class) })
    @RequestMapping(value = "/produtos/{idProduto}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<Void> produtosIdProdutoPut(
@ApiParam(value = "Identificador do Produto.",required=true ) @PathVariable("idProduto") Long idProduto


,

@ApiParam(value = ""  ) @RequestBody Produto body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para consultar os rankings do produto informado.", notes = "Operação utilizada para consultar os rankings do produto informado.", response = Rankings.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso.", response = Rankings.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Rankings.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Rankings.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Rankings.class) })
    @RequestMapping(value = "/produtos/{idProduto}/ranking",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Rankings> produtosIdProdutoRankingGet(
@ApiParam(value = "Identificador do Produto.",required=true ) @PathVariable("idProduto") Long idProduto


,@ApiParam(value = "Número da página.", required = true) @RequestParam(value = "page", required = true) Long page



,@ApiParam(value = "Total de registros de uma página.", required = true) @RequestParam(value = "limit", required = true) Long limit



,@ApiParam(value = "Recebe o(s) nome(s) do(s) campo(s) do ranking do produto  a ser ordenado. Campos disponível são: nota") @RequestParam(value = "order", required = false) Integer order



) {
        // do some magic!
        return new ResponseEntity<Rankings>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para calcular as notas do ranking do produto.", notes = "Operação utilizada para calcular as notas do ranking do produto.", response = Nota.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso.", response = Nota.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Nota.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Nota.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Nota.class) })
    @RequestMapping(value = "/produtos/{idProduto}/ranking/notas",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Nota> produtosIdProdutoRankingNotasGet(
@ApiParam(value = "Identificador do produto.",required=true ) @PathVariable("idProduto") Long idProduto


) {
        // do some magic!
        return new ResponseEntity<Nota>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para criar um ranking do produto.", notes = "Operação utilizada para criar um ranking do produto.", response = Void.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Criado com sucesso.", response = Void.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Void.class) })
    @RequestMapping(value = "/produtos/{idProduto}/ranking",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> produtosIdProdutoRankingPost(
@ApiParam(value = "Identificador do Produto.",required=true ) @PathVariable("idProduto") Long idProduto


,

@ApiParam(value = ""  ) @RequestBody Ranking body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ApiOperation(value = "Operação utilizada para criar um produto.", notes = "Operação utilizada para criar um produto.", response = Void.class, tags={ "Produtos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Criado com sucesso.", response = Void.class),
        @ApiResponse(code = 400, message = "Requisição mal formada.", response = Void.class),
        @ApiResponse(code = 401, message = "Requisição requer autenticação.", response = Void.class),
        @ApiResponse(code = 403, message = "Requisição negada.", response = Void.class),
        @ApiResponse(code = 422, message = "Exceções de negócio.", response = Void.class) })
    @RequestMapping(value = "/produtos",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> produtosPost(

@ApiParam(value = ""  ) @RequestBody Produto body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
