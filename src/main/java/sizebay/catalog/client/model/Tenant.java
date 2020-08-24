package sizebay.catalog.client.model;

import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Tenant implements Serializable {

	private static final long serialVersionUID = 670923421533753589L;

	@NonNull
	Long id;

	@NonNull
	String name;

	String feedRSS;

	String linkReturnsFile;

	@NonNull
	String appToken;

	@NonNull
	String secretToken;

	@NonNull
	String domain;

	String hashXML;

	boolean automaticallyImportSize;

	SizeSystem defaultSizeSystem;

	boolean monitored;

	int httpLinkBehavior;

	String importationRules;

	int active;
}