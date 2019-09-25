package sizebay.catalog.client.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
public class Modeling   {
  
  private Long id;
  private String name;

  private Gender gender;
  private String gMerchantBrandName;
  private String gMerchantAgeGroup;
  private String gMerchantSizeType;

  private TypeEnum type;
  private Long brandId;
  private Long categoryId;
  private List<ModelingSizeMeasures> measures = new ArrayList<>();

  private Integer strongCategoryTypeId;
  private String strongCategoryTypeName;

  private int isShoe;

  @Getter
  @RequiredArgsConstructor
  public enum TypeEnum {
    PRODUCT("product"),
    BODY("body");

    final private String value;

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  @Getter
  @RequiredArgsConstructor
  public enum Gender {
    M("M"), F("F"), U("U");

    final private String value;

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }
}

