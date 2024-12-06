package org.demo.documentation.fields.dictionary.dictionarylov.anysorce.dictionaryanysource;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.services.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
@RequiredArgsConstructor
public class MyEntity380Dao {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    public ResponseEntity<MyEntity380OutServiceDTO> getTypeAndKey(
            final BusinessComponent bc
    ) {

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDictionaryDataServerUrl())
                        .build("type", "page",key,key)

                .encode()
                .toUriString();

        ResponseEntity<RestResponsePage<MyEntity380OutServiceDTO>> responseEntity = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                },
                null
        );


        return responseEntity.getBody();
    }

}
