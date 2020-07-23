package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class StrongModeling {

	private Long id;
	private String name;
	private String ageGroup;
	private String gender;
	private Long strongBrandId;
	private String strongBrandName;
	private String modelingSizeType;
	private Map<String, StrongSize> sizes = new HashMap<>();
	private List<String> slugs = new ArrayList<>();

}
