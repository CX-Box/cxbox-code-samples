package org.demo.documentation.widgets.list.showcondition.byparententity.parent;

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
public class MyExample3100Service extends VersionAwareResponseService<MyExample3100DTO, MyEntity3100> {

    private final MyEntity3100Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3100Meta> meta = MyExample3100Meta.class;

    @Override
    protected CreateResult<MyExample3100DTO> doCreateEntity(MyEntity3100 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3100DTO> doUpdateEntity(MyEntity3100 entity, MyExample3100DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3100DTO_.customFieldNumber, entity::setCustomFieldNumber);
        if (data.isFieldChanged(MyExample3100DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3100DTO> getActions() {
        return Actions.<MyExample3100DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]
}