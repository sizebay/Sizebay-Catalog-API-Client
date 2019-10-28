package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductIntegration implements Serializable {

	private Long id;
	private String name;
	private char gender;
	private String ageGroup;
	private String permalink;
	private String image;
	private Long tenantId;
	private String feedProductId;
	private String brandName;
	private String categoryName;
	private String modelingName;
	private String sizeType;
	private int availability;
	private Long strongBrandId;
	private String strongBrandName;
	private Long strongTypeId;
	private String strongTypeName;
	private Long strongCategoryId;
	private String strongCategoryName;
	private Long strongSubcategoryId;
	private String strongSubcategoryName;
	private Long strongModelId;
	private String strongModelName;
	private List<String> sizes;
	private List<String> availableSizes;
	private double weightStyle;
	private int isShoe;

}
