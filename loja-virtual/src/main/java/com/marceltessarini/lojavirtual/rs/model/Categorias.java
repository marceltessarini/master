package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.marceltessarini.lojavirtual.rs.model.Categoria;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Encapsula uma lista de categorias e meta informações, tais como paginação.
 **/

/**
 * Encapsula uma lista de categorias e meta informações, tais como paginação.
 */
@ApiModel(description = "Encapsula uma lista de categorias e meta informações, tais como paginação.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Categorias   {
  @JsonProperty("categorias")
  private List<Categoria> categorias = new ArrayList<Categoria>();

  @JsonProperty("metadata")
  private List<Metadata> metadata = new ArrayList<Metadata>();

  public Categorias categorias(List<Categoria> categorias) {
    this.categorias = categorias;
    return this;
  }

  public Categorias addCategoriasItem(Categoria categoriasItem) {
    this.categorias.add(categoriasItem);
    return this;
  }

   /**
   * Lista de categorias.
   * @return categorias
  **/
  @ApiModelProperty(value = "Lista de categorias.")
  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public Categorias metadata(List<Metadata> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Categorias addMetadataItem(Metadata metadataItem) {
    this.metadata.add(metadataItem);
    return this;
  }

   /**
   * Informações de paginação.
   * @return metadata
  **/
  @ApiModelProperty(value = "Informações de paginação.")
  public List<Metadata> getMetadata() {
    return metadata;
  }

  public void setMetadata(List<Metadata> metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Categorias categorias = (Categorias) o;
    return Objects.equals(this.categorias, categorias.categorias) &&
        Objects.equals(this.metadata, categorias.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categorias, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Categorias {\n");
    
    sb.append("    categorias: ").append(toIndentedString(categorias)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

