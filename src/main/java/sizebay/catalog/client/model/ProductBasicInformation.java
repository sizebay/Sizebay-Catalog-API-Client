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
	String coverImage;
	int isShoe;
	int szbMainCategoryId;
	int szbSubCategoryId;
	String szbMainCategoryName = null;
	String szbSubCategoryName = null;
	String categoryName;
	String modelingName;
	@Deprecated boolean bottomOnly;
	ClothesType clothesType;
	String sizeType;
	Boolean status;
	Product.AgeGroupEnum ageGroup = null;
	Map<String, ModelingSizeMeasures> measures;
	Boolean accessory;
}