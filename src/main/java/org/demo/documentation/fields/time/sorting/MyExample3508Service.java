package org.demo.documentation.fields.time.sorting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3508Service extends VersionAwareResponseService<MyExample3508DTO, MyEntity3508> {

    private final MyEntity3508Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3508Meta> meta = MyExample3508Meta.class;

    @Override
    protected CreateResult<MyExample3508DTO> doCreateEntity(MyEntity3508 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3508DTO> doUpdateEntity(MyEntity3508 entity, MyExample3508DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3508DTO_.customFieldhA, entity::setCustomFieldhA);
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
               .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}