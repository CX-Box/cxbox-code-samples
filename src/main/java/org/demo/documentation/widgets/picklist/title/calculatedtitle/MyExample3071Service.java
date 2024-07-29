package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3071Service extends VersionAwareResponseService<MyExample3071DTO, MyEntity3071> {

    private final MyEntity3071Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3071Service(MyEntity3071Repository repository) {
        super(MyExample3071DTO.class, MyEntity3071.class, null, MyExample3071Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3071DTO> doCreateEntity(MyEntity3071 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3071DTO> doUpdateEntity(MyEntity3071 entity, MyExample3071DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3071DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3071Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3071DTO> getActions() {
        return Actions.<MyExample3071DTO>builder()
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

