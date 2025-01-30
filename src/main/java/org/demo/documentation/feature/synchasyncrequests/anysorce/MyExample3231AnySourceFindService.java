package org.demo.documentation.feature.synchasyncrequests.anysorce;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.synchasyncrequests.enums.MyEntity3231Queue;
import org.demo.documentation.feature.synchasyncrequests.enums.MyEntity3231QueueRepository;
import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum2;
import org.demo.services.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@Service
public class MyExample3231AnySourceFindService extends AnySourceVersionAwareResponseService<MyExample3231AnySourceFindDTO, MyEntity3231AnySourceOutServiceFindDTO> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3231QueueRepository repositoryQueue;

    public MyExample3231AnySourceFindService(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3231QueueRepository repositoryQueue) {
        super(MyExample3231AnySourceFindDTO.class, MyEntity3231AnySourceOutServiceFindDTO.class, MyExample3231AnySourceFindMeta.class, MyEntity3231AnySourceFindDao.class);
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repositoryQueue = repositoryQueue;
    }


    @Override
    protected CreateResult<MyExample3231AnySourceFindDTO> doCreateEntity(MyEntity3231AnySourceOutServiceFindDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3231AnySourceFindDTO> doUpdateEntity(MyEntity3231AnySourceOutServiceFindDTO entity, MyExample3231AnySourceFindDTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3231AnySourceFindDTO_.customField, entity::setCustomField);
        setIfChanged(data, MyExample3231AnySourceFindDTO_.customFieldForm, entity::setCustomFieldForm);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


    @Override
    public Actions<MyExample3231AnySourceFindDTO> getActions() {
        return Actions.<MyExample3231AnySourceFindDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("findClient", "find Data")
                        .scope(ActionScope.RECORD)
                        .withAutoSaveBefore()
                        .invoker((bc, dto) -> {
                             MyEntity3231AnySourceOutServiceFindDTO entityPage = queryDataAndCreateQueue(bc, dto);
                            return new ActionResultDTO<>(entityToDto(bc, entityPage));
                        })
                )
                .build();
    }

    // --8<-- [start:callService]
    private MyEntity3231AnySourceOutServiceFindDTO queryDataAndCreateQueue(BusinessComponent bc, MyExample3231AnySourceFindDTO dto) {
        // call async service
        // callService ()...
        Page<MyEntity3231AnySourceOutServiceFindDTO> entityPage  = callService(dto);
        Optional<MyEntity3231AnySourceOutServiceFindDTO>  entity = entityPage.get().findFirst();
        // create queue
        MyEntity3231Queue myEntity3231Queue = new MyEntity3231Queue().setCustomFieldDictionary(StatusEnum2.IN_PROGRESS).setEntityId(bc.getId());
        repositoryQueue.save(myEntity3231Queue);
        return entity.get();
    }
    // --8<-- [end:callService]

    // --8<-- [start:callService]
    public Page<MyEntity3231AnySourceOutServiceFindDTO> callService( MyExample3231AnySourceFindDTO dto) {


        Optional<String> filter = Optional.ofNullable(dto.getCustomField());

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(integrationConfig.getDataServerUrl())
                .queryParam("number", 1)
                .queryParam("size", 10)
                .queryParamIfPresent("filterCustomField", filter)
                .encode()
                .toUriString();

        ResponseEntity<RestResponsePage<MyEntity3231AnySourceOutServiceFindDTO>> responseEntity = restTemplate.exchange(
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