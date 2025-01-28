package org.demo.documentation.widgets.picklist.actions.cancelcreate;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.forpicklistpopup.MyEntity3198Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3198Service extends VersionAwareResponseService<MyExample3198DTO, MyEntity3198> {

    private final MyEntity3198Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3198Service(MyEntity3198Repository repository) {
        super(MyExample3198DTO.class, MyEntity3198.class, null, MyExample3198Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3198DTO> doCreateEntity(MyEntity3198 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3198DTO> doUpdateEntity(MyEntity3198 entity, MyExample3198DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3198DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3198Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3198DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3198DTO> getActions() {
        return Actions.<MyExample3198DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

