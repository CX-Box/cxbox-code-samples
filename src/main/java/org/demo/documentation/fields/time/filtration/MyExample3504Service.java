package org.demo.documentation.fields.time.filtration;

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
public class MyExample3504Service extends VersionAwareResponseService<MyExample3504DTO, MyEntity3504> {

    private final MyEntity3504Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3504Meta> meta = MyExample3504Meta.class;

    @Override
    protected CreateResult<MyExample3504DTO> doCreateEntity(MyEntity3504 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3504DTO> doUpdateEntity(MyEntity3504 entity, MyExample3504DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3504DTO_.customFieldhA, entity::setCustomFieldhA);
        setIfChanged(data, MyExample3504DTO_.customField, entity::setCustomField);
        setIfChanged(data, MyExample3504DTO_.customFieldh, entity::setCustomFieldh);
        setIfChanged(data, MyExample3504DTO_.customFieldhmm, entity::setCustomFieldhmm);
        setIfChanged(data, MyExample3504DTO_.customFieldhmmA, entity::setCustomFieldhmmA);
        setIfChanged(data, MyExample3504DTO_.customFieldhmmssA, entity::setCustomFieldhmmssA);
        setIfChanged(data, MyExample3504DTO_.customFieldmm, entity::setCustomFieldmm);
        setIfChanged(data, MyExample3504DTO_.customFieldmmss, entity::setCustomFieldmmss);
        setIfChanged(data, MyExample3504DTO_.customFieldss, entity::setCustomFieldss);

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3504DTO> getActions() {
        return Actions.<MyExample3504DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}