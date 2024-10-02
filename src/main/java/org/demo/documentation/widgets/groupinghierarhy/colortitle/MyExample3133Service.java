package org.demo.documentation.widgets.groupinghierarhy.colortitle;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3133Service extends VersionAwareResponseService<MyExample3133DTO, MyEntity3133> {

    private final MyEntity3133Repository repository;

    public MyExample3133Service(MyEntity3133Repository repository) {
        super(MyExample3133DTO.class, MyEntity3133.class, null, MyExample3133Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3133DTO> doCreateEntity(MyEntity3133 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3133DTO> doUpdateEntity(MyEntity3133 entity, MyExample3133DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3133DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyExample3133DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3133DTO> getActions() {
        return Actions.<MyExample3133DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}
