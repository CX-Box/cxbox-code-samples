package org.demo.documentation.fields.dictionary.dictionarydictionary;

/*
 * © OOO "SI IKS LAB", 2022-2023
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.net.URI;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.cxbox.api.data.dictionary.DictionaryCache;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.demo.controller.SourcesController.SOURCES_ORIGINAL_PATH_PREFIX;

@Configuration
public class DictionaryConfig {
    final RestTemplate proxyRestTemplate;
    private final IntegrationConfiguration integrationConfig;

    public DictionaryConfig(RestTemplate proxyRestTemplate, IntegrationConfiguration integrationConfig) {
        this.proxyRestTemplate = proxyRestTemplate;
        this.integrationConfig = integrationConfig;
    }

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