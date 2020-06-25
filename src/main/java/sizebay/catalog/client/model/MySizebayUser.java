package sizebay.catalog.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
public class MySizebayUser {

	private String username;
	private String password;
	private List<Tenant> tenants = new ArrayList<>();

}
