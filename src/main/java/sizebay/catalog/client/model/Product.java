package sizebay.catalog.client.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-03T14:09:54.342Z")
public class Product   {
  
  private Long id = null;
  private String name = null;
  private String description = null;
  private String permalink = null;
  private Long modelingId = null;
  private Long categoryId = null;
  private String externalCategory = null;
  private Boolean available = null;
  private Boolean adultContent = null;


  public enum AgeGroupEnum {
    ADULT("adult"),
    INFANT("infant"),
    KIDS("kids"),
    NEWBORN("newborn"),
    TODDLER("toddler");

    private String value;

    AgeGroupEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private AgeGroupEnum ageGroup = null;
  private String gtin = null;
  private List<String> images = new ArrayList<String>();

  
  /**
   * Unique identifier representing a specific product. (Read only)
   **/
  
  @ApiModelProperty(value = "Unique identifier representing a specific product. (Read only)")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   * Product name.
   **/
  
  @ApiModelProperty(required = true, value = "Product name.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Product description.
   **/
  
  @ApiModelProperty(value = "Product description.")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   * URL which users can see the product at the e-commerce.
   **/
  
  @ApiModelProperty(required = true, value = "URL which users can see the product at the e-commerce.")
  @JsonProperty("permalink")
  public String getPermalink() {
    return permalink;
  }
  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  
  /**
   * The modeling identifier that will be linked to this product.
   **/
  
  @ApiModelProperty(required = true, value = "The modeling identifier that will be linked to this product.")
  @JsonProperty("modelingId")
  public Long getModelingId() {
    return modelingId;
  }
  public void setModelingId(Long modelingId) {
    this.modelingId = modelingId;
  }

  
  /**
   * The Sizebay category identifier that should be linked to this product. Note that this category_id is used only for indexing and search proposes. You can leave this field blank if you have no intent this product be indexed.
   **/
  
  @ApiModelProperty(value = "The Sizebay category identifier that should be linked to this product. Note that this category_id is used only for indexing and search proposes. You can leave this field blank if you have no intent this product be indexed.")
  @JsonProperty("categoryId")
  public Long getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  
  /**
   * The customer category description. Useful to keep track of products with the categories stores at the customer catalog.
   **/
  
  @ApiModelProperty(value = "The customer category description. Useful to keep track of products with the categories stores at the customer catalog.")
  @JsonProperty("externalCategory")
  public String getExternalCategory() {
    return externalCategory;
  }
  public void setExternalCategory(String externalCategory) {
    this.externalCategory = externalCategory;
  }

  
  /**
   * Identifies if the product is available or not for purchase.
   **/
  
  @ApiModelProperty(value = "Identifies if the product is available or not for purchase.")
  @JsonProperty("available")
  public Boolean getAvailable() {
    return available;
  }
  public void setAvailable(Boolean available) {
    this.available = available;
  }

  
  /**
   * Set to true if the item is targeted towards adults.
   **/
  
  @ApiModelProperty(value = "Set to true if the item is targeted towards adults.")
  @JsonProperty("adultContent")
  public Boolean getAdultContent() {
    return adultContent;
  }
  public void setAdultContent(Boolean adultContent) {
    this.adultContent = adultContent;
  }

  
  /**
   * Target age group of the item.
   **/
  
  @ApiModelProperty(value = "Target age group of the item.")
  @JsonProperty("ageGroup")
  public AgeGroupEnum getAgeGroup() {
    return ageGroup;
  }
  public void setAgeGroup(AgeGroupEnum ageGroup) {
    this.ageGroup = ageGroup;
  }

  
  /**
   * GTIN code of the product.
   **/
  
  @ApiModelProperty(value = "GTIN code of the product.")
  @JsonProperty("gtin")
  public String getGtin() {
    return gtin;
  }
  public void setGtin(String gtin) {
    this.gtin = gtin;
  }

  
  /**
   * Image's URL representing the product.
   **/
  
  @ApiModelProperty(value = "Image's URL representing the product.")
  @JsonProperty("images")
  public List<String> getImages() {
    return images;
  }
  public void setImages(List<String> images) {
    this.images = images;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;

    return true && Objects.equals(id, product.id) &&
        Objects.equals(name, product.name) &&
        Objects.equals(description, product.description) &&
        Objects.equals(permalink, product.permalink) &&
        Objects.equals(modelingId, product.modelingId) &&
        Objects.equals(categoryId, product.categoryId) &&
        Objects.equals(externalCategory, product.externalCategory) &&
        Objects.equals(available, product.available) &&
        Objects.equals(adultContent, product.adultContent) &&
        Objects.equals(ageGroup, product.ageGroup) &&
        Objects.equals(gtin, product.gtin) &&
        Objects.equals(images, product.images)
    ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, permalink, modelingId, categoryId, externalCategory, available, adultContent, ageGroup, gtin, images);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    permalink: ").append(toIndentedString(permalink)).append("\n");
    sb.append("    modelingId: ").append(toIndentedString(modelingId)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    externalCategory: ").append(toIndentedString(externalCategory)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    adultContent: ").append(toIndentedString(adultContent)).append("\n");
    sb.append("    ageGroup: ").append(toIndentedString(ageGroup)).append("\n");
    sb.append("    gtin: ").append(toIndentedString(gtin)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
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

