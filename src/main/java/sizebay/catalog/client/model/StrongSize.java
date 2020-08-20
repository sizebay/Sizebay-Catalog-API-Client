package sizebay.catalog.client.model;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class StrongSize {

	private String groupMeasures;
	private Map<SizeSystem, String> labels = new HashMap<>();
	private Map<Measure, StrongMeasureRange> measures = new HashMap<>();
	private int totalSamples;
	private double accuracyPercentage;

}
