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
  private Long modelingId;
  private Long categoryId;
  private String externalCategory;
  private Boolean available;
  private Boolean adultContent;
  private Boolean pluginActive;
  private String gtin;
  private String sizeType;

  private Wearability wearability;
  private AgeGroupEnum ageGroup;

	private int strongBrandId;
	private String strongBrandName;
	private int strongCategoryTypeId;
	private String strongCategoryTypeName;
	private int strongCategoryId;
	private String strongCategoryName;
	private int strongSubcategoryId;
	private String strongSubcategoryName;
	private int strongModelId;
	private String strongModelName;
	private int isShoe;

  private List<String> images = new ArrayList<>();
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

