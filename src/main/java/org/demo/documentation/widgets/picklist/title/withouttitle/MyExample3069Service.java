package org.demo.documentation.widgets.picklist.title.withouttitle;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3069Service extends VersionAwareResponseService<MyExample3069DTO, MyEntity3069> {

    private final MyEntity3069Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3069Service(MyEntity3069Repository repository) {
        super(MyExample3069DTO.class, MyEntity3069.class, null, MyExample3069Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3069DTO> doCreateEntity(MyEntity3069 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3069DTO> doUpdateEntity(MyEntity3069 entity, MyExample3069DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3069DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3069Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3069DTO> getActions() {
        return Actions.<MyExample3069DTO>builder()
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

