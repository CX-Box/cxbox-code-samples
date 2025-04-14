package org.demo.documentation.fields.suggestion.basic.microservice.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3091Service extends VersionAwareResponseService<MyExample3091DTO, MyEntity3091> {

    private final MyEntity3091Repository repository;

    public MyExample3091Service(MyEntity3091Repository repository) {
        super(MyExample3091DTO.class, MyEntity3091.class, null, MyExample3091Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3091DTO> doCreateEntity(MyEntity3091 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3091DTO> doUpdateEntity(MyEntity3091 entity, MyExample3091DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3091DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3091DTO> getActions() {
        return Actions.<MyExample3091DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
