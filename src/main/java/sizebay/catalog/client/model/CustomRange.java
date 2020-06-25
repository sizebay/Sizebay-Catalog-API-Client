package sizebay.catalog.client.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomRange {

	private Measure measure;
	private Double initialValue;
	private Double finalValue;

}