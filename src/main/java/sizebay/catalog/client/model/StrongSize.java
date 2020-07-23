package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class StrongSize {

	private Long id;
	private String sizeName;
	private Map<Measure, StrongMeasureRange> measures = new HashMap<>();

}
