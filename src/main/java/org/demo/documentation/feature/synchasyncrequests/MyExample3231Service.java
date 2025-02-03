package org.demo.documentation.feature.synchasyncrequests;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
import java.util.Optional;

@Service
public class MyExample3231Service extends VersionAwareResponseService<MyExample3231DTO, MyEntity3231> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3231Repository repository;

    public MyExample3231Service(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3231Repository repository) {
        super(MyExample3231DTO.class, MyEntity3231.class, null, MyExample3231Meta.class);
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3231DTO> doCreateEntity(MyEntity3231 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3231DTO> doUpdateEntity(MyEntity3231 entity, MyExample3231DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3231DTO_.customFieldForm, entity::setCustomFieldForm);
        setIfChanged(data, MyExample3231DTO_.statusResponse, entity::setStatusResponse);
        if (data.isFieldChanged(MyExample3231DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3231DTO> getActions() {
        return Actions.<MyExample3231DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("findClient", "Find data with all message")
                        .scope(ActionScope.RECORD)
                        .invoker((bc, dto) -> {
                            MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
                            myEntity3231.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3231);
                            findInExternalSystemAsync(bc, dto);
                               return new ActionResultDTO<MyExample3231DTO>().setAction(
                                    PostAction.waitUntil(
                                            MyExample3231DTO_.statusResponse,
                                            StatusEnum.DONE)
                                            .timeoutMessage("Timeout Message")
                                            .inProgressMessage("In Progress Message")
                                            .successMessage("Success Message")
                                            .timeoutMessage("Timeout Message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(100)).build());
                        })
                )
                .action(act -> act
                        .action("findClientWithSuccessMessage", "Find data with Success message")
                        .scope(ActionScope.RECORD)
                        .invoker((bc, dto) -> {
                            MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
                            myEntity3231.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3231);
                            findInExternalSystemAsync(bc, dto);
                            return new ActionResultDTO<MyExample3231DTO>().setAction(
                                    PostAction.waitUntil(
                                                    MyExample3231DTO_.statusResponse,
                                                    StatusEnum.DONE)
                                            .successMessage("Success Message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(100)).build());
                        })
                )
                .action(act -> act
                        .action("findClientWithoutCustomMessage", "Find data with without custom message")
                        .scope(ActionScope.RECORD)
                        .invoker((bc, dto) -> {
                            MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
                            myEntity3231.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3231);
                            findInExternalSystemAsync(bc, dto);
                            return new ActionResultDTO<MyExample3231DTO>().setAction(
                                    PostAction.waitUntil(
                                                    MyExample3231DTO_.statusResponse,
                                                    StatusEnum.DONE)
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(100)).build());
                        })
                )
                .action(act -> act
                        .action("findClientWithInProgressCustomMessage", "Find data with in progress message")
                        .scope(ActionScope.RECORD)
                        .invoker((bc, dto) -> {
                            MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
                            myEntity3231.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3231);
                            findInExternalSystemAsync(bc, dto);
                            return new ActionResultDTO<MyExample3231DTO>().setAction(
                                    PostAction.waitUntil(
                                                    MyExample3231DTO_.statusResponse,
                                                    StatusEnum.DONE)
                                            .inProgressMessage("In Progress Message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(100)).build());
                        })
                )
                .action(act -> act
                        .action("findClientWithTimeoutCustomMessage", "Find data with timeout message")
                        .scope(ActionScope.RECORD)
                        .invoker((bc, dto) -> {
                            MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
                            myEntity3231.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3231);
                            findInExternalSystemAsync(bc, dto);
                            return new ActionResultDTO<MyExample3231DTO>().setAction(
                                    PostAction.waitUntil(
                                                    MyExample3231DTO_.statusResponse,
                                                    StatusEnum.DONE)
                                            .timeoutMessage("Timeout Message")
                                            .timeoutMaxRequests(1).timeout(Duration.ofSeconds(10)).build());
                        })
                )
                .build();
    }

    // --8<-- [end:getActions]

    // --8<-- [start:findInExternalSystem]
    protected void findInExternalSystemAsync(BusinessComponent bc, MyExample3231DTO dto){

        MyEntity3231 myEntity3231 = repository.findById(bc.getIdAsLong()).orElseThrow();
        Optional<MyEntity3231AnySourceOutServiceDTO> entityExternal = callService(dto).get().findFirst();
        if (entityExternal.isPresent()) {
            myEntity3231.setCustomField(entityExternal.get().getCustomField());
        }
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

