package sizebay.catalog.client.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class Product   {

  private Long id;
  private String name;
  private String description;
	private String permalink;
	private Modeling.Gender gender;
	private Modeling.Gender feedGender;
	private String images;
	private Long tenantId;
	private String feedProductId;
	private Long brandId;
	private String brandName;
	private Long feedBrandId;
	private String feedBrandName;
	private Long categoryId;
	private String categoryName;
	private Long modelingId;
	private String modelingName;
	private Boolean available;
	private String sizeType;
	private Wearability wearability;
	private AgeGroupEnum ageGroup;
	private AgeGroupEnum feedAgeGroup;
  private String observation;
	private Long strongBrandId;
	private String strongBrandName;
	private Long strongTypeId;
	private String strongTypeName;
	private Long strongCategoryId;
	private String strongCategoryName;
	private Long strongSubcategoryId;
	private String strongSubcategoryName;
	private Long strongModelId;
	private String strongModelName;
	private double weightStyle;
	private List<String> barcodes;
	private int isShoe;

  private List<String> availableSizes = new ArrayList<>();
  private ImportationError importationError;

  @RequiredArgsConstructor
  public enum AgeGroupEnum {
    ADULT("adult"),
    INFANT("infant"),
    KIDS("kids"),
    NEWBORN("newborn"),
    TODDLER("toddler");

    final private String value;

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  @Deprecated
  @RequiredArgsConstructor
  public enum Wearability {
    REGULAR("regular"),
    VERYTIGHT("veryTight"),
    TIGHT("tight"),
    SLIGHTLYTIGHT("slightlyTight"),
    VERYLOOSE("veryLoose"),
    LOOSE("loose"),
    SLIGHTLYLOOSE("slightlyLoose");

    final private String value;

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

}

