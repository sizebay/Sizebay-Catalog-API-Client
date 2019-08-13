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
	
    int chest;
    int waist;
    int hip;
    int sleeve;
    int length;
    int insideLeg;
    int neck;
    int fist;
    int underBust;

}
