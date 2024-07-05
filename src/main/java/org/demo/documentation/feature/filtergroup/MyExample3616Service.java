package org.demo.documentation.feature.filtergroup;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3616Service extends VersionAwareResponseService<MyExample3616DTO, MyEntity3616> {

    private final MyEntity3616Repository repository;

    public MyExample3616Service(MyEntity3616Repository repository) {
        super(MyExample3616DTO.class, MyEntity3616.class, null, MyExample3616Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3616DTO> doCreateEntity(MyEntity3616 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3616DTO> doUpdateEntity(MyEntity3616 entity, MyExample3616DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3616DTO_.customFieldNew)) {
            entity.setCustomFieldNew(data.getCustomFieldNew());
        }
        if (data.isFieldChanged(MyExample3616DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3616DTO> getActions() {
        return Actions.<MyExample3616DTO>builder()
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

