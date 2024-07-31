package org.demo.documentation.fields.suggest;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.microservice.createmicroservices.MyEntity3810OutServiceDTO;
import org.demo.documentation.feature.microservice.createmicroservices.utils.IntegrationURLBuilder;
import org.demo.documentation.feature.microservice.createmicroservices.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
@RequiredArgsConstructor
public class MyEntity3810Dao extends AbstractAnySourceBaseDAO<MyEntity3810OutServiceDTO> implements AnySourceBaseDAO<MyEntity3810OutServiceDTO> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final IntegrationURLBuilder integrationURLBuilder;

    @Override
    public String getId(final MyEntity3810OutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity3810OutServiceDTO entity) {
        entity.setId(id);
    }


    // --8<-- [start:getByIdIgnoringFirstLevelCache]
    @Override
    public MyEntity3810OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityCreateMicroservicesDataServerUrl() + "/{id}").build()
                        .expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                GET, null, MyEntity3810OutServiceDTO.class
        ).getBody();
    }

    // --8<-- [end:getByIdIgnoringFirstLevelCache]

    // --8<-- [start:getList]
    @Override
    public Page<MyEntity3810OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        ResponseEntity<RestResponsePage<MyEntity3810OutServiceDTO>> responseEntity = restTemplate.exchange(
                integrationURLBuilder.getURLWithQueryParams(bc, integrationConfig.getMyentityCreateMicroservicesDataServerUrl()).build()
                        .normalize().encode().toUriString(),
                GET, null, new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }
    // --8<-- [end:getList]

    @Override
    // --8<-- [start:delete]
    public void delete(BusinessComponent bc) {
        restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityCreateMicroservicesDataServerUrl() + "/{id}").build().expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                DELETE, null, Void.class
        );
    }
    // --8<-- [end:delete]


    @Override
    // --8<-- [start:create]
    public MyEntity3810OutServiceDTO create(BusinessComponent bc, MyEntity3810OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityCreateMicroservicesDataServerUrl()).build().normalize().encode().toUriString(),
                POST, new HttpEntity<>(entity), MyEntity3810OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:create]

    @Override
    // --8<-- [start:update]
    public MyEntity3810OutServiceDTO update(BusinessComponent bc, MyEntity3810OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityCreateMicroservicesDataServerUrl()).build().normalize().encode().toUriString(),
                PUT, new HttpEntity<>(entity), MyEntity3810OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:update]
}
