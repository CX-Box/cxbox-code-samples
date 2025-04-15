package org.demo.documentation.fields.suggestion.validationruntimeex.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3120Service extends VersionAwareResponseService<MyExample3120DTO, MyEntity3120> {

    private final MyEntity3120Repository repository;

    public MyExample3120Service(MyEntity3120Repository repository) {
        super(MyExample3120DTO.class, MyEntity3120.class, null, MyExample3120Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3120DTO> doCreateEntity(MyEntity3120 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3120DTO> doUpdateEntity(MyEntity3120 entity, MyExample3120DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3120DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
            try {
                //call custom function
                throw new Exception("Error");
            } catch (Exception e) {
                throw new RuntimeException("An unexpected error has occurred.");
            }
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3120DTO> getActions() {
        return Actions.<MyExample3120DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
