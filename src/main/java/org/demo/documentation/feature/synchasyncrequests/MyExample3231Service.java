package org.demo.documentation.feature.synchasyncrequests;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.synchasyncrequests.anysorce.MyEntity3231AnySourceOutServiceDTO;
import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;
import org.demo.services.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MyExample3231Service extends VersionAwareResponseService<MyExample3231DTO, MyEntity3231> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3231Repository repository;

    private final MyEntity3231QueueRepository repositoryQueue;

    public MyExample3231Service(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3231Repository repository, MyEntity3231QueueRepository repositoryQueue) {
        super(MyExample3231DTO.class, MyEntity3231.class, null, MyExample3231Meta.class);
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.repositoryQueue = repositoryQueue;
    }

    @Override
    protected CreateResult<MyExample3231DTO> doCreateEntity(MyEntity3231 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3231DTO> doUpdateEntity(MyEntity3231 entity, MyExample3231DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3231DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3231DTO> getActions() {
        return Actions.<MyExample3231DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("findClient", "find Data")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            callService(bc, dto);
                            return new ActionResultDTO<>();
                        })
                )
                .build();
    }

    // --8<-- [start:callService]
    private void queryData(BusinessComponent bc, MyExample3231DTO dto) {
        // call async service
        // callService ()...
        callService(bc, dto);
        // create queue
        MyEntity3231Queue myEntity3231Queue = new MyEntity3231Queue().setCustomFieldDictionary(StatusEnum.IN_PROGRESS).setEntityId(bc.getId());
        repositoryQueue.save(myEntity3231Queue);
    }
    // --8<-- [end:callService]

    // --8<-- [start:callService]
    public Page<MyEntity3231AnySourceOutServiceDTO> callService(final BusinessComponent bc, MyExample3231DTO dto) {

        String page = bc.getParameters().getParameter("_page");
        String limit = bc.getParameters().getParameter("_limit");
        Optional<String> filter = ("customField.contains=" + dto.getCustomField()).describeConstable();

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDataServerUrl())
                .queryParam("number", page)
                .queryParam("size", limit)
                .queryParamIfPresent("filterCustomField",filter)
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

