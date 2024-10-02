package org.demo.documentation.fields.suggestion.colorconst.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3094Service extends VersionAwareResponseService<MyExample3094DTO, MyEntity3094> {

    private final MyEntity3094Repository repository;

    public MyExample3094Service(MyEntity3094Repository repository) {
        super(MyExample3094DTO.class, MyEntity3094.class, null, MyExample3094Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3094DTO> doCreateEntity(MyEntity3094 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3094DTO> doUpdateEntity(MyEntity3094 entity, MyExample3094DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3094DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3094DTO> getActions() {
        return Actions.<MyExample3094DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}
