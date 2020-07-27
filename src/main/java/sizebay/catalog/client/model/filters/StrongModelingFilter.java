package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrongModelingFilter extends Filter {

	private String page;
	private String id;
	private String name;
	private String ageGroup;
	private String gender;
	private String strongCategoryType;
	private String strongBrandId;
	private String strongBrandName;
	private String modelingSizeType;
	private String onlyOrganicModeling;
	private String slug;

}
