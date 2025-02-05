package org.demo.documentation.feature.postaction.drilldownandwaituntil;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.postaction.CxboxMyExample3231Controller;
import org.demo.documentation.feature.postaction.anysorce.MyEntity3231AnySourceOutServiceDTO;
import org.demo.documentation.feature.postaction.enums.StatusEnum;
import org.demo.services.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
import java.util.Optional;

@Service
public class MyExample3232Service extends VersionAwareResponseService<MyExample3232DTO, MyEntity3232> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3232Repository repository;

    public MyExample3232Service(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3232Repository repository) {
        super(MyExample3232DTO.class, MyEntity3232.class, null, MyExample3232Meta.class);
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3232DTO> doCreateEntity(MyEntity3232 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3232DTO> doUpdateEntity(MyEntity3232 entity, MyExample3232DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3232DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3232DTO> getActions() {
        return Actions.<MyExample3232DTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("createAndSearchWithoutCustomMessageBoolean", "Create and search without custom message with boolean field")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3232resultform/" +
                                                            CxboxMyExample3231Controller.myexample3232 + "/" + myEntity3232.getId(),
                                                    CxboxMyExample3231Controller.myexample3232,
                                                    MyExample3232DTO_.statusResponseFlag,
                                                    true
                                            )
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                )
                .action(act -> act
                        .action("createAndSearchWithoutCustomMessage", "Create and search without custom message")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3232resultform/" +
                                                            CxboxMyExample3231Controller.myexample3232 + "/" + myEntity3232.getId(),
                                                    CxboxMyExample3231Controller.myexample3232,
                                                    MyExample3232DTO_.statusResponse,
                                                    StatusEnum.DONE
                                            )
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                )
                .action(act -> act
                        .action("createAndSearchWithCustomMessage", "Create and search with all custom message")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3232resultform/" +
                                                            CxboxMyExample3231Controller.myexample3232 + "/" + myEntity3232.getId(),
                                                    CxboxMyExample3231Controller.myexample3232,
                                                    MyExample3232DTO_.statusResponse,
                                                    StatusEnum.DONE
                                            )
                                            .inProgressMessage("In Progress custom message")
                                            .successMessage("Success custom message")
                                            .timeoutMessage("Timeout custom message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                )
                .action(act -> act
                        .action("createAndSearchWithSuccessCustomMessage", "Create and search with `Success` custom message")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3232resultform/" +
                                                            CxboxMyExample3231Controller.myexample3232 + "/" + myEntity3232.getId(),
                                                    CxboxMyExample3231Controller.myexample3232,
                                                    MyExample3232DTO_.statusResponse,
                                                    StatusEnum.DONE
                                            )
                                            .successMessage("Success custom message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                )
                .action(act -> act
                        .action("createAndSearchWithInProgressCustomMessage", "Create and search with `In progress` custom message")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3232resultform/" +
                                                            CxboxMyExample3231Controller.myexample3232 + "/" + myEntity3232.getId(),
                                                    CxboxMyExample3231Controller.myexample3232,
                                                    MyExample3232DTO_.statusResponse,
                                                    StatusEnum.DONE
                                            )
                                            .inProgressMessage("In Progress custom message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                )
                .action(act -> act
                        .action("createAndSearchWithTimeoutCustomMessage", "Create and search with `Timeout` custom message")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3232resultform/" +
                                                            CxboxMyExample3231Controller.myexample3232 + "/" + myEntity3232.getId(),
                                                    CxboxMyExample3231Controller.myexample3232,
                                                    MyExample3232DTO_.statusResponse,
                                                    StatusEnum.DONE
                                            )
                                            .timeoutMessage("Timeout custom message")
                                            .timeoutMaxRequests(1).timeout(Duration.ofSeconds(1)).build());
                        })
                )

                .build();
    }

    // --8<-- [end:getActions]

    // --8<-- [start:findInExternalSystem]
    protected void findInExternalSystemAsync(MyEntity3232 myEntity3232) {

        Optional<MyEntity3231AnySourceOutServiceDTO> entityExternal = callService().get().findFirst();
        entityExternal.ifPresent(myEntity3231AnySourceOutServiceDTO ->
                myEntity3232.setCustomField(myEntity3231AnySourceOutServiceDTO.getCustomField()));
        repository.save(myEntity3232);
    }
    // --8<-- [end:findInExternalSystem]

    // --8<-- [start:callService]
    public Page<MyEntity3231AnySourceOutServiceDTO> callService() {

        Optional<String> filter = Optional.ofNullable("custom Field 3");

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


