package sizebay.catalog.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportationSummary {

	Integer insertedProducts;
	Integer updatedProducts;
	Integer invalidProducts;
	Integer totalProducts;
	Integer errors;
	Integer knownErrors;
	Date date;

}
