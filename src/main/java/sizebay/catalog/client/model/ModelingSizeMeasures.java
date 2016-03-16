package sizebay.catalog.client.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T14:09:54.342Z")
public class ModelingSizeMeasures   {
  


  public enum SizeName {
    PP("PP"),
    P("P"),
    XS("XS"),
    EP("EP"),
    S("S"),
    M("M"),
    EM("EM"),
    G("G"),
    G1("G1"),
    G2("G2"),
    G3("G3"),
    L("L"),
    EG("EG"),
    GG("GG"),
    XL("XL"),
    EGG("EGG"),
    XG("XG"),
    XGG("XGG"),
    XXL("XXL"),
    XLG("XLG"),
    GGG("GGG"),
    XXXL("XXXL"),
    XXG("XXG"),
    _1("1"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _10("10"),
    _11("11"),
    _12("12"),
    _13("13"),
    _14("14"),
    _15("15"),
    _16("16"),
    _17("17"),
    _18("18"),
    _19("19"),
    _20("20"),
    _21("21"),
    _32("32"),
    _33("33"),
    _34("34"),
    _35("35"),
    _36("36"),
    _37("37"),
    _38("38"),
    _39("39"),
    _40("40"),
    _41("41"),
    _42("42"),
    _43("43"),
    _44("44"),
    _45("45"),
    _46("46"),
    _48("48"),
    _50("50"),
    _52("52"),
    _54("54"),
    _56("56"),
    _58("58"),
    _60("60"),
    _36_1("36/1"),
    _36_2("36/2"),
    _36_3("36/3"),
    _36_4("36/4"),
    _36_5("36/5"),
    _36_6("36/6"),
    _37_1("37/1"),
    _37_2("37/2"),
    _37_3("37/3"),
    _37_4("37/4"),
    _37_5("37/5"),
    _37_6("37/6"),
    _38_1("38/1"),
    _38_2("38/2"),
    _38_3("38/3"),
    _38_4("38/4"),
    _38_5("38/5"),
    _38_6("38/6"),
    _39_1("39/1"),
    _39_2("39/2"),
    _39_3("39/3"),
    _39_4("39/4"),
    _39_5("39/5"),
    _39_6("39/6"),
    _40_1("40/1"),
    _40_2("40/2"),
    _40_3("40/3"),
    _40_4("40/4"),
    _40_5("40/5"),
    _40_6("40/6"),
    _41_1("41/1"),
    _41_2("41/2"),
    _41_3("41/3"),
    _41_4("41/4"),
    _41_5("41/5"),
    _41_6("41/6"),
    _42_1("42/1"),
    _42_2("42/2"),
    _42_3("42/3"),
    _42_4("42/4"),
    _42_5("42/5"),
    _42_6("42/6"),
    _43_1("43/1"),
    _43_2("43/2"),
    _43_3("43/3"),
    _43_4("43/4"),
    _43_5("43/5"),
    _43_6("43/6"),
    _44_1("44/1"),
    _44_2("44/2"),
    _44_3("44/3"),
    _44_4("44/4"),
    _44_5("44/5"),
    _44_6("44/6"),
    _45_1("45/1"),
    _45_2("45/2"),
    _45_3("45/3"),
    _45_4("45/4"),
    _45_5("45/5"),
    _45_6("45/6"),
    _2GG("2GG"),
    _3GG("3GG"),
    _64("64"),
    _63("63"),
    _48_48L("48/48L"),
    _50_50L("50/50L"),
    _52_52L("52/52L"),
    _56_56L("56/56L"),
    _58_58L("58/58L"),
    _1_PP("1/PP"),
    _2_P("2/P"),
    _3_M("3/M"),
    _4_G("4/G"),
    _5_GG("5/GG"),
    XXS("XXS");

    private String value;

    SizeName(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private SizeName sizeName = null;
  private ModelingMeasureRange chest = null;
  private ModelingMeasureRange hip = null;
  private ModelingMeasureRange waist = null;
  private ModelingMeasureRange sleeve = null;
  private ModelingMeasureRange length = null;
  private ModelingMeasureRange insideLeg = null;

  
  /**
   * Size name.
   **/
  
  @ApiModelProperty(required = true, value = "Size name.")
  @JsonProperty("sizeName")
  public SizeName getSizeName() {
    return sizeName;
  }
  public void setSizeName(SizeName sizeName) {
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
