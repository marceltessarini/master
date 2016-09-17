package com.marceltessarini.lojavirtual.rs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.marceltessarini.lojavirtual.rs.model.Erro;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Lista de erros.
 **/

/**
 * Lista de erros.
 */
@ApiModel(description = "Lista de erros.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-10T11:02:48.747-03:00")
public class Errors   {
  @JsonProperty("errors")
  private List<Erro> errors = new ArrayList<Erro>();

  public Errors errors(List<Erro> errors) {
    this.errors = errors;
    return this;
  }

  public Errors addErrorsItem(Erro errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * Lista de erros.
   * @return errors
  **/
  @ApiModelProperty(value = "Lista de erros.")
  public List<Erro> getErrors() {
    return errors;
  }

  public void setErrors(List<Erro> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Errors errors = (Errors) o;
    return Objects.equals(this.errors, errors.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Errors {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

