package org.demo.documentation.widgets.form.actions.create.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3300Service extends VersionAwareResponseService<MyExample3300DTO, MyEntity3300> {

    private final MyEntity3300Repository repository;

    public MyExample3300Service(MyEntity3300Repository repository) {
        super(MyExample3300DTO.class, MyEntity3300.class, null, MyExample3300Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3300DTO> doCreateEntity(MyEntity3300 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3300DTO> doUpdateEntity(MyEntity3300 entity, MyExample3300DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3300DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3300DTO> getActions() {
        return Actions.<MyExample3300DTO>builder()
                .create(crt -> crt.text("Add").available(bc -> true))
                .save(sv -> sv.text("Save").available(bc -> true))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }
    // --8<-- [end:getActions]

}

