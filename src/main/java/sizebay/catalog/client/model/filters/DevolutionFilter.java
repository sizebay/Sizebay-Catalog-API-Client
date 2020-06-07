package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DevolutionFilter extends Filter {

	private String page;
	private String productId;
	private String productName;
	private String productUrl;

}
