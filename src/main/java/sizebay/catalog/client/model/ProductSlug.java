package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductSlug {

	private String slug;
	private String permalink;
	private String ageGroup;
	private String gender;
	private SizeSystem sizeSystem;

}
