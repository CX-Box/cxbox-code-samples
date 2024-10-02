package org.demo.documentation.fields.time.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3503Service extends VersionAwareResponseService<MyExample3503DTO, MyEntity3503> {

    private final MyEntity3503Repository repository;

    public MyExample3503Service(MyEntity3503Repository repository) {
        super(MyExample3503DTO.class, MyEntity3503.class, null, MyExample3503Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3503DTO> doCreateEntity(MyEntity3503 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3503DTO> doUpdateEntity(MyEntity3503 entity, MyExample3503DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3503DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3503DTO> getActions() {
        return Actions.<MyExample3503DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}