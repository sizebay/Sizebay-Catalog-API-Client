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
	private Long tenantId;
	private String title;
	private String productType;
	private String brand;
	private String category;
	private String link;
	private String imageLink;
	private char gender;
	private List<String> sizes;
	private List<String> availableSizes;
	private String sizeType;
	private String ageGroup;
	private boolean availability;

}
