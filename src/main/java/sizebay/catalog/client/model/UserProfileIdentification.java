package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileIdentification implements Serializable {

     long id;
     String userId;
     String name;
     String gender;
     int age;
     int weight;
     int height;
     int bodyShapeChest;
     int bodyShapeWaist;
     int bodyShapeHip;
     int footShape;

     UserProfileMeasures measures;
     UserProfileProduct product;

     public static UserProfileIdentification empty() {

          UserProfileIdentification profile = new UserProfileIdentification();
          UserProfileMeasures measures = UserProfileMeasures.empty();
          UserProfileProduct product = UserProfileProduct.empty();

          profile.setName("Você");
          profile.setAge(0);
          profile.setWeight(0);
          profile.setHeight(0);
          profile.setBodyShapeChest(-99);
          profile.setBodyShapeWaist(-99);
          profile.setBodyShapeHip(-99);
          profile.setFootShape(-99);

          profile.setMeasures(measures);
          profile.setProduct(product);

          return profile;
     }

}
