package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Estrutura que descreve um erro da API.
 **/

/**
 * Estrutura que descreve um erro da API.
 */
@ApiModel(description = "Estrutura que descreve um erro da API.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Erro   {
  @JsonProperty("codigoDaAPI")
  private String codigoDaAPI = null;

  @JsonProperty("codigoHttp")
  private Integer codigoHttp = null;

  @JsonProperty("mensagem")
  private String mensagem = null;

  @JsonProperty("tipo")
  private String tipo = null;

  public Erro codigoDaAPI(String codigoDaAPI) {
    this.codigoDaAPI = codigoDaAPI;
    return this;
  }

   /**
   * Código do erro da API.
   * @return codigoDaAPI
  **/
  @ApiModelProperty(value = "Código do erro da API.")
  public String getCodigoDaAPI() {
    return codigoDaAPI;
  }

  public void setCodigoDaAPI(String codigoDaAPI) {
    this.codigoDaAPI = codigoDaAPI;
  }

  public Erro codigoHttp(Integer codigoHttp) {
    this.codigoHttp = codigoHttp;
    return this;
  }

   /**
   * Código de erro do protocolo HTTP.
   * @return codigoHttp
  **/
  @ApiModelProperty(value = "Código de erro do protocolo HTTP.")
  public Integer getCodigoHttp() {
    return codigoHttp;
  }

  public void setCodigoHttp(Integer codigoHttp) {
    this.codigoHttp = codigoHttp;
  }

  public Erro mensagem(String mensagem) {
    this.mensagem = mensagem;
    return this;
  }

   /**
   * Mensagem do erro.
   * @return mensagem
  **/
  @ApiModelProperty(value = "Mensagem do erro.")
  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public Erro tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

   /**
   * Tipo do erro.
   * @return tipo
  **/
  @ApiModelProperty(value = "Tipo do erro.")
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Erro erro = (Erro) o;
    return Objects.equals(this.codigoDaAPI, erro.codigoDaAPI) &&
        Objects.equals(this.codigoHttp, erro.codigoHttp) &&
        Objects.equals(this.mensagem, erro.mensagem) &&
        Objects.equals(this.tipo, erro.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoDaAPI, codigoHttp, mensagem, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Erro {\n");
    
    sb.append("    codigoDaAPI: ").append(toIndentedString(codigoDaAPI)).append("\n");
    sb.append("    codigoHttp: ").append(toIndentedString(codigoHttp)).append("\n");
    sb.append("    mensagem: ").append(toIndentedString(mensagem)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

