package org.demo.documentation.feature.showcondition.hiddenbc.mainbc;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3184Service extends VersionAwareResponseService<MyExample3184DTO, MyEntity3184> {

    private final MyEntity3184Repository repository;

    public MyExample3184Service(MyEntity3184Repository repository) {
        super(MyExample3184DTO.class, MyEntity3184.class, null, MyExample3184Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3184DTO> doCreateEntity(MyEntity3184 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3184DTO> doUpdateEntity(MyEntity3184 entity, MyExample3184DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3184DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        if (data.isFieldChanged(MyExample3184DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3184DTO> getActions() {
        return Actions.<MyExample3184DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

