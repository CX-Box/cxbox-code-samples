package org.demo.documentation.feature.microservice.nextandprevioussmart;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.services.utils.IntegrationURLBuilder;
import org.demo.services.utils.RestResponsePage;
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
public class MyEntity3861Dao extends AbstractAnySourceBaseDAO<MyEntity3861OutServiceDTO> implements AnySourceBaseDAO<MyEntity3861OutServiceDTO> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final IntegrationURLBuilder integrationURLBuilder;

    @Override
    public String getId(final MyEntity3861OutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity3861OutServiceDTO entity) {
        entity.setId(id);
    }


    // --8<-- [start:getByIdIgnoringFirstLevelCache]
    @Override
    public MyEntity3861OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getNextAndPreviousMicroservicesDataServerUrl() + "/{id}").build()
                        .expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                GET, null, MyEntity3861OutServiceDTO.class
        ).getBody();
    }

    // --8<-- [end:getByIdIgnoringFirstLevelCache]

    // --8<-- [start:getList]
    @Override
    public Page<MyEntity3861OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {

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

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getNextAndPreviousMicroservicesDataServerUrl())
                .queryParam("number", page)
                .queryParam("size", limit)
                .queryParamIfPresent("filterCustomField", filter)
                .queryParamIfPresent("sortCustomField", sort)
                .encode()
                .toUriString();

        ResponseEntity<RestResponsePage<MyEntity3861OutServiceDTO>> responseEntity = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                },
                filter
        );
        return responseEntity.getBody();
    }
    // --8<-- [end:getList]


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

    @Override
    // --8<-- [start:delete]
    public void delete(BusinessComponent bc) {
        restTemplate.exchange(
                fromUriString(integrationConfig.getNextAndPreviousMicroservicesDataServerUrl()  + "/{id}").build().expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                DELETE, null, Void.class
        );
    }
    // --8<-- [end:delete]


    @Override
    // --8<-- [start:create]
    public MyEntity3861OutServiceDTO create(BusinessComponent bc, MyEntity3861OutServiceDTO entity) {
        entity.setId(null);
        return restTemplate.exchange(
                fromUriString(integrationConfig.getNextAndPreviousMicroservicesDataServerUrl()).build().normalize().encode().toUriString(),
                POST, new HttpEntity<>(entity), MyEntity3861OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:create]

    @Override
    // --8<-- [start:update]
    public MyEntity3861OutServiceDTO update(BusinessComponent bc, MyEntity3861OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getNextAndPreviousMicroservicesDataServerUrl()).build().normalize().encode().toUriString(),
                PUT, new HttpEntity<>(entity), MyEntity3861OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:update]

    @Override
    // --8<-- [start:update]
    public long count(BusinessComponent bc) {
        return  -1;
    }

}
