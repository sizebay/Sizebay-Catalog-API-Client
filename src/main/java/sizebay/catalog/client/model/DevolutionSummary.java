package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DevolutionSummary {
	private Long id;
	private long tenantId;
	private int insertedReturns;
	private int invalidReturns;
	private int totalReturns;

	public DevolutionSummary(long tenantId) {
		this.setTenantId(tenantId);
	}
}
