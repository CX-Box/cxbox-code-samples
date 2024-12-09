package org.demo.documentation.fields.dictionary.dictionarydictionary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.DictionaryItemDTO;
import org.demo.services.utils.IntegrationURLBuilder;
import org.demo.services.utils.IntegrationURLRules;
import org.demo.services.utils.RestResponsePage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;
@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryServiceCall {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final IntegrationURLBuilder integrationURLBuilder;

    public  DictionaryItemDTO  getAll(final Class<Dictionary> type) {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDictionaryDataServerUrl());

        var responseEntity = restTemplate.exchange(builder.build()
                .normalize().encode().toUriString(),
        GET, null, new ParameterizedTypeReference<>() {
        });
        return (DictionaryItemDTO) responseEntity.getBody();
    }

}
