package sizebay.catalog.client.http;

import java.io.*;
import java.net.*;
import java.util.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RESTClient {

	static final String METHOD_POST = "POST";
	static final String METHOD_GET = "GET";
	static final String METHOD_PUT = "PUT";
	static final String METHOD_DELETE = "DELETE";

	final String baseUrl;
	final MimeType mime;
	final RESTClientConfiguration config;

	public void delete( String serverEndpoint ) {
		callEndpoint( METHOD_DELETE, serverEndpoint );
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

	public void put( String serverEndpoint, Object request )
	{
		final String jsonBodyData = mime.serialize( request );
		sendToEndpoint( METHOD_PUT, serverEndpoint, jsonBodyData );
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

}