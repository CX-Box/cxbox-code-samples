package org.demo.documentation.fields.dictionary.dictionarydictionary;

import lombok.NonNull;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.DictionaryItemDTO;
import org.demo.services.utils.RestResponsePage;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DictionaryProvider2 implements DictionaryProvider
    {
        public Dictionary lookupName(DictionaryValue value, Class<Dictionary> type) {
        var dictionaryType = Dictionary.of(type, "").getDictionaryType();
        //Caching STRONGLY recommended here
        var key = "";
        return Dictionary.of(type, key);
    }

        public List<Dictionary> getAllExternal(Class<Dictionary> type) {
        var dictionaryType = Dictionary.of(type, "").getDictionaryType();

        ResponseEntity<RestResponsePage<DictionaryItemDTO>> tt =   dictionaryServiceCall.getAll(type);

        return  new ArrayList<>();
    }

        public DictionaryValue get(Dictionary dictionary) {
        var type = dictionary.getDictionaryType();
        var key = dictionary.key();

        return null;
    }

        @Override
        public <T extends Dictionary> T lookupName(@NonNull Class<T> type, @NonNull DictionaryValue value) {
            return null;
        }

        @Override
        public <T extends Dictionary> DictionaryValue lookupValue(@NonNull T dictionary) {
            return null;
        }

        @Override
        public @NonNull <T extends Dictionary> Collection<T> getAll(@NonNull Class<T> type) {
            return List.of();
        }
    };
