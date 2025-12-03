package org.demo.documentation.widgets.list.actions.create.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3064Service extends VersionAwareResponseService<MyExample3064DTO, MyEntity3064> {

    private final MyEntity3064Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3064Meta> meta = MyExample3064Meta.class;

    @Override
    protected CreateResult<MyExample3064DTO> doCreateEntity(MyEntity3064 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3064DTO> doUpdateEntity(MyEntity3064 entity, MyExample3064DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3064DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3064DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3064DTO> getActions() {
        return Actions.<MyExample3064DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

