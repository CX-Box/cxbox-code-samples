package org.demo.documentation.widgets.info.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3103Service extends VersionAwareResponseService<MyExample3103DTO, MyEntity3103> {

    private final MyEntity3103Repository repository;

    public MyExample3103Service(MyEntity3103Repository repository) {
        super(MyExample3103DTO.class, MyEntity3103.class, null, MyExample3103Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3103DTO> doCreateEntity(MyEntity3103 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3103DTO> doUpdateEntity(MyEntity3103 entity, MyExample3103DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3103DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3103DTO> getActions() {
        return Actions.<MyExample3103DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}