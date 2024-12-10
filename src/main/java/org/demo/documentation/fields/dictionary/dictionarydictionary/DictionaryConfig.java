package org.demo.documentation.fields.dictionary.dictionarydictionary;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.cxbox.api.data.dictionary.DictionaryCache;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.documentation.fields.dictionary.dictionarydictionary.restapi.MyEntity380ExternalResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class DictionaryConfig {

    @Bean
    public DictionaryProvider dictionaryProvider(@Lazy DictionaryServiceCall dictionaryServiceCall) {
        return new DictionaryProvider() {

            public static final String DICTIONARY_TYPE = "DICTIONARY_TYPE";

            @Override
            public <T extends Dictionary> T lookupName(@NonNull Class<T> type, @NonNull DictionaryValue value) {
                var dictTmp = Dictionary.of(type, "");
                var lov = DictionaryCache.dictionary().lookupName(value.getValue(), dictTmp.getDictionaryType());
                return Dictionary.of(type, lov.getKey());
            }

            @Override
            public <T extends Dictionary> SimpleDictionary lookupValue(@NonNull T dictionary) {
                return DictionaryCache.dictionary().get(dictionary.getDictionaryType(), dictionary.key());
            }

            @Override
            public <T extends Dictionary> Collection<T> getAll(@NonNull Class<T> dictionaryType) {

                if (DICTIONARY_TYPE.equals( Dictionary.of(dictionaryType, "").getDictionaryType())) {
                    List<MyEntity380ExternalResponse> resp = dictionaryServiceCall.getAll(Dictionary.of(dictionaryType, "").getDictionaryType());
                    return resp
                            .stream()
                            .map(e -> Dictionary.of(dictionaryType, e.getKey()))
                            .toList();
                }

                return DictionaryCache.dictionary().getAll(Dictionary.of(dictionaryType, "").getDictionaryType())
                        .stream()
                        .map(e -> Dictionary.of(dictionaryType, e.getKey()))
                        .toList();
            }

            public <T extends Dictionary> String get(@NonNull Class<T> dictionaryType, String key) {
                Optional<MyExample380ExternalDTO> resp = dictionaryServiceCall.getOne(Dictionary.of(dictionaryType, "").getDictionaryType(), key);
                return resp.get().getValue();
            }
        };

    }

}