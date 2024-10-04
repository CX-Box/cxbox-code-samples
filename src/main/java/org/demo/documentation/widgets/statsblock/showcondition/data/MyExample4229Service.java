package org.demo.documentation.widgets.statsblock.showcondition.data;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample4229Service extends VersionAwareResponseService<MyExample4229DTO, MyEntity4229> {

    private final MyEntity4229Repository repository;

    public MyExample4229Service(MyEntity4229Repository repository) {
        super(MyExample4229DTO.class, MyEntity4229.class, null, MyExample4229Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4229DTO> doCreateEntity(MyEntity4229 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4229DTO> doUpdateEntity(MyEntity4229 entity, MyExample4229DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4229DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4229DTO> getActions() {
        return Actions.<MyExample4229DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}