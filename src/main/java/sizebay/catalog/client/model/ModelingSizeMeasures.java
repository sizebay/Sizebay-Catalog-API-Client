package sizebay.catalog.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T14:09:54.342Z")
public class ModelingSizeMeasures   {

  private String sizeName = null;
  private ModelingMeasureRange chest = null;
  private ModelingMeasureRange hip = null;
  private ModelingMeasureRange waist = null;
  private ModelingMeasureRange sleeve = null;
  private ModelingMeasureRange length = null;
  private ModelingMeasureRange insideLeg = null;
  private ModelingMeasureRange biceps = null;

  
  /**
   * Size name.
   **/
  
  @ApiModelProperty(required = true, value = "Size name.")
  @JsonProperty("sizeName")
  public String getSizeName() {
    return sizeName;
  }
  public void setSizeName(String sizeName) {
    this.sizeName = sizeName;
  }

  
  /**
   * Chest size in centimeters
   **/
  
  @ApiModelProperty(value = "Chest size in centimeters")
  @JsonProperty("chest")
  public ModelingMeasureRange getChest() {
    return chest;
  }
  public void setChest(ModelingMeasureRange chest) {
    this.chest = chest;
  }

  
  /**
   * Biceps size in centimeters
   **/
  @ApiModelProperty(required = true, value = "Biceps size in centimeters")
  @JsonProperty("biceps")
  public ModelingMeasureRange getBiceps() {
    return biceps;
  }
  public void setBiceps(ModelingMeasureRange biceps) {
    this.biceps = biceps;
  }

  /**
   * Hip size in centimeters
   **/

  @ApiModelProperty(required = true, value = "Hip size in centimeters")
  @JsonProperty("hip")
  public ModelingMeasureRange getHip() {
    return hip;
  }
  public void setHip(ModelingMeasureRange hip) {
    this.hip = hip;
  }

  
  /**
   * Waist size in centimeters
   **/
  
  @ApiModelProperty(required = true, value = "Waist size in centimeters")
  @JsonProperty("waist")
  public ModelingMeasureRange getWaist() {
    return waist;
  }
  public void setWaist(ModelingMeasureRange waist) {
    this.waist = waist;
  }

  
  /**
   * Sleeve height in centimeters
   **/
  
  @ApiModelProperty(value = "Sleeve height in centimeters")
  @JsonProperty("sleeve")
  public ModelingMeasureRange getSleeve() {
    return sleeve;
  }
  public void setSleeve(ModelingMeasureRange sleeve) {
    this.sleeve = sleeve;
  }

  
  /**
   * The body length from shoulder to the waist in centimeters.
   **/
  
  @ApiModelProperty(value = "The body length from shoulder to the waist in centimeters.")
  @JsonProperty("length")
  public ModelingMeasureRange getLength() {
    return length;
  }
  public void setLength(ModelingMeasureRange length) {
    this.length = length;
  }

  
  /**
   * Inside leg size in centimeters.
   **/
  
  @ApiModelProperty(value = "Inside leg size in centimeters.")
  @JsonProperty("insideLeg")
  public ModelingMeasureRange getInsideLeg() {
    return insideLeg;
  }
  public void setInsideLeg(ModelingMeasureRange insideLeg) {
    this.insideLeg = insideLeg;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelingSizeMeasures modelingMeasures = (ModelingSizeMeasures) o;

    return true && Objects.equals(sizeName, modelingMeasures.sizeName) &&
        Objects.equals(chest, modelingMeasures.chest) &&
        Objects.equals(hip, modelingMeasures.hip) &&
        Objects.equals(waist, modelingMeasures.waist) &&
        Objects.equals(sleeve, modelingMeasures.sleeve) &&
        Objects.equals(length, modelingMeasures.length) &&
        Objects.equals(insideLeg, modelingMeasures.insideLeg)
    ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizeName, chest, hip, waist, sleeve, length, insideLeg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelingMeasures {\n");
    
    sb.append("    sizeName: ").append(toIndentedString(sizeName)).append("\n");
    sb.append("    chest: ").append(toIndentedString(chest)).append("\n");
    sb.append("    hip: ").append(toIndentedString(hip)).append("\n");
    sb.append("    waist: ").append(toIndentedString(waist)).append("\n");
    sb.append("    sleeve: ").append(toIndentedString(sleeve)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    insideLeg: ").append(toIndentedString(insideLeg)).append("\n");
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

