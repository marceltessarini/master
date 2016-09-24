package com.marceltessarini.lojavirtual.rs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Representa um produto.
 **/

/**
 * Representa um produto.
 */
@ApiModel(description = "Representa um produto.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Produto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nome")
  @NotBlank(message = "PRODUTO_002_001")
  @Length(max = 500, message = "PRODUTO_002_002")
  private String nome = null;

  @JsonProperty("descricao")
  @NotBlank(message = "PRODUTO_002_003")
  private String descricao = null;

  @JsonProperty("preco")
  @NotNull(message = "PRODUTO_002_004")
  private Double preco = null;

  @JsonProperty("categorias")
  private List<Long> categorias = new ArrayList<Long>();

  public Produto categorias(List<Long> categorias) {
    this.categorias = categorias;
    return this;
  }

  public Produto addCategoriasItem(Long categoriasItem) {
    this.categorias.add(categoriasItem);
    return this;
  }

   /**
   * Categorias do produto.
   * @return categorias
  **/
  @ApiModelProperty(required = true, value = "Categorias do produto.")
  public List<Long> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Long> categorias) {
    this.categorias = categorias;
  }

  public Produto descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

   /**
   * Descrição do produto.
   * @return descricao
  **/
  @ApiModelProperty(required = true, value = "Descrição do produto.")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Produto id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador do produto.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador do produto.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Produto nome(String nome) {
    this.nome = nome;
    return this;
  }

   /**
   * Nome do produto. É único.
   * @return nome
  **/
  @ApiModelProperty(required = true, value = "Nome do produto. É único.")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto preco(Double preco) {
    this.preco = preco;
    return this;
  }

   /**
   * Preço do produto.
   * @return preco
  **/
  @ApiModelProperty(required = true, value = "Preço do produto.")
  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produto produto = (Produto) o;
    return Objects.equals(this.categorias, produto.categorias) &&
        Objects.equals(this.descricao, produto.descricao) &&
        Objects.equals(this.id, produto.id) &&
        Objects.equals(this.nome, produto.nome) &&
        Objects.equals(this.preco, produto.preco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categorias, descricao, id, nome, preco);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produto {\n");
    
    sb.append("    categorias: ").append(toIndentedString(categorias)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

