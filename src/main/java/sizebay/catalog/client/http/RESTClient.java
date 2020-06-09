package sizebay.catalog.client.http;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;
import lombok.RequiredArgsConstructor;
import sizebay.catalog.client.CatalogAuthentication;

@RequiredArgsConstructor
public class RESTClient {

	static final private String METHOD_GET 		= "GET";
	static final private String METHOD_PUT 		= "PUT";
	static final private String METHOD_POST 	= "POST";
	static final private String METHOD_PATCH  = "PATCH";
	static final private String METHOD_DELETE = "DELETE";

	final String baseUrl;
	final MimeType mime;
	final CatalogAuthentication config;

	public void delete( String serverEndpoint ) {
		callEndpoint( METHOD_DELETE, serverEndpoint );
	}

	public void delete(String serverEndpoint, Object request) {
		final String jsonBodyData = mime.serialize(request);
		sendToEndpoint(METHOD_DELETE, serverEndpoint, jsonBodyData);
	}

	public <T> T getSingle( String serverEndpoint, Class<T> expectedResponseClass ) {
		final Response response = callEndpoint( METHOD_GET, serverEndpoint );
		return serialize( response.body, expectedResponseClass );
	}

	private <T> T serialize( String response, Class<T> expectedResponseClass ) {
		if ( response == null )
			return null;
		return mime.unserialize( response, expectedResponseClass );
	}

	public <T> List<T> getList( String serverEndpoint, Class<T> expectedResponseClass ) {
		final Response response = callEndpoint( METHOD_GET, serverEndpoint );
		return serializeList( response.body, expectedResponseClass );
	}

	private <T> List<T> serializeList( String response, Class<T> expectedResponseClass ) {
		if ( response == null )
			return null;
		return mime.unserializeList( response, expectedResponseClass );
	}

	public long post( String serverEndpoint, Object request )
	{
		final String jsonBodyData = mime.serialize( request );
		final Response response = sendToEndpoint( METHOD_POST, serverEndpoint, jsonBodyData );
		return response.connection.getHeaderFieldLong( "ID", -1 );
	}

	public <T> T post(String serverEndpoint, Object request, Class<T> expectedResponseClass) {
		final String jsonBodyData = mime.serialize(request);
		final Response response = sendToEndpoint( METHOD_POST, serverEndpoint, jsonBodyData );
		return serialize(response.body, expectedResponseClass);
	}

	public void put( String serverEndpoint, Object request )
	{
		final String jsonBodyData = mime.serialize( request );
		sendToEndpoint( METHOD_PUT, serverEndpoint, jsonBodyData );
	}

	public <T> T put( String serverEndpoint, Object request, Class<T> expectedResponseClass ) {
		final String jsonBodyData = mime.serialize( request );
		final Response response = sendToEndpoint( METHOD_PUT, serverEndpoint, jsonBodyData );
		return serialize( response.body, expectedResponseClass );
	}

	public void patch(String serverEndpoint, Object request) {
		final String jsonBodyData = mime.serialize(request);
		sendToEndpoint_(METHOD_PATCH, serverEndpoint, jsonBodyData);
	}

	private Response sendToEndpoint_(String httpMethod, String serverEndpoint, final String body) throws ApiException {
		try {
			final URL url = buildURL(serverEndpoint);
			final HttpClient client = this.createHttpClient();
			final HttpRequest request = this.createHttpRequest(url, httpMethod, body);

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			if(response.statusCode() >= 300) {
				handleFailure(response, body);
			}

			return new Response(response.body());
		} catch (final IOException | InterruptedException | URISyntaxException e) {
			throw new ApiException("Failed to send data to endpoint " + serverEndpoint, e);
		}
	}

	private HttpClient createHttpClient() {
		return HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(5000))
				.build();
	}

	private HttpRequest createHttpRequest(URL url, String method, String body) throws URISyntaxException {
		return HttpRequest.newBuilder()
				.uri(url.toURI())
				.header("Content-Type", mime.contentType())
				.header("Accept", mime.contentType())
				.header("charset", mime.charset())
				.header("Application-Token", config.getApplicationToken())
				.header("Security-Token", config.getSecurityToken())
				.method(method, HttpRequest.BodyPublishers.ofString(body))
				.build();
	}

	private Response sendToEndpoint( String httpMethod, String serverEndpoint, final String body ) {
		try {
			final URL url = buildURL( serverEndpoint );
			final HttpURLConnection connection = connect( httpMethod, url );
			sendDefaultHeaders( connection );
			sendData( connection, body );

			final String response = readData( connection );
			if ( connection.getResponseCode() / 100 >= 3 )
				handleFailure( connection, response, body );

			return new Response( response, connection );
		} catch ( final IOException e ) {
			throw new ApiException( "Failed to send data to endpoint " + serverEndpoint, e );
		}
	}

	private void handleFailure( final HttpURLConnection connection, final String response, String body )
			throws IOException
	{
		final String msg = "Status: " + connection.getResponseCode() + "\n\t\tResponse: " + response + "\n\t\tRequest: " + body;
		System.out.println( msg );
		throw new ApiException( connection.getResponseCode(), response );
	}

	private void handleFailure(HttpResponse<String> response, String body) throws IOException {
		final String msg = "Status: " + response.statusCode() + "\n\t\tResponse: " + response.body() + "\n\t\tRequest: " + body;
		System.out.println( msg );
		throw new ApiException( response.statusCode(), response.body());
	}

	private Response callEndpoint( String httpMethod, String serverEndpoint ) {
		try {
			final URL url = buildURL( serverEndpoint );
			final HttpURLConnection connection = connect( httpMethod, url );
			sendDefaultHeaders( connection );

			final String response = readData( connection );
			if ( connection.getResponseCode() / 100 >= 3 )
				throw new ApiException( connection.getResponseCode(), response );

			return new Response( response, connection );
		} catch ( final IOException e ) {
			throw new ApiException( e );
		}
	}

	private URL buildURL( String path ) {
		try {
			path = path.replace( "%", "%25" ).replace(" ", "%20");
			final String rootPath = ( baseUrl + "/" + path ).replaceAll( "([^:])//+", "$1/" );
			return new URL( rootPath );
		} catch ( final MalformedURLException e ) {
			throw new RuntimeException( e );
		}
	}

	private HttpURLConnection connect( String method, URL url ) throws IOException {
		final HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod( method );
		configureConnection( connection );
		return connection;
	}

	private void sendDefaultHeaders( HttpURLConnection connection ) {
		connection.setRequestProperty( "Content-Type", mime.contentType() );
		connection.setRequestProperty( "Accept", mime.contentType() );
		connection.setRequestProperty( "charset", mime.charset() );
	}

	private void configureConnection( HttpURLConnection connection ) {
		connection.setDoInput( true );
		connection.setDoOutput( true );
		connection.setUseCaches( false );
		connection.setConnectTimeout( 5000 );
		connection.setInstanceFollowRedirects( false );
		config.configureRequest( connection );
	}

	private void sendData( HttpURLConnection connection, String jsonBodyData ) throws IOException {
		final OutputStream outputStream = connection.getOutputStream();
		outputStream.write( jsonBodyData.getBytes( mime.charset() ) );
		outputStream.flush();
		outputStream.close();
		connection.connect();
	}

	private String readData( final HttpURLConnection connection ) throws IOException {
		try {
			final InputStream stream = connection.getInputStream();
			return convertStreamToString( stream );
		} catch ( final IOException ioe ) {
			return ioe.getMessage();
		}
	}

	private String convertStreamToString( InputStream is ) {
		try ( Scanner s = new Scanner( is, mime.charset() ) ) {
			s.useDelimiter( "\\A" );
			return s.hasNext() ? s.next() : "";
		}
	}
}

@RequiredArgsConstructor
class Response {

	final String body;
	final HttpURLConnection connection;

	public Response(String body) {
		this.body = body;
		this.connection = null;
	}
}