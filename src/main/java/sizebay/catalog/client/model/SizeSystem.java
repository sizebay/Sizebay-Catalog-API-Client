package sizebay.catalog.client.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum SizeSystem {

	AU, BR, CN, DE, EU, FR,
	IT, JP, MEX, UK, US, ZH, AR, CUSTOM;

	public static SizeSystem from(String value) {
		try {
			if(value == null || value.isEmpty()) {
				return null;
			}

			return SizeSystem.valueOf(value.toUpperCase());
		} catch (Throwable e) {
			throw new IllegalArgumentException();
		}
	}

}
