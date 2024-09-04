package org.demo.navigation.tab.typeother.secondlevel.down;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3127Service extends VersionAwareResponseService<MyExample3127DTO, MyEntity3127> {

    private final MyEntity3127Repository repository;

    public MyExample3127Service(MyEntity3127Repository repository) {
        super(MyExample3127DTO.class, MyEntity3127.class, null, MyExample3127Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3127DTO> doCreateEntity(MyEntity3127 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3127DTO> doUpdateEntity(MyEntity3127 entity, MyExample3127DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3127DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3127DTO> getActions() {
        return Actions.<MyExample3127DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }


}

