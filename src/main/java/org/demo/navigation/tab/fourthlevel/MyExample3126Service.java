package org.demo.navigation.tab.fourthlevel;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3126Service extends VersionAwareResponseService<MyExample3126DTO, MyEntity3126> {

    private final MyEntity3126Repository repository;

    public MyExample3126Service(MyEntity3126Repository repository) {
        super(MyExample3126DTO.class, MyEntity3126.class, null, MyExample3126Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3126DTO> doCreateEntity(MyEntity3126 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3126DTO> doUpdateEntity(MyEntity3126 entity, MyExample3126DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3126DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3126DTO> getActions() {
        return Actions.<MyExample3126DTO>builder()
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

