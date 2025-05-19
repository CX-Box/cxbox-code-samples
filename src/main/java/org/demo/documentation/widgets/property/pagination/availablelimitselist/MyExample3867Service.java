package org.demo.documentation.widgets.property.pagination.availablelimitselist;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3867Service extends VersionAwareResponseService<MyExample3867DTO, MyEntity3867> {

    private final MyEntity3867Repository repository;

    public MyExample3867Service(MyEntity3867Repository repository) {
        super(MyExample3867DTO.class, MyEntity3867.class, null, MyExample3867Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3867DTO> doCreateEntity(MyEntity3867 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3867DTO> doUpdateEntity(MyEntity3867 entity, MyExample3867DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3867DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3867DTO> getActions() {
        return Actions.<MyExample3867DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

