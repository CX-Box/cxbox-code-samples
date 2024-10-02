package org.demo.documentation.widgets.widget;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3021Service extends VersionAwareResponseService<MyExample3021DTO, MyEntity3021> {

    private final MyEntity3021Repository repository;

    public MyExample3021Service(MyEntity3021Repository repository) {
        super(MyExample3021DTO.class, MyEntity3021.class, null, MyExample3021Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3021DTO> doCreateEntity(MyEntity3021 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3021DTO> doUpdateEntity(MyEntity3021 entity, MyExample3021DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3021DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3021DTO> getActions() {
        return Actions.<MyExample3021DTO>builder()
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
