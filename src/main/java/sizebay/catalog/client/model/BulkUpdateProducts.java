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
	private String feedGender;
	private String ageGroup;
	private String feedAgeGroup;
	private Integer brandId;
	private Long feedBrandId;
	private Integer categoryId;
	private Integer modelingId;
	private String sizeType;
	private Integer strongSubcategoryId;
	private Integer strongModelId;
	private Boolean activatePlugin;
	private List<String> availableSizes = emptyList();

}
