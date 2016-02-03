package sizebay.catalog.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T13:40:21.609Z")
public class ModelingMeasureRange   {
  
  private BigDecimal initialValue = null;
  private BigDecimal finalValue = null;

  
  /**
   * Initial value
   **/
  
  @ApiModelProperty(value = "Initial value")
  @JsonProperty("initialValue")
  public BigDecimal getInitialValue() {
    return initialValue;
  }
  public void setInitialValue(BigDecimal initialValue) {
    this.initialValue = initialValue;
  }

  
  /**
   * Final value
   **/
  
  @ApiModelProperty(value = "Final value")
  @JsonProperty("finalValue")
  public BigDecimal getFinalValue() {
    return finalValue;
  }
  public void setFinalValue(BigDecimal finalValue) {
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
    ModelingMeasureRange modelingMeasureRange = (ModelingMeasureRange) o;

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
    StringBuilder sb = new StringBuilder();
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

