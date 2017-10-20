package sizebay.catalog.client.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ImportationError {
    private String errorType;
    private String brandName;
    private String genderItWasDesignedFor;
    private String availableSizes;
}
