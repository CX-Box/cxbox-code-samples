package org.demo.documentation.fields.time.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4102Service extends VersionAwareResponseService<MyExample4102DTO, MyEntity4102> {

    private final MyEntity4102Repository repository;

    public MyExample4102Service(MyEntity4102Repository repository) {
        super(MyExample4102DTO.class, MyEntity4102.class, null, MyExample4102Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4102DTO> doCreateEntity(MyEntity4102 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4102DTO> doUpdateEntity(MyEntity4102 entity, MyExample4102DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4102DTO> getActions() {
        return Actions.<MyExample4102DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}