package org.demo.documentation.widgets.list.actions.create.withwidget;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3064Service extends VersionAwareResponseService<MyExample3064DTO, MyEntity3064> {

    private final MyEntity3064Repository repository;

    public MyExample3064Service(MyEntity3064Repository repository) {
        super(MyExample3064DTO.class, MyEntity3064.class, null, MyExample3064Meta.class);
        this.repository = repository;
    }

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

    @Override
    public Actions<MyExample3064DTO> getActions() {
        return Actions.<MyExample3064DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}

