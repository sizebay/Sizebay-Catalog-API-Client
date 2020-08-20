package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StrongModeling {

	private Long id;
	private String name;
	private String ageGroup;
	private String gender;
	private StrongCategoryType strongCategoryType;
	private Long strongBrandId;
	private String strongBrandName;
	private String modelingSizeType;
	private int isAnOrganicModeling;
	private List<StrongSize> sizes = new ArrayList<>();
	private List<String> slugs = new ArrayList<>();

}
