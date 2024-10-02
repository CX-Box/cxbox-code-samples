package org.demo.documentation.widgets.statsblock.color.data;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample4204Service extends VersionAwareResponseService<MyExample4204DTO, MyEntity4204> {

    private final MyEntity4204Repository repository;

    public MyExample4204Service(MyEntity4204Repository repository) {
        super(MyExample4204DTO.class, MyEntity4204.class, null, MyExample4204Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4204DTO> doCreateEntity(MyEntity4204 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4204DTO> doUpdateEntity(MyEntity4204 entity, MyExample4204DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4204DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        if (data.isFieldChanged(MyExample4204DTO_.customFieldNum)) {
            entity.setCustomFieldNum(data.getCustomFieldNum());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4204DTO> getActions() {
        return Actions.<MyExample4204DTO>builder()
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