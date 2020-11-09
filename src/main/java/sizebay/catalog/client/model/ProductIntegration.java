package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductIntegration implements Serializable {

	private Long id;
	private String name;
	private char gender;
	private char feedGender;
	private String ageGroup;
	private String feedAgeGroup;
	private String permalink;
	private String image;
	private Long tenantId;
	private String feedProductId;
	private String brandName;
	private Long feedBrandId;
	private String feedBrandName;
	private String categoryName;
	private String modelingName;
	private String sizeType;
	private int availability;
	private Long strongBrandId;
	private String strongBrandName;
	private StrongCategoryType strongCategoryType;
	private Long strongCategoryId;
	private String strongCategoryName;
	private Long strongSubcategoryId;
	private String strongSubcategoryName;
	private Long strongModelId;
	private String strongModelName;
	private ClothesType clothesType;
	private List<String> sizes;
	private List<String> availableSizes;
	private double weightStyle;
	private Boolean isAccessory;
	private Boolean isShoe;
	private Boolean useStrongModeling;
	private SizeSystem sizeSystem;
	private Map<String, ModelingSizeMeasures> measures;

	public ProductBasicInformation castToProductBasicInformation() {
		ProductBasicInformation basicInfo = new ProductBasicInformation();

		basicInfo.setId(this.getId());
		basicInfo.setName(this.getName());
		basicInfo.setGenderTheWearWasDesignedFor(String.valueOf(this.gender));
		basicInfo.setAgeGroup(Product.AgeGroupEnum.valueOf(this.getAgeGroup().toUpperCase()));
		basicInfo.setPermalink(this.getPermalink());
		basicInfo.setCoverImage(this.getImage());
		basicInfo.setTenantId(this.getTenantId());
		basicInfo.setFeedProductId(this.getFeedProductId());
		basicInfo.setModelingName(this.getModelingName());
		basicInfo.setSizeType(this.getSizeType());
		basicInfo.setStatus(this.getAvailability() > 0);
		basicInfo.setStrongBrandId(this.getStrongBrandId());
		basicInfo.setStrongBrandName(this.getStrongBrandName());
		basicInfo.setStrongCategoryType(this.getStrongCategoryType());
		basicInfo.setStrongCategoryId(this.getStrongCategoryId());
		basicInfo.setStrongCategoryName(this.getStrongCategoryName());
		basicInfo.setStrongSubcategoryId(this.getStrongSubcategoryId());
		basicInfo.setStrongSubcategoryName(this.getStrongSubcategoryName());
		basicInfo.setStrongModelId(this.getStrongModelId());
		basicInfo.setStrongModelName(this.getStrongModelName());
		basicInfo.setWeightStyle(this.getWeightStyle());
		basicInfo.setAccessory(this.getIsAccessory());
		basicInfo.setIsShoe(this.getIsShoe());

		return basicInfo;
	}

}
