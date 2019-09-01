package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import static java.time.LocalDateTime.now;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile implements Serializable {

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

     int isActive;
     long lastActiveTime;

     ProfileMeasurements measures;
     ProfileProduct product;

    @JsonGetter
    public String getIdView() {return Long.toString(this.id);}

     public Date getBirth(int age) {
          final int days = new BigDecimal(age).multiply(DAYS_OF_YEAR).intValue();
          final ZonedDateTime then = now().minusDays(days).atZone(ZoneId.systemDefault());

          return ( Date.from(then.toInstant()));
     }

     public void generateIdentifier() {
          long val;
          do {
               val = UUID.randomUUID().getMostSignificantBits();
          } while (val < 0);
          this.setId(val);
     }

}
