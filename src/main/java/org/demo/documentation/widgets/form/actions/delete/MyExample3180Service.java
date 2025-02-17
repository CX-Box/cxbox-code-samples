package org.demo.documentation.widgets.form.actions.delete;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3180Service extends VersionAwareResponseService<MyExample3180DTO, MyEntity3180> {

    private final MyEntity3180Repository repository;

    public MyExample3180Service(MyEntity3180Repository repository) {
        super(MyExample3180DTO.class, MyEntity3180.class, null, MyExample3180Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3180DTO> doCreateEntity(MyEntity3180 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3180DTO> doUpdateEntity(MyEntity3180 entity, MyExample3180DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3180DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3180DTO> getActions() {
        return Actions.<MyExample3180DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

