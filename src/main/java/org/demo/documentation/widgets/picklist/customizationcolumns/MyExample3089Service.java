package org.demo.documentation.widgets.picklist.customizationcolumns;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3089Service extends VersionAwareResponseService<MyExample3089DTO, MyEntity3089> {

    private final MyEntity3089Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3089Service(MyEntity3089Repository repository) {
        super(MyExample3089DTO.class, MyEntity3089.class, null, MyExample3089Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3089DTO> doCreateEntity(MyEntity3089 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3089DTO> doUpdateEntity(MyEntity3089 entity, MyExample3089DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3089DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3089Pick.class, data.getCustomFieldPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3089DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3089DTO> getActions() {
        return Actions.<MyExample3089DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

