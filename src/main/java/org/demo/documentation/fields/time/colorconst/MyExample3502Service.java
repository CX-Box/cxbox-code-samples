package org.demo.documentation.fields.time.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3502Service extends VersionAwareResponseService<MyExample3502DTO, MyEntity3502> {

    private final MyEntity3502Repository repository;

    public MyExample3502Service(MyEntity3502Repository repository) {
        super(MyExample3502DTO.class, MyEntity3502.class, null, MyExample3502Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3502DTO> doCreateEntity(MyEntity3502 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3502DTO> doUpdateEntity(MyEntity3502 entity, MyExample3502DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3502DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3502DTO> getActions() {
        return Actions.<MyExample3502DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}