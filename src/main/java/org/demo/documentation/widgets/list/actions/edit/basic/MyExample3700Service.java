package org.demo.documentation.widgets.list.actions.edit.basic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3700Service extends VersionAwareResponseService<MyExample3700DTO, MyEntity3700> {

    private final MyEntity3700Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3700Meta> meta = MyExample3700Meta.class;

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
               .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}