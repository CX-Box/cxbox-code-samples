package org.demo.documentation.fields.time.validationbusinessex;

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
public class MyExample4101Service extends VersionAwareResponseService<MyExample4101DTO, MyEntity4101> {

    private final MyEntity4101Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4101Meta> meta = MyExample4101Meta.class;

    @Override
    protected CreateResult<MyExample4101DTO> doCreateEntity(MyEntity4101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4101DTO> doUpdateEntity(MyEntity4101 entity, MyExample4101DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample4101DTO_.customField, entity::setCustomField);

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4101DTO> getActions() {
        return Actions.<MyExample4101DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]
}