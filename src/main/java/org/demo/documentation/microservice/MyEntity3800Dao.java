package org.demo.documentation.microservice;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.microservice.utils.IntegrationURLBuilder;
import org.demo.documentation.microservice.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
@RequiredArgsConstructor
public class MyEntity3800Dao extends AbstractAnySourceBaseDAO<MyEntity3800OutServiceDTO> implements AnySourceBaseDAO<MyEntity3800OutServiceDTO> {

    public static final String API_V_1_LOV = "";

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final IntegrationURLBuilder integrationURLBuilder;

    @Override
    public String getId(final MyEntity3800OutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity3800OutServiceDTO entity) {
        entity.setId(id);
    }


    // --8<-- [start:getByIdIgnoringFirstLevelCache]
    @Override
    public MyEntity3800OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV + "/{id}").build()
                        .expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                GET, null, MyEntity3800OutServiceDTO.class
        ).getBody();
    }

    // --8<-- [end:getByIdIgnoringFirstLevelCache]

    // --8<-- [start:getList]
    @Override
    public Page<MyEntity3800OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        String sortKey = "";
        //Page size
        String page = bc.getParameters().getParameter("_page");
        //Limit
        String limit = bc.getParameters().getParameter("_limit");
        //Filter
        Optional<Map.Entry<String, String>> filter = queryParameters.getParameters().entrySet().stream().filter(f -> f.getKey().contains("contains")).findFirst();        //Sorting
        Optional<Map.Entry<String, String>> sort = queryParameters.getParameters().entrySet().stream().filter(f -> f.getKey().contains("sort")).findFirst();
        if (!sort.isEmpty()) {
            String[] splitOperation = sort.get().getKey().split("\\.");
            sortKey = splitOperation[splitOperation.length - 1];
        }

        ResponseEntity<RestResponsePage<MyEntity3800OutServiceDTO>> responseEntity = restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV).toUriString()
                        + "?_page=" + page
                        + "&_limit=" + limit
                        + (sort.isEmpty() ? "" : "&_sort=" + sort.get().getValue() + "&_order=" + sortKey)
                        + (filter.isEmpty() ? "" : "&_filter.field." + filter.get().getKey() + "=" + filter.get().getValue())
                ,
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
                fromUriString(integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV + "/{id}").build().expand(bc.getIdAsLong()).normalize().encode()
                        .toUriString(),
                DELETE, null, Void.class
        );
    }
    // --8<-- [end:delete]



    @Override
    // --8<-- [start:create]
    public  MyEntity3800OutServiceDTO create(BusinessComponent bc, MyEntity3800OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV).build().normalize().encode().toUriString(),
                POST, new HttpEntity<>(entity), MyEntity3800OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:create]

    @Override
    // --8<-- [start:update]
    public MyEntity3800OutServiceDTO update(BusinessComponent bc, MyEntity3800OutServiceDTO entity) {
        return restTemplate.exchange(
                fromUriString(integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV).build().normalize().encode().toUriString(),
                PUT, new HttpEntity<>(entity), MyEntity3800OutServiceDTO.class
        ).getBody();
    }
    // --8<-- [end:update]
}
