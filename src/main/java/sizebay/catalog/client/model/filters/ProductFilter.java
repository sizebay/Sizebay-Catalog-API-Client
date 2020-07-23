package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter extends Filter {

	private String page;
	private String id;
	private String name;
	private String permalink;
	private String ageGroup;
	private String gender;
	private String feedProductId;
	private String brandId;
	private String brandName;
	private String categoryId;
	private String categoryName;
	private String modelingId;
	private String modelingName;
	private String strongBrandId;
	private String strongBrandName;
	private String strongCategoryType;
	private String strongCategoryId;
	private String strongCategoryName;
	private String strongSubcategoryId;
	private String strongSubcategoryName;
	private String strongModelId;
	private String strongModelName;
	private String slugId;
	private String onlyShoes;
	private String productsThatShouldBeFixed;
	private String productsAvailable;
	private String productsUnavailable;

}
