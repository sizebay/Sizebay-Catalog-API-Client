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
public class UserProfileProduct implements Serializable {

      long id ;
      long profileIdentificationId;
      String brand;
      String category;
      String model;
      String gender;
      int ageGroup;
      String size;
      String sizeStr;

      public static UserProfileProduct empty() {

          UserProfileProduct product = new UserProfileProduct();

          product.setBrand("");
          product.setCategory("");
          product.setModel("");
          product.setGender("");
          product.setAgeGroup(0);
          product.setSize("");
          product.setSizeStr("");

          return product;

      }

}
