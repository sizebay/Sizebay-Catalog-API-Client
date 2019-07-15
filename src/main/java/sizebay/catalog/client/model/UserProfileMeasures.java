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
public class UserProfileMeasures implements Serializable {
	
    int chest;
    int waist;
    int hip;
    int sleeve;
    int length;
    int insideLeg;
    int neck;
    int fist;
    int underBust;

    public static UserProfileMeasures empty() {

        UserProfileMeasures measures = new UserProfileMeasures();

        measures.setChest(0);
        measures.setWaist(0);
        measures.setHip(0);
        measures.setSleeve(0);
        measures.setLength(0);
        measures.setInsideLeg(0);
        measures.setNeck(0);
        measures.setFist(0);
        measures.setUnderBust(0);

        return measures;
    }

}
