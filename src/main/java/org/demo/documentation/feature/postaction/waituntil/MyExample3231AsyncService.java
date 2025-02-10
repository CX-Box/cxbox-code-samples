package org.demo.documentation.feature.postaction.waituntil;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.postaction.anysorce.MyEntity3231AnySourceOutServiceDTO;
import org.demo.services.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Async
@Transactional
@Service
public class MyExample3231AsyncService {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3231Repository repository;

    public MyExample3231AsyncService(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3231Repository repository) {
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    // --8<-- [start:findInExternalSystem]
    protected void findInExternalSystemAsync(BusinessComponent bc, MyExample3231DTO dto) {

        MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
        Optional<MyEntity3231AnySourceOutServiceDTO> entityExternal = callService(dto).get().findFirst();
        entityExternal.ifPresent(myEntity3231AnySourceOutServiceDTO -> myEntity3231.setCustomField(myEntity3231AnySourceOutServiceDTO.getCustomField()));
        repository.save(myEntity3231);
    }
    // --8<-- [end:findInExternalSystem]

    // --8<-- [start:callService]
    public Page<MyEntity3231AnySourceOutServiceDTO> callService(MyExample3231DTO dto) {
            Optional<String> filter = Optional.ofNullable(dto.getCustomField());

            String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDataServerUrl())
                    .queryParam("number", 1)
                    .queryParam("size", 1)
                    .queryParamIfPresent("filterCustomField", filter)
                    .encode()
                    .toUriString();

            ResponseEntity<RestResponsePage<MyEntity3231AnySourceOutServiceDTO>> responseEntity = restTemplate.exchange(
                    urlTemplate,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    },
                    filter
            );

            return responseEntity.getBody();
    }
    // --8<-- [end:callService]

}

