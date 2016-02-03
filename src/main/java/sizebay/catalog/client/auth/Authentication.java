package sizebay.catalog.client.auth;

import java.util.Map;
import java.util.List;

import sizebay.catalog.client.Pair;

public interface Authentication {
  /** Apply authentication settings to header and query params. */
  void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
