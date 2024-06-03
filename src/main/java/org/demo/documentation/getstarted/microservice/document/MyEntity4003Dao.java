package org.demo.documentation.getstarted.microservice.document;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.getstarted.microservice.MyEntity4001OutServiceDTO;
import org.demo.documentation.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.microservice.createmicroservices.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
@RequiredArgsConstructor
public class MyEntity4003Dao extends AbstractAnySourceBaseDAO<MyEntity4001OutServiceDTO> implements AnySourceBaseDAO<MyEntity4001OutServiceDTO> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    @Override
    public String getId(final MyEntity4001OutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity4001OutServiceDTO entity) {
        entity.setId(id);
    }


    // --8<-- [start:getByIdIgnoringFirstLevelCache]
    @Override
    public MyEntity4001OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityGetStartedMicroservicesDataServerUrl() + "/{id}").build()
                        .expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                GET, null, MyEntity4001OutServiceDTO.class
        ).getBody();
    }

    // --8<-- [end:getByIdIgnoringFirstLevelCache]

    // --8<-- [start:getList]
    @Override
    public Page<MyEntity4001OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {

        //Page size
        String page = bc.getParameters().getParameter("_page");

        //Limit
        String limit = bc.getParameters().getParameter("_limit");

        //Filter
        List<String> filterCustomField = getFilterFieldName(queryParameters, "customField", "contains");
        Optional<String> filter = filterCustomField.isEmpty() ? Optional.empty() : Optional.of(filterCustomField.get(0));

        //Sorting
        List<String> sortCustomField = getSortFieldName(queryParameters, "customField");
        Optional<String> sort = sortCustomField.isEmpty() ? Optional.empty() : Optional.of(sortCustomField.get(0));

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getMyentityGetStartedMicroservicesDataServerUrl())
                .queryParam("number", page)
                .queryParam("size", limit)
                .queryParamIfPresent("filterCustomField", filter)
                .queryParamIfPresent("sortCustomField", sort)
                .encode()
                .toUriString();

        ResponseEntity<RestResponsePage<MyEntity4001OutServiceDTO>> responseEntity = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                },
                filter
        );


        return responseEntity.getBody();
    }


    private List<String> getSortFieldName(QueryParameters queryParameters, String fieldName) {
        return queryParameters.getParameters().entrySet().stream()
                .filter(f -> f.getKey().contains("_sort"))
                .filter(f -> f.getValue().contains(fieldName))
                .map(m -> {
                            String[] splitOperation = m.getKey().split("\\.");
                            return splitOperation[splitOperation.length - 1];
                        }
                ).toList();
    }

    private List<String> getFilterFieldName(QueryParameters queryParameters, String fieldName, String searchSpec) {
        return queryParameters.getParameters().entrySet().stream()
                .filter(f -> f.getKey().contains(fieldName + "." + searchSpec))
                .map(Map.Entry::getValue)
                .toList();
    }

    // --8<-- [end:getList]

    @Override
    // --8<-- [start:delete]
    public void delete(BusinessComponent bc) {
        restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityGetStartedMicroservicesDataServerUrl() + "/{id}").build().expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                DELETE, null, Void.class
        );
    }
    // --8<-- [end:delete]


    @Override
    // --8<-- [start:create]
    public MyEntity4001OutServiceDTO create(BusinessComponent bc, MyEntity4001OutServiceDTO entity) {
        entity.setId(null);
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityGetStartedMicroservicesDataServerUrl()).build().normalize().encode().toUriString(),
                POST, new HttpEntity<>(entity), MyEntity4001OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:create]

    @Override
    // --8<-- [start:update]
    public MyEntity4001OutServiceDTO update(BusinessComponent bc, MyEntity4001OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityGetStartedMicroservicesDataServerUrl()).build().normalize().encode().toUriString(),
                PUT, new HttpEntity<>(entity), MyEntity4001OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:update]
}
