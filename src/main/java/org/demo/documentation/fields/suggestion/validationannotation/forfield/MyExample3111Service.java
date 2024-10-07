package org.demo.documentation.fields.suggestion.validationannotation.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3111Service extends VersionAwareResponseService<MyExample3111DTO, MyEntity3111> {

    private final MyEntity3111Repository repository;

    public MyExample3111Service(MyEntity3111Repository repository) {
        super(MyExample3111DTO.class, MyEntity3111.class, null, MyExample3111Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3111DTO> doCreateEntity(MyEntity3111 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3111DTO> doUpdateEntity(MyEntity3111 entity, MyExample3111DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3111DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3111DTO> getActions() {
        return Actions.<MyExample3111DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
