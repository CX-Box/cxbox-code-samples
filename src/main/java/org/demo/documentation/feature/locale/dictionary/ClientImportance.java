package org.demo.documentation.feature.locale.dictionary;

import org.cxbox.dictionary.Dictionary;

import java.util.Map;

public record ClientImportance(String key) implements Dictionary {

	public static final ClientImportance HIGH = new ClientImportance("HIGH");

	public static final ClientImportance MIDDLE = new ClientImportance("MIDDLE");

	public static final ClientImportance LOW = new ClientImportance("LOW");

	public static final Map<ClientImportance, String> colors = Map.of(
			HIGH, "#EC3F3F",
			MIDDLE, "#FCA546",
			LOW, "#008C3E"
	);

}
