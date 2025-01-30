package org.demo.documentation.feature.synchasyncrequests.anysorce;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.feature.synchasyncrequests.enums.MyEntity3231QueueRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MyExample3231AnySourceService extends AnySourceVersionAwareResponseService<MyExample3231AnySourceDTO, MyEntity3231AnySourceOutServiceDTO> {

    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final MyEntity3231QueueRepository repositoryQueue;

    public MyExample3231AnySourceService(IntegrationConfiguration integrationConfig, RestTemplate restTemplate, MyEntity3231QueueRepository repositoryQueue) {
        super(MyExample3231AnySourceDTO.class, MyEntity3231AnySourceOutServiceDTO.class, MyExample3231AnySourceMeta.class, MyEntity3231AnySourceDao.class);
        this.integrationConfig = integrationConfig;
        this.restTemplate = restTemplate;
        this.repositoryQueue = repositoryQueue;
    }


    @Override
    protected CreateResult<MyExample3231AnySourceDTO> doCreateEntity(MyEntity3231AnySourceOutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3231AnySourceDTO> doUpdateEntity(MyEntity3231AnySourceOutServiceDTO entity, MyExample3231AnySourceDTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3231AnySourceDTO> getActions() {
        return Actions.<MyExample3231AnySourceDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .build();
    }

}