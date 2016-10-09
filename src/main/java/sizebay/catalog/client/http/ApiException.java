package sizebay.catalog.client.http;

final public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1916745028112506101L;

	final int status;
	final String message;

	public ApiException() {
		status = 500;
		message = "Internal Server Error";
	}

	public ApiException( Throwable throwable ) {
		super( throwable );
		status = 500;
		message = throwable.getMessage();
	}

	public ApiException( String message ) {
		super( message );
		this.status = 500;
		this.message = message;
	}

	public ApiException( String message, Throwable throwable ) {
		super( message, throwable );
		this.status = 500;
		this.message = message;
	}

	public ApiException( int status, String message ) {
		super( status + ": " + message );
		this.status = status;
		this.message = message;
	}

	public ApiException( int status, String message, Throwable throwable ) {
		super( message, throwable );
		this.status = status;
		this.message = message;
	}
}
