package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Representa o ranking de um produto.
 **/

/**
 * Representa o ranking de um produto.
 */
@ApiModel(description = "Representa o ranking de um produto.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Ranking   {
  @JsonProperty("comentario")
  private String comentario = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("idProduto")
  private Long idProduto = null;

  @JsonProperty("nota")
  private Integer nota = null;

  public Ranking comentario(String comentario) {
    this.comentario = comentario;
    return this;
  }

   /**
   * Comentário do ranking.
   * @return comentario
  **/
  @ApiModelProperty(value = "Comentário do ranking.")
  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Ranking id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador do ranking.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador do ranking.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Ranking idProduto(Long idProduto) {
    this.idProduto = idProduto;
    return this;
  }

   /**
   * Produto do ranking.
   * @return idProduto
  **/
  @ApiModelProperty(required = true, value = "Produto do ranking.")
  public Long getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Long idProduto) {
    this.idProduto = idProduto;
  }

  public Ranking nota(Integer nota) {
    this.nota = nota;
    return this;
  }

   /**
   * Nota do ranking.
   * @return nota
  **/
  @ApiModelProperty(required = true, value = "Nota do ranking.")
  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ranking ranking = (Ranking) o;
    return Objects.equals(this.comentario, ranking.comentario) &&
        Objects.equals(this.id, ranking.id) &&
        Objects.equals(this.idProduto, ranking.idProduto) &&
        Objects.equals(this.nota, ranking.nota);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentario, id, idProduto, nota);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ranking {\n");
    
    sb.append("    comentario: ").append(toIndentedString(comentario)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idProduto: ").append(toIndentedString(idProduto)).append("\n");
    sb.append("    nota: ").append(toIndentedString(nota)).append("\n");
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

