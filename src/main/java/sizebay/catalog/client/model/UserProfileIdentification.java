package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import static java.time.LocalDateTime.now;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileIdentification implements Serializable {

     private static final BigDecimal DAYS_OF_YEAR = new BigDecimal(365.2425D);

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

     @JsonGetter
     public String getIdView() {return Long.toString(this.id);}

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

     public Date getBirth(int age) {
          final int days = new BigDecimal(age).multiply(DAYS_OF_YEAR).intValue();
          final ZonedDateTime then = now().minusDays(days).atZone(ZoneId.systemDefault());

          return ( Date.from(then.toInstant()));
     }

}
