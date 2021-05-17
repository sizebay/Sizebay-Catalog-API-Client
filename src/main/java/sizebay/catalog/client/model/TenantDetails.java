package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantDetails {

	private Long tenantId;
	private String name;
	private String domain;
	private TenantPlan plan;
	private String gtmCode;
	private TenantProfile tenantProfile;
	private SizeSystem sizeSystem;
	private TenantOperation tenantOperation;
	private TenantStatus status;
	private CoverageDetails coverageDetails;

}
