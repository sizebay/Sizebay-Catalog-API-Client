package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ProductBasicInformationToVFR {

	private Long id;
	private Modeling.Gender gender;
	private Product.AgeGroupEnum ageGroup;
	private StrongCategoryType strongCategoryType;
	private boolean isPending;
	private boolean isAccessory;
	private boolean isShoe;
	private boolean status;

}
