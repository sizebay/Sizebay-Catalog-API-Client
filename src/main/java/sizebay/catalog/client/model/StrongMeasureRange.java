package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrongMeasureRange {

	private Long id;
	private String measure;
	private Long strongModelingId;
	private String strongModelingName;
	private Long strongSizeId;
	private String strongSizeName;
	private float initialValue;
	private float finalValue;

}
