package org.demo.documentation.widgets.picklist.actions.createwithparent;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3074Service extends VersionAwareResponseService<MyExample3074DTO, MyEntity3074> {

    private final MyEntity3074Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3074Service(MyEntity3074Repository repository) {
        super(MyExample3074DTO.class, MyEntity3074.class, null, MyExample3074Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3074DTO> doCreateEntity(MyEntity3074 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3074DTO> doUpdateEntity(MyEntity3074 entity, MyExample3074DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3074DTO_.customFieldRequred, entity::setCustomFieldRequred);
        setIfChanged(data, MyExample3074DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3074DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3074Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3074DTO> getActions() {
        return Actions.<MyExample3074DTO>builder()
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

