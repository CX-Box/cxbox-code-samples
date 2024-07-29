package org.demo.documentation.widgets.picklist.title;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.basic.MyEntity3067Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3068Service extends VersionAwareResponseService<MyExample3068DTO, MyEntity3068> {

    private final MyEntity3068Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3068Service(MyEntity3068Repository repository) {
        super(MyExample3068DTO.class, MyEntity3068.class, null, MyExample3068Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3068DTO> doCreateEntity(MyEntity3068 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3068DTO> doUpdateEntity(MyEntity3068 entity, MyExample3068DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3068DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3068Pick.class, data.getCustomFieldId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3068DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3068Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3068DTO> getActions() {
        return Actions.<MyExample3068DTO>builder()
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

