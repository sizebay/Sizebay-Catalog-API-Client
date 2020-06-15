package sizebay.catalog.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
