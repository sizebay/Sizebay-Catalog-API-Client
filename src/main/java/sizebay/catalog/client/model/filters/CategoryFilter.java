package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CategoryFilter extends Filter {

	private String page;
	private String name;
	private String onlyWithAssociation;
	private String onlyWithoutAssociation;
	private String onlyShoe;

}