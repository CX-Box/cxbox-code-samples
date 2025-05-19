package org.demo.documentation.widgets.property.pagination.hidelimitoptions;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3865Service extends VersionAwareResponseService<MyExample3865DTO, MyEntity3865> {

    private final MyEntity3865Repository repository;

    public MyExample3865Service(MyEntity3865Repository repository) {
        super(MyExample3865DTO.class, MyEntity3865.class, null, MyExample3865Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3865DTO> doCreateEntity(MyEntity3865 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3865DTO> doUpdateEntity(MyEntity3865 entity, MyExample3865DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3865DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3865DTO> getActions() {
        return Actions.<MyExample3865DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

