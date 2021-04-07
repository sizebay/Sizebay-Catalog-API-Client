package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ModelingFilter extends Filter {

	private String page;
	private String id;
	private String name;
	private String ageGroup;
	private String gender;
	private String sizeType;
	private String brandId;
	private String brandName;
	private String strongCategoryType;
	private String onlyAccessories;
	private String status;

}
