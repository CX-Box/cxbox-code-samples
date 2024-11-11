package org.demo.documentation.fields.dictionary.dictionarylov;

import static org.cxbox.api.data.dictionary.DictionaryCache.dictionary;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.IDictionaryType;
import org.cxbox.api.data.dictionary.LOV;

@Getter
@RequiredArgsConstructor
public enum AdministeredDictionaryType implements Serializable, IDictionaryType {

    REGIONS;

    @Override
    public LOV lookupName(String val) {
        return dictionary().lookupName(val, this);
    }

    @Override
    public String lookupValue(LOV lov) {
        return dictionary().lookupValue(lov, this);
    }

    @Override
    public String getName() {
        return name();
    }

    public boolean containsKey(String key) {
        return dictionary().containsKey(key, this);
    }

    public static class Regions {
        public static final LOV MOSCOW = new LOV("MOSCOW");
        public static final LOV SAINT_PETERBURG = new LOV("SAINT_PETERBURG");
        public static final LOV SYKTYVKAR = new LOV("SYKTYVKAR");
        public static final LOV KOSTROMA = new LOV("KOSTROMA");
    }
}