package sizebay.catalog.client.http;

import java.util.List;

public interface MimeType {

	String serialize(Object object );

	<T> T unserialize(String string, Class<T> clazz );

	<T> List<T> unserializeList(String string, Class<T> clazz );

	String contentType();

	String charset();
}
