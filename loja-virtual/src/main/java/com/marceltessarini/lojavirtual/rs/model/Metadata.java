package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Representa um par de chave/valor.
 **/

/**
 * Representa um par de chave/valor.
 */
@ApiModel(description = "Representa um par de chave/valor.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Metadata   {
  @JsonProperty("chave")
  private String chave = null;

  @JsonProperty("valor")
  private String valor = null;

  public Metadata chave(String chave) {
    this.chave = chave;
    return this;
  }

   /**
   * Chave.
   * @return chave
  **/
  @ApiModelProperty(value = "Chave.")
  public String getChave() {
    return chave;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }

  public Metadata valor(String valor) {
    this.valor = valor;
    return this;
  }

   /**
   * Valor.
   * @return valor
  **/
  @ApiModelProperty(value = "Valor.")
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Metadata metadata = (Metadata) o;
    return Objects.equals(this.chave, metadata.chave) &&
        Objects.equals(this.valor, metadata.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chave, valor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metadata {\n");
    
    sb.append("    chave: ").append(toIndentedString(chave)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
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

