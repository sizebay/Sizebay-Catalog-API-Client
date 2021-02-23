package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserTenants {

	private Long id;
	private String username;
	private String privilege;
	private List<Tenant> tenants;

}
