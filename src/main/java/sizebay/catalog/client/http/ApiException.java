package sizebay.catalog.client.http;

final public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1916745028112506101L;

	public ApiException() {}

	public ApiException( Throwable throwable ) {
		super( throwable );
	}

	public ApiException( String message ) {
		super( message );
	}

	public ApiException( String message, Throwable throwable ) {
		super( message, throwable );
	}
}
