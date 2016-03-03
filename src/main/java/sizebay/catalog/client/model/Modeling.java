package sizebay.catalog.client.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T14:09:54.342Z")
public class Modeling   {
  
  private Long id = null;
  private String name = null;


  public enum Gender {
    M("M"),
    F("F");

    private String value;

    Gender(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private Gender gender = null;


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
  private Long brandId = null;
  private Long categoryId = null;
  private List<ModelingSizeMeasures> measures = new ArrayList<ModelingSizeMeasures>();

  
  /**
   * Unique identifier representing a specific modeling. (Read only)
   **/
  
  @ApiModelProperty(value = "Unique identifier representing a specific modeling. (Read only)")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
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
  public Gender getGender() {
    return gender;
  }
  public void setGender(Gender gender) {
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
  public Long getBrandId() {
    return brandId;
  }
  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }



  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("measures")
  public List<ModelingSizeMeasures> getSizeMeasures() {
    return measures;
  }
  public void setSizeMeasures(List<ModelingSizeMeasures> measures) {
    this.measures = measures;
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
        Objects.equals(measures, modeling.measures)
    ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gender, type, brandId, categoryId, measures);
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

