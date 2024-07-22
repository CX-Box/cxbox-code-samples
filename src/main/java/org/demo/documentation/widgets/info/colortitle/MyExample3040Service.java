package org.demo.documentation.widgets.info.colortitle;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3040Service extends VersionAwareResponseService<MyExample3040DTO, MyEntity3040> {

    private final MyEntity3040Repository repository;

    public MyExample3040Service(MyEntity3040Repository repository) {
        super(MyExample3040DTO.class, MyEntity3040.class, null, MyExample3040Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3040DTO> doCreateEntity(MyEntity3040 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3040DTO> doUpdateEntity(MyEntity3040 entity, MyExample3040DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3040DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3040DTO> getActions() {
        return Actions.<MyExample3040DTO>builder()
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

