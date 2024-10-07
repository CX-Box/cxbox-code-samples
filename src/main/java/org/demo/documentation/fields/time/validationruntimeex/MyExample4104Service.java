package org.demo.documentation.fields.time.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4104Service extends VersionAwareResponseService<MyExample4104DTO, MyEntity4104> {

    private final MyEntity4104Repository repository;

    public MyExample4104Service(MyEntity4104Repository repository) {
        super(MyExample4104DTO.class, MyEntity4104.class, null, MyExample4104Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4104DTO> doCreateEntity(MyEntity4104 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4104DTO> doUpdateEntity(MyEntity4104 entity, MyExample4104DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4104DTO> getActions() {
        return Actions.<MyExample4104DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}