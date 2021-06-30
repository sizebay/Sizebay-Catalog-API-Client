package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Dashboard {

	private Long tenantId;
	private String tenantName;
	private long pendencies;
	private long inactives;
	private long regular;
	private long total;
	private ImportationSummary importationSummary;
	private TenantStatus status;

}
