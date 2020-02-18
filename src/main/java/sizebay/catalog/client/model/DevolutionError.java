package sizebay.catalog.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DevolutionError {
	private Long tenantId;
	private String orderId;
	private String productId;
	private String productName;
	private String productUrl;
	private String sizeOrdered;
	private String message;
}
