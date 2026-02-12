package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import org.cxbox.dictionary.Dictionary;


public record CustomDictionarySorting(String key) implements Dictionary {

	public static final CustomDictionarySorting HIGH = new CustomDictionarySorting("HIGH");
	public static final CustomDictionarySorting MIDDLE = new CustomDictionarySorting("MIDDLE");

}
