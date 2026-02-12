package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import org.cxbox.dictionary.Dictionary;


public record CustomDictionaryNewFiltration(String key) implements Dictionary {

	public static final CustomDictionaryNewFiltration A = new CustomDictionaryNewFiltration("A");
	public static final CustomDictionaryNewFiltration B = new CustomDictionaryNewFiltration("B");


}
