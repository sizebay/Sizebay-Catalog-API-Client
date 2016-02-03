package sizebay.catalog.client;

import java.net.HttpURLConnection;

import lombok.RequiredArgsConstructor;
import sizebay.catalog.client.http.RESTClientConfiguration;

@RequiredArgsConstructor
public class CatalogAuthentication implements RESTClientConfiguration {

	final String applicationToken;
	final String securityToken;

	@Override
	public void configureRequest( HttpURLConnection connection ) {
		connection.setRequestProperty( "Application-Key", applicationToken );
		connection.setRequestProperty( "Security-Key", securityToken );
	}
}
