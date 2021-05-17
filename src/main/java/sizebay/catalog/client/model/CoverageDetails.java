package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoverageDetails {

	private Long id;
	private Long tenantId;
	private Long responsibleId;
	private String responsibleName;
	private TenantTypeModeling typeModeling;
	private VFRversion vfrVersion;
	private EcommercePlatform ecommercePlatform;
	private TenantSegment segment;
	private List<TenantCoveredCategories> coveredCategories;
	private List<TenantFeature> features;
	private String observation;
	private ReviewStatus reviewStatus;

}