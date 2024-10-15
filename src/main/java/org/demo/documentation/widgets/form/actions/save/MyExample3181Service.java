package org.demo.documentation.widgets.form.actions.save;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3181Service extends VersionAwareResponseService<MyExample3181DTO, MyEntity3181> {

    private final MyEntity3181Repository repository;

    public MyExample3181Service(MyEntity3181Repository repository) {
        super(MyExample3181DTO.class, MyEntity3181.class, null, MyExample3181Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3181DTO> doCreateEntity(MyEntity3181 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3181DTO> doUpdateEntity(MyEntity3181 entity, MyExample3181DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3181DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3181DTO> getActions() {
        return Actions.<MyExample3181DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]

}

