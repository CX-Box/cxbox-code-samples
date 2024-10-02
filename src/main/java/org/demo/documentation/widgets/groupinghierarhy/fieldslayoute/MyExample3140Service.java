package org.demo.documentation.widgets.groupinghierarhy.fieldslayoute;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3140Service extends VersionAwareResponseService<MyExample3140DTO, MyEntity3140> {

    private final MyEntity3140Repository repository;

    public MyExample3140Service(MyEntity3140Repository repository) {
        super(MyExample3140DTO.class, MyEntity3140.class, null, MyExample3140Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3140DTO> doCreateEntity(MyEntity3140 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3140DTO> doUpdateEntity(MyEntity3140 entity, MyExample3140DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3140DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3140DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3140DTO> getActions() {
        return Actions.<MyExample3140DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}
