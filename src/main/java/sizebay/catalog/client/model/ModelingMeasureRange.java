package sizebay.catalog.client.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T14:09:54.342Z")
public class ModelingMeasureRange   {
  
  private Long initialValue = null;
  private Long finalValue = null;

  
  /**
   * Initial value
   **/
  
  @ApiModelProperty(value = "Initial value")
  @JsonProperty("initialValue")
  public Long getInitialValue() {
    return initialValue;
  }
  public void setInitialValue(Long initialValue) {
    this.initialValue = initialValue;
  }

  
  /**
   * Final value
   **/
  
  @ApiModelProperty(value = "Final value")
  @JsonProperty("finalValue")
  public Long getFinalValue() {
    return finalValue;
  }
  public void setFinalValue(Long finalValue) {
    this.finalValue = finalValue;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ModelingMeasureRange modelingMeasureRange = (ModelingMeasureRange) o;

    return true && Objects.equals(initialValue, modelingMeasureRange.initialValue) &&
        Objects.equals(finalValue, modelingMeasureRange.finalValue)
    ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialValue, finalValue);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class ModelingMeasureRange {\n");
    
    sb.append("    initialValue: ").append(toIndentedString(initialValue)).append("\n");
    sb.append("    finalValue: ").append(toIndentedString(finalValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

