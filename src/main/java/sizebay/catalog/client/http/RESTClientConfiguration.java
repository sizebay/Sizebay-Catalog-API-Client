package sizebay.catalog.client.http;

import java.net.HttpURLConnection;

public interface RESTClientConfiguration {

	void configureRequest( HttpURLConnection connection );

}
