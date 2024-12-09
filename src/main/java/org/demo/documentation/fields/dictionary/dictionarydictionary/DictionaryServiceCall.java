package org.demo.documentation.fields.dictionary.dictionarydictionary;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cxbox.dictionary.Dictionary;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.documentation.fields.dictionary.dictionarydictionary.restapi.MyEntity380ExternalResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryServiceCall {

    private final RestTemplate restTemplate;

    private final IntegrationConfiguration integrationConfig;

    public static final String TYPE = "type";
    public static final String KEY = "key";

    public List<MyEntity380ExternalResponse> getAll(String type) {

        Map<String, String> params = new HashMap<>();
        params.put(TYPE, type);

        ResponseEntity<List<MyEntity380ExternalResponse>> response = restTemplate.exchange(
                fromUriString(integrationConfig.getDictionaryDataServerUrl() + "/all?type={type}").build(params).normalize(),
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }

    public Optional<MyExample380ExternalDTO> getOne(String type, String key) {

        Map<String, String> params = new HashMap<>();
        params.put(TYPE, type);
        params.put(KEY, key);

        ResponseEntity<Optional<MyExample380ExternalDTO>> response = restTemplate.exchange(
                fromUriString(integrationConfig.getDictionaryDataServerUrl() + "/one/?type={type}&key={key}").build(params).normalize(),
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

}