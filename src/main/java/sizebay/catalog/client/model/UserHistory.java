package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserHistory {

	private Long id;
	private String userId;
	private Long productId;
	private String productName;
	private String productURL;
	private String productImage;
	private Date createdAt;

}