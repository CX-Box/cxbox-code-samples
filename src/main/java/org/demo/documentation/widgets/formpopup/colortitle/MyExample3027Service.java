package org.demo.documentation.widgets.formpopup.colortitle;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3027Service extends VersionAwareResponseService<MyExample3027DTO, MyEntity3027> {

    private final MyEntity3027Repository repository;

    public MyExample3027Service(MyEntity3027Repository repository) {
        super(MyExample3027DTO.class, MyEntity3027.class, null, MyExample3027Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3027DTO> doCreateEntity(MyEntity3027 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3027DTO> doUpdateEntity(MyEntity3027 entity, MyExample3027DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3027DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3027DTO> getActions() {
        return Actions.<MyExample3027DTO>builder()
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

