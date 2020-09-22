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
public class ProfileProduct implements Serializable {

      String brand;
      String brandName;
      String category;
      int categoryId;
      String subcategory;
      int subcategoryId;
      String model;
      int modelId;
      String gender;
      int ageGroup;
      String size;
			String sizeLabel;
      String sizeStr;
      double weightStyle;

}
