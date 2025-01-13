package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import org.cxbox.dictionary.Dictionary;


public record CustomDictionarySortingExample(String key) implements Dictionary {

    public static final CustomDictionarySortingExample HIGH = new CustomDictionarySortingExample("HIGH");
    public static final CustomDictionarySortingExample MIDDLE = new CustomDictionarySortingExample("MIDDLE");

    public static final CustomDictionarySortingExample LOW = new CustomDictionarySortingExample("HIGH");
}
