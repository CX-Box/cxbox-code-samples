package org.demo.documentation.widgets.groupinghierarhy.base;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3121Service extends VersionAwareResponseService<MyExample3121DTO, MyEntity3121> {

    private final MyEntity3121Repository repository;

    public MyExample3121Service(MyEntity3121Repository repository) {
        super(MyExample3121DTO.class, MyEntity3121.class, null, MyExample3121Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3121DTO> doCreateEntity(MyEntity3121 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3121DTO> doUpdateEntity(MyEntity3121 entity, MyExample3121DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3121DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample3121DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyExample3121DTO_.customFieldCheckbox)) {
            entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3121DTO> getActions() {
        return Actions.<MyExample3121DTO>builder()
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

