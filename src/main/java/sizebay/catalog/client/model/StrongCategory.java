package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StrongCategory {

	private Long id;
	private String name;
	private String type;
	private StrongCategoryType strongCategoryType;
	private List<StrongSubcategory> subcategories = new ArrayList<StrongSubcategory>();

}
