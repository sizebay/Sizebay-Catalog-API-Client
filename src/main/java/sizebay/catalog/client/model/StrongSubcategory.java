package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class StrongSubcategory {

	private Long id;
	private String name;
	private Long strongCategoryId;
	private Map<Language, String> translations = new HashMap<>();

}
