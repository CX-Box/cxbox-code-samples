package org.demo.documentation.fields.dictionary.dictionarylov.anysorce;

import org.cxbox.dictionary.Dictionary;

public record DictionaryType(String key) implements Dictionary {

    public static final DictionaryType HIGH = new DictionaryType("HIGH");

}
