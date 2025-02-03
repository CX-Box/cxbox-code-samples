package org.demo.documentation.feature.synchasyncrequests.example2;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.synchasyncrequests.CxboxMyExample3231Controller;
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
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("createAndFind", "create andFind")
                        .scope(ActionScope.BC)
                        .invoker((bc, dto) -> {
                            MyEntity3232 myEntity3232 = new MyEntity3232();
                            myEntity3232.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity3232);
                            findInExternalSystemAsync(myEntity3232);
                            return new ActionResultDTO<MyExample3232DTO>().setAction(
                                    PostAction.drillDownAndWaitUntil(
                                            "/screen/myexample3231/view/myexample3232form/"+
                                                    CxboxMyExample3231Controller.myexample3232+"/"+ myEntity3232.getId(),
                                            CxboxMyExample3231Controller.myexample3232,
                                            MyExample3232DTO_.statusResponse,
                                            StatusEnum.DONE
                                    )         .inProgressMessage("In Progress Message")
                                            .successMessage("Success Message")
                                            .timeoutMessage("Timeout Message")
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(100)).build());
                        })
                )
                .build();
    }

    // --8<-- [end:getActions]

    // --8<-- [start:findInExternalSystem]
    protected void findInExternalSystemAsync(MyEntity3232 myEntity3232){

        Optional<MyEntity3231AnySourceOutServiceDTO> entityExternal = callService().get().findFirst();
        if (entityExternal.isPresent()) {
            myEntity3232.setCustomField(entityExternal.get().getCustomField());
        }
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


