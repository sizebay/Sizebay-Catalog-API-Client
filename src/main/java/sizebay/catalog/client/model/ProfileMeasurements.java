package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileMeasurements implements Serializable {
	
    double chest;
    double waist;
    double hip;
    double sleeve;
    double length;
    double insideLeg;
    double neck;
    double fist;
    double underBust;
		Double poundWeight;

}