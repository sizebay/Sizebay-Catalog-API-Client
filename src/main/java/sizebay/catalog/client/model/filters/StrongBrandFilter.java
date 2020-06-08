package sizebay.catalog.client.model.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrongBrandFilter extends Filter {

	private String page;
	private String id;
	private String name;
	private String logo;
	private String ageGroup;
	private String gender;
	private String onlyShoes;
	private String status;

}
