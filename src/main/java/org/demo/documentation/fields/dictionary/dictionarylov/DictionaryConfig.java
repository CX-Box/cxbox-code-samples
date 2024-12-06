package org.demo.documentation.fields.dictionary.dictionarylov;
import java.util.Collection;
import lombok.NonNull;
import org.cxbox.api.data.dictionary.DictionaryCache;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DictionaryConfig {

    @Bean
    public DictionaryProvider dictionaryProvider() {
        return new DictionaryProvider() {

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
                return DictionaryCache.dictionary().getAll(Dictionary.of(dictionaryType, "").getDictionaryType())
                        .stream()
                        .map(e -> Dictionary.of(dictionaryType, e.getKey()))
                        .toList();
            }
        };
    }

}