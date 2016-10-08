package sizebay.catalog.client.model;

import java.util.Map;
import lombok.*;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
	String username;
	String password;
	Map<String, Object> properties;
}
