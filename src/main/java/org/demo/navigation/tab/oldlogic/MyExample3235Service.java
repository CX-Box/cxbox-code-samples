package org.demo.navigation.tab.oldlogic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3235Service extends VersionAwareResponseService<MyExample3235DTO, MyEntity3235> {

    private final MyEntity3235Repository repository;

    public MyExample3235Service(MyEntity3235Repository repository) {
        super(MyExample3235DTO.class, MyEntity3235.class, null, MyExample3235Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3235DTO> doCreateEntity(MyEntity3235 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3235DTO> doUpdateEntity(MyEntity3235 entity, MyExample3235DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3235DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3235DTO> getActions() {
        return Actions.<MyExample3235DTO>builder()
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

