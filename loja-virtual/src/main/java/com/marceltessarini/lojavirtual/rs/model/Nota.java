package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Representa uma nota.
 **/

/**
 * Representa uma nota.
 */
@ApiModel(description = "Representa uma nota.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Nota   {
  @JsonProperty("maiorNota")
  private Long maiorNota = null;

  @JsonProperty("media")
  private Long media = null;

  @JsonProperty("menorNota")
  private Long menorNota = null;

  public Nota maiorNota(Long maiorNota) {
    this.maiorNota = maiorNota;
    return this;
  }

   /**
   * Maior nota do ranking.
   * @return maiorNota
  **/
  @ApiModelProperty(value = "Maior nota do ranking.")
  public Long getMaiorNota() {
    return maiorNota;
  }

  public void setMaiorNota(Long maiorNota) {
    this.maiorNota = maiorNota;
  }

  public Nota media(Long media) {
    this.media = media;
    return this;
  }

   /**
   * Média do ranking.
   * @return media
  **/
  @ApiModelProperty(value = "Média do ranking.")
  public Long getMedia() {
    return media;
  }

  public void setMedia(Long media) {
    this.media = media;
  }

  public Nota menorNota(Long menorNota) {
    this.menorNota = menorNota;
    return this;
  }

   /**
   * Menor nota do ranking.
   * @return menorNota
  **/
  @ApiModelProperty(value = "Menor nota do ranking.")
  public Long getMenorNota() {
    return menorNota;
  }

  public void setMenorNota(Long menorNota) {
    this.menorNota = menorNota;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Nota nota = (Nota) o;
    return Objects.equals(this.maiorNota, nota.maiorNota) &&
        Objects.equals(this.media, nota.media) &&
        Objects.equals(this.menorNota, nota.menorNota);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maiorNota, media, menorNota);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Nota {\n");
    
    sb.append("    maiorNota: ").append(toIndentedString(maiorNota)).append("\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    menorNota: ").append(toIndentedString(menorNota)).append("\n");
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

