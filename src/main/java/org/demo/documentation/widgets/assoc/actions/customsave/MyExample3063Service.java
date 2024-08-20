package org.demo.documentation.widgets.assoc.actions.customsave;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3063Service extends VersionAwareResponseService<MyExample3063DTO, MyEntity3063> {

    private final MyEntity3063Repository repository;

    public MyExample3063Service(MyEntity3063Repository repository) {
        super(MyExample3063DTO.class, MyEntity3063.class, null, MyExample3063Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3063DTO> doCreateEntity(MyEntity3063 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3063DTO> doUpdateEntity(MyEntity3063 entity, MyExample3063DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3063DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3063DTO> getActions() {
        return Actions.<MyExample3063DTO>builder()
                .action("custom save", "Save")
                .invoker(this::customSave)
                .add()
                .build();
    }
    // --8<-- [end:getActions]

    private ActionResultDTO<MyExample3063DTO> customSave(final BusinessComponent bc, final MyExample3063DTO dto) {
        return null;
    }


}

