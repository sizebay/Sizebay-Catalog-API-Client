package sizebay.catalog.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class DevolutionSummary {
	private Long id;
	private long tenantId;
	private int insertedReturns;
	private int invalidReturns;
	private int totalReturns;
}
