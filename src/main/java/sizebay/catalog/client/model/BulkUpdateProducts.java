package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import static java.util.Collections.emptyList;

@Getter
@Setter
public class BulkUpdateProducts {

	private List<Long> ids;
	private String gender;
	private String ageGroup;
	private Integer brandId;
	private Integer categoryId;
	private Integer modelingId;
	private String sizeType;
	private Integer strongTypeId;
	private Integer strongBrandId;
	private Integer strongCategoryId;
	private Integer strongSubcategoryId;
	private Integer strongModelId;
	private Boolean activatePlugin;
	private List<String> availableSizes = emptyList();

}
