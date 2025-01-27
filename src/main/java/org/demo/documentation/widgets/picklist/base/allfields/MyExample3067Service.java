package org.demo.documentation.widgets.picklist.base.allfields;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3067Service extends VersionAwareResponseService<MyExample3067DTO, MyEntity3067> {

    private final MyEntity3067Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3067Service(MyEntity3067Repository repository) {
        super(MyExample3067DTO.class, MyEntity3067.class, null, MyExample3067Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3067DTO> doCreateEntity(MyEntity3067 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3067DTO> doUpdateEntity(MyEntity3067 entity, MyExample3067DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(org.demo.documentation.widgets.picklist.base.allfields.MyExample3067DTO_.customFieldInlinePickListId)) {
            entity.setCustomFieldInlinePickListEntity(data.getCustomFieldInlinePickListId() != null
                    ? entityManager.getReference(MyEntity3067Pick.class, data.getCustomFieldInlinePickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3067DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3067Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3067DTO> getActions() {
        return Actions.<MyExample3067DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
    // --8<-- [end:getActions]
}
