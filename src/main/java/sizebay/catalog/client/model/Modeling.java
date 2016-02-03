package sizebay.catalog.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.*;

import sizebay.catalog.client.model.ModelingMeasures;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T13:40:21.609Z")
public class Modeling   {
  
  private Integer id = null;
  private String name = null;


  public enum GenderEnum {
    M("M"),
    F("F");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private GenderEnum gender = null;


  public enum TypeEnum {
    PRODUCT("product"),
    BODY("body");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private TypeEnum type = null;
  private Integer brandId = null;
  private Integer categoryId = null;
  private List<ModelingMeasures> measures = new ArrayList<ModelingMeasures>();


  public enum WearabilityEnum {
    REGULAR("regular"),
    VERYTIGHT("veryTight"),
    TIGHT("tight"),
    SLIGHTLYTIGHT("slightlyTight"),
    VERYLOOSE("veryLoose"),
    LOOSE("loose"),
    SLIGHTLYLOOSE("slightlyLoose");

    private String value;

    WearabilityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private WearabilityEnum wearability = null;

  
  /**
   * Unique identifier representing a specific modeling. (Read only)
   **/
  
  @ApiModelProperty(value = "Unique identifier representing a specific modeling. (Read only)")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Modeling name.
   **/
  
  @ApiModelProperty(value = "Modeling name.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Gender
   **/
  
  @ApiModelProperty(value = "Gender")
  @JsonProperty("gender")
  public GenderEnum getGender() {
    return gender;
  }
  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  
  /**
   * Modeling type
   **/
  
  @ApiModelProperty(value = "Modeling type")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  
  /**
   * Defines which brand this modeling belongs.
   **/
  
  @ApiModelProperty(value = "Defines which brand this modeling belongs.")
  @JsonProperty("brandId")
  public Integer getBrandId() {
    return brandId;
  }
  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  
  /**
   * Defines which category this modeling belongs. This is important and mandatory parameter. It is used to define which mandatory 'Measure type' will be considered by the 'Sizebay Recommendation Algorithm'. If you are in doubt, you can set the id of 'Top' or 'Bottom' categories.
   **/
  
  @ApiModelProperty(value = "Defines which category this modeling belongs. This is important and mandatory parameter. It is used to define which mandatory 'Measure type' will be considered by the 'Sizebay Recommendation Algorithm'. If you are in doubt, you can set the id of 'Top' or 'Bottom' categories.")
  @JsonProperty("categoryId")
  public Integer getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("measures")
  public List<ModelingMeasures> getMeasures() {
    return measures;
  }
  public void setMeasures(List<ModelingMeasures> measures) {
    this.measures = measures;
  }

  
  /**
   * Wearability type of this modeling.
   **/
  
  @ApiModelProperty(value = "Wearability type of this modeling.")
  @JsonProperty("wearability")
  public WearabilityEnum getWearability() {
    return wearability;
  }
  public void setWearability(WearabilityEnum wearability) {
    this.wearability = wearability;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Modeling modeling = (Modeling) o;

    return true && Objects.equals(id, modeling.id) &&
        Objects.equals(name, modeling.name) &&
        Objects.equals(gender, modeling.gender) &&
        Objects.equals(type, modeling.type) &&
        Objects.equals(brandId, modeling.brandId) &&
        Objects.equals(categoryId, modeling.categoryId) &&
        Objects.equals(measures, modeling.measures) &&
        Objects.equals(wearability, modeling.wearability)
    ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gender, type, brandId, categoryId, measures, wearability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Modeling {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    measures: ").append(toIndentedString(measures)).append("\n");
    sb.append("    wearability: ").append(toIndentedString(wearability)).append("\n");
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

