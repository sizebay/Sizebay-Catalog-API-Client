package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class StrongCategory {

	private Long id;
	private String name;
	private String type;
	private StrongCategoryType strongCategoryType;
	private List<StrongSubcategory> subcategories = new ArrayList<StrongSubcategory>();
	private Map<Language, String> translations = new HashMap<>();

}
