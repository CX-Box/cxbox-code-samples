package org.demo.documentation.feature.postaction.waituntil.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.postaction.anysorce.MyEntity3233AnySourceOutServiceDTO;
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
public class MyExample3233Service extends VersionAwareResponseService<MyExample3233DTO, MyEntity3233> {
    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3233Repository repository;

    public MyExample3233Service(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3233Repository repository) {
        super(MyExample3233DTO.class, MyEntity3233.class, null, MyExample3233Meta.class);
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3233DTO> doCreateEntity(MyEntity3233 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3233DTO> doUpdateEntity(MyEntity3233 entity, MyExample3233DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3233DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3233DTO> getActions() {
        return Actions.<MyExample3233DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("searchData", "Search data")
                        .scope(ActionScope.RECORD)
                        .invoker((bc, dto) -> {
                            MyEntity3233 myEntity  = repository.findById(bc.getIdAsLong()).orElseThrow();
                            myEntity.setStatusResponse(StatusEnum.IN_PROGRESS);
                            repository.save(myEntity);
                            findInExternalSystemAsync(bc, dto);
                            return new ActionResultDTO<MyExample3233DTO>().setAction(
                                    PostAction.waitUntil(
                                                    MyExample3233DTO_.statusResponse,
                                                    StatusEnum.DONE)
                                            .timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
                        })
                ).build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:findInExternalSystem]
    protected void findInExternalSystemAsync(BusinessComponent bc, MyExample3233DTO dto){

        MyEntity3233 myEntity = repository.findById(bc.getIdAsLong()).orElseThrow();
        Optional<MyEntity3233AnySourceOutServiceDTO> entityExternal = callService(dto).get().findFirst();
        myEntity.setCustomField("");
        entityExternal.ifPresent(myEntity3231AnySourceOutServiceDTO -> myEntity.setCustomField(myEntity3231AnySourceOutServiceDTO.getCustomField()));
        repository.save(myEntity);
    }
    // --8<-- [end:findInExternalSystem]

    // --8<-- [start:callService]
    public Page<MyEntity3233AnySourceOutServiceDTO> callService(MyExample3233DTO dto) {

        Optional<String> filter = Optional.ofNullable(dto.getCustomFieldForm());

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(
                        integrationConfig.getDataServerUrl())
                .queryParam("number", 1)
                .queryParam("size", 1)
                .queryParamIfPresent("filterEqualsCustomField", filter)
                .encode()
                .toUriString();

        ResponseEntity<RestResponsePage<MyEntity3233AnySourceOutServiceDTO>> responseEntity = restTemplate.exchange(
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

