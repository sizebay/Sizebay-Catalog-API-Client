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
	private String ageGroup;
	private String permalink;
	private String image;
	private Long tenantId;
	private String feedProductId;
	private String brandName;
	private String categoryName;
	private String modelingName;
	private String sizeType;
	private int availability;
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
	private List<String> sizes;
	private List<String> availableSizes;
	private double weightStyle;
	private int isAccessory;
	private int isShoe;
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
		basicInfo.setStrongTypeId(this.getStrongTypeId());
		basicInfo.setStrongTypeName(this.getStrongTypeName());
		basicInfo.setStrongCategoryId(this.getStrongCategoryId());
		basicInfo.setStrongCategoryName(this.getStrongCategoryName());
		basicInfo.setStrongSubcategoryId(this.getStrongSubcategoryId());
		basicInfo.setStrongSubcategoryName(this.getStrongSubcategoryName());
		basicInfo.setStrongModelId(this.getStrongModelId());
		basicInfo.setStrongModelName(this.getStrongModelName());
		basicInfo.setWeightStyle(this.getWeightStyle());
		basicInfo.setAccessory(this.getIsAccessory() > 0);
		basicInfo.setIsShoe(this.getIsShoe());

		return basicInfo;
	}

}
