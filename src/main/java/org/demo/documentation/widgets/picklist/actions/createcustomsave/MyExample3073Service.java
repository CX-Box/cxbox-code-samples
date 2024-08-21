package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3073Service extends VersionAwareResponseService<MyExample3073DTO, MyEntity3073> {

    private final MyEntity3073Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3073Service(MyEntity3073Repository repository) {
        super(MyExample3073DTO.class, MyEntity3073.class, null, MyExample3073Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3073DTO> doCreateEntity(MyEntity3073 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3073DTO> doUpdateEntity(MyEntity3073 entity, MyExample3073DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3073DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3073Pick.class, data.getCustomFieldId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3073DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3073Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3073DTO> getActions() {
        return Actions.<MyExample3073DTO>builder()
                .action("customSave", "Save")
                .invoker(this::customSave)
                .add()
                .build();
    }

    private ActionResultDTO<MyExample3073DTO> customSave(BusinessComponent businessComponent, MyExample3073DTO myExample3073DTO) {
        return null;
    }


}

