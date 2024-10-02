package org.demo.documentation.fields.time.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4103Service extends VersionAwareResponseService<MyExample4103DTO, MyEntity4103> {

    private final MyEntity4103Repository repository;

    public MyExample4103Service(MyEntity4103Repository repository) {
        super(MyExample4103DTO.class, MyEntity4103.class, null, MyExample4103Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4103DTO> doCreateEntity(MyEntity4103 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4103DTO> doUpdateEntity(MyEntity4103 entity, MyExample4103DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4103DTO> getActions() {
        return Actions.<MyExample4103DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}