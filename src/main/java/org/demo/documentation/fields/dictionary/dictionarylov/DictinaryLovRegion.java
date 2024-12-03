package org.demo.documentation.fields.dictionary.dictionarylov;

import org.cxbox.dictionary.Dictionary;

public record DictinaryLovRegion(String key) implements Dictionary {

        public static final DictinaryLovRegion SAINT_PETERBURG = new DictinaryLovRegion("SAINT_PETERBURG");

        public static final DictinaryLovRegion MOSCOW = new DictinaryLovRegion("MOSCOW");

    }
