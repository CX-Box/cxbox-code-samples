package org.demo.documentation.widgets.list.actions.edit.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3700Service extends VersionAwareResponseService<MyExample3700DTO, MyEntity3700> {

    private final MyEntity3700Repository repository;

    public MyExample3700Service(MyEntity3700Repository repository) {
        super(MyExample3700DTO.class, MyEntity3700.class, null, MyExample3700Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3700DTO> doCreateEntity(MyEntity3700 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3700DTO> doUpdateEntity(MyEntity3700 entity, MyExample3700DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3700DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3700DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3700DTO> getActions() {
        return Actions.<MyExample3700DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]
}