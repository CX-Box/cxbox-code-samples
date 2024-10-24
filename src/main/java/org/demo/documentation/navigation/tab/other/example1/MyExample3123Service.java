package org.demo.documentation.navigation.tab.other.example1;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3123Service extends VersionAwareResponseService<MyExample3123DTO, MyEntity3123> {

    private final MyEntity3123Repository repository;

    public MyExample3123Service(MyEntity3123Repository repository) {
        super(MyExample3123DTO.class, MyEntity3123.class, null, MyExample3123Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3123DTO> doCreateEntity(MyEntity3123 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3123DTO> doUpdateEntity(MyEntity3123 entity, MyExample3123DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3123DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3123DTO> getActions() {
        return Actions.<MyExample3123DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
