package org.demo.documentation.widgets.list.actions.create.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3059Service extends VersionAwareResponseService<MyExample3059DTO, MyEntity3059> {

    private final MyEntity3059Repository repository;

    public MyExample3059Service(MyEntity3059Repository repository) {
        super(MyExample3059DTO.class, MyEntity3059.class, null, MyExample3059Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3059DTO> doCreateEntity(MyEntity3059 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3059DTO> doUpdateEntity(MyEntity3059 entity, MyExample3059DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3059DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3059DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3059DTO> getActions() {
        return Actions.<MyExample3059DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}