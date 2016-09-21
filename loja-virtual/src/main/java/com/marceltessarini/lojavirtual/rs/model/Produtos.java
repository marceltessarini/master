package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.model.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Encapsula uma lista de produtos e meta informações, tais como paginação.
 **/

/**
 * Encapsula uma lista de produtos e meta informações, tais como paginação.
 */
@ApiModel(description = "Encapsula uma lista de produtos e meta informações, tais como paginação.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Produtos   {
  @JsonProperty("metadata")
  private List<Metadata> metadata = new ArrayList<Metadata>();

  @JsonProperty("produtos")
  private List<Produto> produtos = new ArrayList<Produto>();

  public Produtos metadata(List<Metadata> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Produtos addMetadataItem(Metadata metadataItem) {
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

  public Produtos produtos(List<Produto> produtos) {
    this.produtos = produtos;
    return this;
  }

  public Produtos addProdutosItem(Produto produtosItem) {
    this.produtos.add(produtosItem);
    return this;
  }

   /**
   * Lista de produtos.
   * @return produtos
  **/
  @ApiModelProperty(value = "Lista de produtos.")
  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produtos produtos = (Produtos) o;
    return Objects.equals(this.metadata, produtos.metadata) &&
        Objects.equals(this.produtos, produtos.produtos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, produtos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produtos {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    produtos: ").append(toIndentedString(produtos)).append("\n");
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

