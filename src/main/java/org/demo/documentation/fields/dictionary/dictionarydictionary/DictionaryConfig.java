package org.demo.documentation.fields.dictionary.dictionarydictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.NonNull;
import org.cxbox.api.data.dictionary.DictionaryCache;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.DictionaryItemDTO;
import org.demo.services.utils.RestResponsePage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@Configuration
public class DictionaryConfig {
    @Bean
    DictionaryProvider dictionaryProvider() {

        return new DictionaryProvider2();

    }
}