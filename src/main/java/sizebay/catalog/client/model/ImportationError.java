package sizebay.catalog.client.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ImportationError {
    private String message;
    private String brandName;
    private String genderItWasDesignedFor;
    private String availableSizes;
    private String categoryName;
    private String ageGroup;
    private String permalink;
}
