package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import org.cxbox.dictionary.Dictionary;


public record CustomDictionaryFiltrationSecond(String key) implements Dictionary {

	public static final CustomDictionaryFiltrationSecond HIGH = new CustomDictionaryFiltrationSecond("HIGH");
	public static final CustomDictionaryFiltrationSecond MIDDLE = new CustomDictionaryFiltrationSecond("MIDDLE");
	public static final CustomDictionaryFiltrationSecond LOW = new CustomDictionaryFiltrationSecond("LOW");


}
