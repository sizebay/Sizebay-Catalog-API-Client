package sizebay.catalog.client.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SizeStyle implements Serializable {

	long id;
	long brandId;
	String brandName;
	int categoryTypeId;
	String categoryTypeName;
	char gender;
	int ageGroup;
	int categoryId;
	String categoryName;
	int subcategoryId;
	String subcategoryName;
	int modelId;
	String modelName;
	double weighStyle;
	String slugName;
}

