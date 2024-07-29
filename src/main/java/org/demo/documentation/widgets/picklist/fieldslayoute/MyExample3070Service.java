package org.demo.documentation.widgets.picklist.fieldslayoute;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3070Service extends VersionAwareResponseService<MyExample3070DTO, MyEntity3070> {

    private final MyEntity3070Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3070Service(MyEntity3070Repository repository) {
        super(MyExample3070DTO.class, MyEntity3070.class, null, MyExample3070Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3070DTO> doCreateEntity(MyEntity3070 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3070DTO> doUpdateEntity(MyEntity3070 entity, MyExample3070DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3070DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3070Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3070DTO> getActions() {
        return Actions.<MyExample3070DTO>builder()
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

