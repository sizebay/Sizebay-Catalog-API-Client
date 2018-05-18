package sizebay.catalog.client.model;

import lombok.Data;

@Data
public class ModelingMeasureRange   {
  private Float initialValue = null;
  private Float finalValue = null;
  private String text;
  private ModelingMeasureType type;
}
