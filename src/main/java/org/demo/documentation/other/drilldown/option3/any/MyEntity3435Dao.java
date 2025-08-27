package org.demo.documentation.other.drilldown.option3.any;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.cxbox.core.util.session.SessionService;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.other.drilldown.option3.CxboxMyExample3430Controller;
import org.demo.documentation.other.drilldown.option3.forsearch.MyEntity3431;
import org.demo.documentation.other.drilldown.option3.forsearch.MyEntity3431Repository;
import org.demo.services.utils.IntegrationURLBuilder;
import org.demo.services.utils.RestResponsePage;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;


@Service
@RequiredArgsConstructor
public class MyEntity3435Dao extends AbstractAnySourceBaseDAO<MyEntity3435OutServiceDTO> implements AnySourceBaseDAO<MyEntity3435OutServiceDTO> {
    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final IntegrationURLBuilder integrationURLBuilder;

    private final SessionService sessionService;

    private final MyEntity3431Repository searchRepository;

    @Override
    public String getId(final MyEntity3435OutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity3435OutServiceDTO entity) {
        entity.setId(id);
    }


    // --8<-- [start:getByIdIgnoringFirstLevelCache]
    @Override
    public MyEntity3435OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getDataServerUrl() + "/{id}").build()
                        .expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                GET, null, MyEntity3435OutServiceDTO.class
        ).getBody();
    }

    // --8<-- [end:getByIdIgnoringFirstLevelCache]

    // --8<-- [start:getList]
    @Override
    public Page<MyEntity3435OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {

        //Page size
        String page = bc.getParameters().getParameter("_page");

        //Limit
        String limit = bc.getParameters().getParameter("_limit");
        final Long userId = sessionService.getSessionUser().getId();
        final String taskId = bc.getHierarchy().getId(CxboxMyExample3430Controller.myexample3430.getName());
        final Optional<MyEntity3431> optionalFilter = searchRepository.findByUserId(sessionService.getSessionUser().getId());
        if (optionalFilter.isEmpty()) {
            return new PageImpl<>(new ArrayList<>());
        }
        //Filter
        Optional<String> filter = optionalFilter.isEmpty() ? Optional.empty() : (optionalFilter.get().getCustomField()).describeConstable();

        //Sorting
        List<String> sortCustomField = getSortFieldName(queryParameters, "customField");
        Optional<String> sort = sortCustomField.isEmpty() ? Optional.empty() : Optional.of(sortCustomField.get(0));

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDataServerUrl())
                .queryParam("number", page)
                .queryParam("size", limit)
                .queryParamIfPresent("filterCustomField", filter)
                .queryParamIfPresent("sortCustomField", sort)
                .encode()
                .toUriString();

        ResponseEntity<RestResponsePage<MyEntity3435OutServiceDTO>> responseEntity = restTemplate.exchange(
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
                fromUriString(integrationConfig.getDataServerUrl() + "/{id}").build().expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                DELETE, null, Void.class
        );
    }
    // --8<-- [end:delete]


    @Override
    // --8<-- [start:create]
    public MyEntity3435OutServiceDTO create(BusinessComponent bc, MyEntity3435OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getDataServerUrl()).build().normalize().encode().toUriString(),
                POST, new HttpEntity<>(entity), MyEntity3435OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:create]

    @Override
    // --8<-- [start:update]
    public MyEntity3435OutServiceDTO update(BusinessComponent bc, MyEntity3435OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getDataServerUrl()).build().normalize().encode().toUriString(),
                PUT, new HttpEntity<>(entity), MyEntity3435OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:update]

}