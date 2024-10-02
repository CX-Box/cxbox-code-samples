package org.demo.documentation.getstarted.postgres.example;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4002Service extends VersionAwareResponseService<MyExample4002DTO, MyEntity4002> {

    private final MyEntity4002Repository repository;

    public MyExample4002Service(MyEntity4002Repository repository) {
        super(MyExample4002DTO.class, MyEntity4002.class, null, MyExample4002Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4002DTO> doCreateEntity(MyEntity4002 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4002DTO> doUpdateEntity(MyEntity4002 entity, MyExample4002DTO data, BusinessComponent bc) {

        if (data.isFieldChanged(MyExample4002DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4002DTO> getActions() {
        return Actions.<MyExample4002DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
     // --8<-- [end:getActions]  
}