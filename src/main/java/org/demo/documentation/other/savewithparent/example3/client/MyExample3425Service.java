package org.demo.documentation.other.savewithparent.example3.client;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3425Service extends VersionAwareResponseService<MyExample3425DTO, MyEntity3425> {

    private final MyEntity3425Repository repository;

    public MyExample3425Service(MyEntity3425Repository repository) {
        super(MyExample3425DTO.class, MyEntity3425.class, null, MyExample3425Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3425DTO> doCreateEntity(MyEntity3425 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3425DTO> doUpdateEntity(MyEntity3425 entity, MyExample3425DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3425DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3425DTO> getActions() {
        return Actions.<MyExample3425DTO>builder()
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
