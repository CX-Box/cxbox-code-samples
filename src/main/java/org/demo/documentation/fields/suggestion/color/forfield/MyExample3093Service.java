package org.demo.documentation.fields.suggestion.color.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3093Service extends VersionAwareResponseService<MyExample3093DTO, MyEntity3093> {

    private final MyEntity3093Repository repository;

    public MyExample3093Service(MyEntity3093Repository repository) {
        super(MyExample3093DTO.class, MyEntity3093.class, null, MyExample3093Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3093DTO> doCreateEntity(MyEntity3093 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3093DTO> doUpdateEntity(MyEntity3093 entity, MyExample3093DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3093DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3093DTO> getActions() {
        return Actions.<MyExample3093DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}
