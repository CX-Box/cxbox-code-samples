package org.demo.documentation.feature.postaction.drilldownandwaituntil.basic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
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

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3234Service extends VersionAwareResponseService<MyExample3234DTO, MyEntity3234> {
    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;
    private final MyEntity3234Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3234Meta> meta = MyExample3234Meta.class;

    @Override
    protected CreateResult<MyExample3234DTO> doCreateEntity(MyEntity3234 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3234DTO> doUpdateEntity(MyEntity3234 entity, MyExample3234DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3234DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3234DTO> getActions() {
        return Actions.<MyExample3234DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("createAndSearch", "Create and search")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3234 myEntity = new MyEntity3234();
                            myEntity.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity);
                            findInExternalSystemAsync(myEntity,dto);
                            return new ActionResultDTO<MyExample3234DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                                    "/screen/myexample3231/view/myexample3234resultform/" +
                                                            CxboxMyExample3231Controller.myexample3234 + "/" + myEntity.getId(),
                                                    CxboxMyExample3231Controller.myexample3234,
                                                    MyExample3234DTO_.statusResponse,
                                                    StatusEnum.DONE
                                            )
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                )
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .action("gotofind", "Go to Find")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3234DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3231/view/myexample3234form"
                                    ));
                        })
                )
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:findInExternalSystem]
    protected void findInExternalSystemAsync(MyEntity3234 myEntity, MyExample3234DTO dto) {
        Optional<MyEntity3231AnySourceOutServiceDTO> entityExternal = callService(dto).get().findFirst();
        myEntity.setCustomFieldForm("");
        myEntity.setCustomField("");
        entityExternal.ifPresent(myEntity3231AnySourceOutServiceDTO ->
                myEntity.setCustomField(myEntity3231AnySourceOutServiceDTO.getCustomField()));
        repository.save(myEntity);
    }
    // --8<-- [end:findInExternalSystem]

    // --8<-- [start:callService]
    public Page<MyEntity3231AnySourceOutServiceDTO> callService(MyExample3234DTO dto) {

        Optional<String> filter = Optional.ofNullable(dto.getCustomFieldForm());

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDataServerUrl())
                .queryParam("number", 1)
                .queryParam("size", 1)
                .queryParamIfPresent("filterEqualsCustomField", filter)
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

