package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductBasicInformationToVFR {

	private Long productId;
	private String productName;
	private Modeling.Gender productGender;
	private Product.AgeGroupEnum productAgeGroup;
	private Long strongCategoryId;
	private Long strongSubcategoryId;
	private String permalink ;
	private String categoryName;
	private StrongCategoryType strongCategoryType;
	private boolean isAccessory;
	private boolean isShoe;
	private boolean status;

}
