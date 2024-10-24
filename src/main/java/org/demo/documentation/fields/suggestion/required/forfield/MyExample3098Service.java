package org.demo.documentation.fields.suggestion.required.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3098Service extends VersionAwareResponseService<MyExample3098DTO, MyEntity3098> {

    private final MyEntity3098Repository repository;

    public MyExample3098Service(MyEntity3098Repository repository) {
        super(MyExample3098DTO.class, MyEntity3098.class, null, MyExample3098Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3098DTO> doCreateEntity(MyEntity3098 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3098DTO> doUpdateEntity(MyEntity3098 entity, MyExample3098DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3098DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3098DTO> getActions() {
        return Actions.<MyExample3098DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
