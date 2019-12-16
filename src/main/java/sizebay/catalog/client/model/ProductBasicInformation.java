package sizebay.catalog.client.model;

import java.io.Serializable;
import java.util.Map;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProductBasicInformation implements Serializable {

	long id;
	@NonNull String name;
	@NonNull String permalink;
	String genderTheWearWasDesignedFor;
	String feedProductId;
	String coverImage;
	int isShoe;
	@Deprecated int szbMainCategoryId; // FIXME Remove this field after legacy virtual dead
	@Deprecated int szbSubCategoryId; // FIXME Remove this field after legacy virtual dead
	@Deprecated String szbMainCategoryName = null; // FIXME Remove this field after legacy virtual dead
	@Deprecated String szbSubCategoryName = null; // FIXME Remove this field after legacy virtual dead
	String categoryName;
	String modelingName;
	String observation;
	@Deprecated boolean bottomOnly;
	ClothesType clothesType;
	String sizeType;
	Boolean status;
	Product.AgeGroupEnum ageGroup = null;
	Map<String, ModelingSizeMeasures> measures;
	Boolean accessory;
	Long tenantId;
	Long strongBrandId;
	String strongBrandName;
	Long 	strongTypeId;
	String strongTypeName;
	Long strongCategoryId;
	String strongCategoryName;
	Long strongSubcategoryId;
	String strongSubcategoryName;
	Long strongModelId;
	String strongModelName;
	double weightStyle;
}