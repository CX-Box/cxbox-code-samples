package org.demo.documentation.fields.suggestion.drilldown.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3095Service extends VersionAwareResponseService<MyExample3095DTO, MyEntity3095> {

    private final MyEntity3095Repository repository;

    public MyExample3095Service(MyEntity3095Repository repository) {
        super(MyExample3095DTO.class, MyEntity3095.class, null, MyExample3095Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3095DTO> doCreateEntity(MyEntity3095 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3095DTO> doUpdateEntity(MyEntity3095 entity, MyExample3095DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3095DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3095DTO> getActions() {
        return Actions.<MyExample3095DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
