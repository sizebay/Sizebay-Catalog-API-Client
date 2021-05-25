package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TenantDetails {

	private Long tenantId;
	private String name;
	private String domain;
	private List<String> subdomains;
	private String productIntegrationXmlLink;
	private TenantPlan plan;
	private String gtmCode;
	private TenantProfile tenantProfile;
	private SizeSystem sizeSystem;
	private TenantOperation tenantOperation;
	private TenantStatus status;
	private CoverageDetails coverageDetails;

}
