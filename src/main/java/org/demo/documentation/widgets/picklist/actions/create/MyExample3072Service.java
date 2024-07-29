package org.demo.documentation.widgets.picklist.actions.create;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3072Service extends VersionAwareResponseService<MyExample3072DTO, MyEntity3072> {

    private final MyEntity3072Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3072Service(MyEntity3072Repository repository) {
        super(MyExample3072DTO.class, MyEntity3072.class, null, MyExample3072Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3072DTO> doCreateEntity(MyEntity3072 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3072DTO> doUpdateEntity(MyEntity3072 entity, MyExample3072DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3072DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3072Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3072DTO> getActions() {
        return Actions.<MyExample3072DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}

