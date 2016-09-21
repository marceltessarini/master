package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Representa uma categoria.
 **/

/**
 * Representa uma categoria.
 */
@ApiModel(description = "Representa uma categoria.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Categoria   {
  @JsonProperty("descricao")
  private String descricao = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("idCategoria")
  private Long idCategoria = null;

  @JsonProperty("nome")
  @NotNull(message = "{CATEGORIA_001_001}")
  private String nome = null;

  @JsonProperty("status")
  private String status = null;

  public Categoria descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

   /**
   * Descrição da categoria.
   * @return descricao
  **/
  @ApiModelProperty(required = true, value = "Descrição da categoria.")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Categoria id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador da categoria.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador da categoria.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Categoria idCategoria(Long idCategoria) {
    this.idCategoria = idCategoria;
    return this;
  }

   /**
   * Identificador da categoria pai, se tiver.
   * @return idCategoria
  **/
  @ApiModelProperty(value = "Identificador da categoria pai, se tiver.")
  public Long getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Long idCategoria) {
    this.idCategoria = idCategoria;
  }

  public Categoria nome(String nome) {
    this.nome = nome;
    return this;
  }

   /**
   * Nome da categoria. É único.
   * @return nome
  **/
  @ApiModelProperty(required = true, value = "Nome da categoria. É único.")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Categoria status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status da categoria: ATIVO, INATIVO
   * @return status
  **/
  @ApiModelProperty(value = "Status da categoria: ATIVO, INATIVO")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Categoria categoria = (Categoria) o;
    return Objects.equals(this.descricao, categoria.descricao) &&
        Objects.equals(this.id, categoria.id) &&
        Objects.equals(this.idCategoria, categoria.idCategoria) &&
        Objects.equals(this.nome, categoria.nome) &&
        Objects.equals(this.status, categoria.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descricao, id, idCategoria, nome, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Categoria {\n");
    
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idCategoria: ").append(toIndentedString(idCategoria)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

