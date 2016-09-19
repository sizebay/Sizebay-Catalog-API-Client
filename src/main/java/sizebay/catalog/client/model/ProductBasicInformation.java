package sizebay.catalog.client.model;

import java.io.Serializable;
import java.util.Map;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProductBasicInformation implements Serializable {

	long id;
	@NonNull String name;
	@NonNull String permalink;
	String genderTheWearWasDesignedFor;
	String coverImage;
	boolean bottomOnly;

	Map<String, ProductMeasures> measures;
}