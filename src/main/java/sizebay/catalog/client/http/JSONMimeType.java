package sizebay.catalog.client.http;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMimeType implements MimeType {

	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final String DEFAULT_CONTENT_TYPE = "application/json";

	final ObjectMapper mapper;

	public JSONMimeType() {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion( Include.NON_NULL );
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public String serialize(Object request ) {
		try {
			return mapper.writeValueAsString( request );
		} catch ( final JsonProcessingException e ) {
			throw new RuntimeException( e );
		}
	}

	public <T> T unserialize(String response, Class<T> respClass ) {
		try {
			return mapper.readValue( response, respClass );
		} catch ( final IOException e ) {
			throw new RuntimeException( e );
		}
	}

	@Override
	public <T> List<T> unserializeList(String string, Class<T> clazz) {
		try {
			return mapper.readValue(string, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (IOException e) {
			throw new IllegalStateException( "Could not unserialize JSON: \n\n" + string + "\n\n", e);
		}
	}

	@Override
	public String contentType() {
		return DEFAULT_CONTENT_TYPE;
	}

	@Override
	public String charset() {
		return DEFAULT_CHARSET;
	}
}
