package org.demo.documentation.fields.time.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3508Service extends VersionAwareResponseService<MyExample3508DTO, MyEntity3508> {

    private final MyEntity3508Repository repository;

    public MyExample3508Service(MyEntity3508Repository repository) {
        super(MyExample3508DTO.class, MyEntity3508.class, null, MyExample3508Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3508DTO> doCreateEntity(MyEntity3508 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3508DTO> doUpdateEntity(MyEntity3508 entity, MyExample3508DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3508DTO_.customField, entity::setCustomField);
        setIfChanged(data, MyExample3508DTO_.customFieldh, entity::setCustomFieldh);
        setIfChanged(data, MyExample3508DTO_.customFieldhmm, entity::setCustomFieldhmm);
        setIfChanged(data, MyExample3508DTO_.customFieldhmmA, entity::setCustomFieldhmmA);
        setIfChanged(data, MyExample3508DTO_.customFieldhmmssA, entity::setCustomFieldhmmssA);
        setIfChanged(data, MyExample3508DTO_.customFieldmm, entity::setCustomFieldmm);
        setIfChanged(data, MyExample3508DTO_.customFieldmmss, entity::setCustomFieldmmss);
        setIfChanged(data, MyExample3508DTO_.customFieldss, entity::setCustomFieldss);


        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3508DTO> getActions() {
        return Actions.<MyExample3508DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}