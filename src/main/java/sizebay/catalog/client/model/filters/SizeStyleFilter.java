package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SizeStyleFilter extends Filter {

	private String page;
	private String id;
	private String brandId;
	private String brandName;
	private String typeId;
	private String typeName;
	private String gender;
	private String ageGroup;
	private String categoryId;
	private String categoryName;
	private String subcategoryId;
	private String subcategoryName;
	private String modelId;
	private String modelName;
	private String weightStyle;
	private String slugName;

}
