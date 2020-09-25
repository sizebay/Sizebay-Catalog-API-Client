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
	private boolean pending;
	private boolean accessory;
	private boolean shoe;
	private boolean status;

}
