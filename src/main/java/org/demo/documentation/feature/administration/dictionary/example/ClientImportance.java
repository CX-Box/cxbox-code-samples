package org.demo.documentation.feature.administration.dictionary.example;

import org.cxbox.dictionary.Dictionary;

public record ClientImportance(String key) implements Dictionary {

    public static final ClientImportance HIGH = new ClientImportance("HIGH");

}
