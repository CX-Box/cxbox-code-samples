package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import org.cxbox.dictionary.Dictionary;


public record CustomDictionaryFiltration(String key) implements Dictionary {

    public static final CustomDictionaryFiltration HIGH = new CustomDictionaryFiltration("HIGH");
    public static final CustomDictionaryFiltration MIDDLE = new CustomDictionaryFiltration("MIDDLE");
    public static final CustomDictionaryFiltration LOW = new CustomDictionaryFiltration("LOW");


}
