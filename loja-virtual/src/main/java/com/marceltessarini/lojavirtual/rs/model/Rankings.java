package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.marceltessarini.lojavirtual.rs.model.Metadata;
import com.marceltessarini.lojavirtual.rs.model.Ranking;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Encapsula uma lista de rankings do produto e meta informações, tais como paginação.
 **/

/**
 * Encapsula uma lista de rankings do produto e meta informações, tais como paginação.
 */
@ApiModel(description = "Encapsula uma lista de rankings do produto e meta informações, tais como paginação.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T11:35:00.727-03:00")

public class Rankings   {
  @JsonProperty("metadata")
  private List<Metadata> metadata = new ArrayList<Metadata>();

  @JsonProperty("rankings")
  private List<Ranking> rankings = new ArrayList<Ranking>();

  public Rankings metadata(List<Metadata> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Rankings addMetadataItem(Metadata metadataItem) {
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

  public Rankings rankings(List<Ranking> rankings) {
    this.rankings = rankings;
    return this;
  }

  public Rankings addRankingsItem(Ranking rankingsItem) {
    this.rankings.add(rankingsItem);
    return this;
  }

   /**
   * Lista de rankings do produto.
   * @return rankings
  **/
  @ApiModelProperty(value = "Lista de rankings do produto.")
  public List<Ranking> getRankings() {
    return rankings;
  }

  public void setRankings(List<Ranking> rankings) {
    this.rankings = rankings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rankings rankings = (Rankings) o;
    return Objects.equals(this.metadata, rankings.metadata) &&
        Objects.equals(this.rankings, rankings.rankings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, rankings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rankings {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    rankings: ").append(toIndentedString(rankings)).append("\n");
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

