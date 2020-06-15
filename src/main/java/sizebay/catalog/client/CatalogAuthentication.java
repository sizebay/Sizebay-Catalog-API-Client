package sizebay.catalog.client;

import java.net.HttpURLConnection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sizebay.catalog.client.http.RESTClientConfiguration;

@Getter
@RequiredArgsConstructor
public class CatalogAuthentication implements RESTClientConfiguration {

	final String applicationToken;
	final String securityToken;

	@Override
	public void configureRequest( HttpURLConnection connection ) {
		connection.setRequestProperty( "Application-Token", applicationToken );
		connection.setRequestProperty( "Security-Token", securityToken );
	}
}
