package org.demo.documentation.widgets.form.actions.cancelcreate.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3182Service extends VersionAwareResponseService<MyExample3182DTO, MyEntity3182> {

    private final MyEntity3182Repository repository;

    public MyExample3182Service(MyEntity3182Repository repository) {
        super(MyExample3182DTO.class, MyEntity3182.class, null, MyExample3182Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3182DTO> doCreateEntity(MyEntity3182 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3182DTO> doUpdateEntity(MyEntity3182 entity, MyExample3182DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3182DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3182DTO> getActions() {
        return Actions.<MyExample3182DTO>builder()
                .create(crt -> crt.text("Add"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }
    // --8<-- [end:getActions]

}

