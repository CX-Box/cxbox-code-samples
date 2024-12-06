package org.demo.documentation.fields.dictionary.dictionarylov.anysorce;

import org.cxbox.dictionary.Dictionary;

public record RegionsAnysource(String key) implements Dictionary {

        public static final RegionsAnysource SAINT_PETERBURG = new RegionsAnysource("SAINT_PETERBURG");

        public static final RegionsAnysource MOSCOW = new RegionsAnysource("MOSCOW");

    }
