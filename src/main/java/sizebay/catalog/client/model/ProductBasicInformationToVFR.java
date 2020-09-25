package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductBasicInformationToVFR {

	private Long id;
	private Modeling.Gender gender;
	private Product.AgeGroupEnum ageGroup;
	private StrongCategoryType strongCategoryType;
	private boolean isAccessory;
	private boolean isShoe;
	private boolean status;

}
