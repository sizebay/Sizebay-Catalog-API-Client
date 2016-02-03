package sizebay.catalog.client.http;

public interface MimeType {

	String unserialize( Object object );

	<T> T serialize( String string, Class<T> clazz );

	String contentType();

	String charset();
}
