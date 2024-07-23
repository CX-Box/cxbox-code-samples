package org.demo.documentation.widgets.picklist.color;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3060Service extends VersionAwareResponseService<MyExample3060DTO, MyEntity3060> {

    private final MyEntity3060Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3060Service(MyEntity3060Repository repository) {
        super(MyExample3060DTO.class, MyEntity3060.class, null, MyExample3060Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3060DTO> doCreateEntity(MyEntity3060 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3060DTO> doUpdateEntity(MyEntity3060 entity, MyExample3060DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3060DTO_.customFieldPicklistColorConstId)) {
            entity.setCustomFieldPicklistColorConstEntity(data.getCustomFieldPicklistColorConstId() != null
                    ? entityManager.getReference(MyEntity3061Pick.class, data.getCustomFieldPicklistColorConstId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3060DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3061.class, data.getCustomFieldPicklistId())
                    : null);
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3060DTO> getActions() {
        return Actions.<MyExample3060DTO>builder()
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

