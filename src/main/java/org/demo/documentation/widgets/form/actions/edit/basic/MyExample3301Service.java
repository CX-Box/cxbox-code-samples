package org.demo.documentation.widgets.form.actions.edit.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3301Service extends VersionAwareResponseService<MyExample3301DTO, MyEntity3301> {

    private final MyEntity3301Repository repository;

    public MyExample3301Service(MyEntity3301Repository repository) {
        super(MyExample3301DTO.class, MyEntity3301.class, null, MyExample3301Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3301DTO> doCreateEntity(MyEntity3301 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3301DTO> doUpdateEntity(MyEntity3301 entity, MyExample3301DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3301DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3301DTO> getActions() {
        return Actions.<MyExample3301DTO>builder()
                .save(crt -> crt.text("Save"))
                .build();
    }


}

