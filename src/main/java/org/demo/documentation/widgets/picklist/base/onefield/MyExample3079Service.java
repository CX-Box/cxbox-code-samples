package org.demo.documentation.widgets.picklist.base.onefield;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3079Service extends VersionAwareResponseService<MyExample3079DTO, MyEntity3079> {

    private final MyEntity3079Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3079Service(MyEntity3079Repository repository) {
        super(MyExample3079DTO.class, MyEntity3079.class, null, MyExample3079Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3079DTO> doCreateEntity(MyEntity3079 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3079DTO> doUpdateEntity(MyEntity3079 entity, MyExample3079DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3079DTO_.customFieldInlinePickListId)) {
            entity.setCustomFieldInlinePickListEntity(data.getCustomFieldInlinePickListId() != null
                    ? entityManager.getReference(MyEntity3079Pick.class, data.getCustomFieldInlinePickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3079DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3079Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3079DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3079DTO> getActions() {
        return Actions.<MyExample3079DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

