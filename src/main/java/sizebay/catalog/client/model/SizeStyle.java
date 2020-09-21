package sizebay.catalog.client.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SizeStyle implements Serializable {

	long id;
	long brandId;
	String brandName;
	StrongCategoryType categoryType;
	char gender;
	int ageGroup;
	int categoryId;
	String categoryName;
	int subcategoryId;
	String subcategoryName;
	int modelId;
	String modelName;
	String sizeType;
	Long modelingId;
	String modelingName;
	double weightStyle;
	String slugName;
	private Map<Language, String> categoryTranslations = new HashMap();
	private Map<Language, String> subcategoryTranslations = new HashMap();

}

