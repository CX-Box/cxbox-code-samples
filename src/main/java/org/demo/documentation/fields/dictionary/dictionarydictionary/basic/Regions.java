package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

import org.cxbox.api.data.dto.rowmeta.OptionsMetadata;
import org.cxbox.dictionary.Dictionary;

public record Regions(String key) implements Dictionary, OptionsMetadata {


	public static final Regions SAINT_PETERBURG = new Regions("SAINT_PETERBURG");

	public static final Regions MOSCOW = new Regions("MOSCOW");
}
