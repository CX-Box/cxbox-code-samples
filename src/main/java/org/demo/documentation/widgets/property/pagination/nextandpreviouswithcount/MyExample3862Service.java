package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3862Service extends VersionAwareResponseService<MyExample3862DTO, MyEntity3862> {

    private final MyEntity3862Repository repository;

    public MyExample3862Service(MyEntity3862Repository repository) {
        super(MyExample3862DTO.class, MyEntity3862.class, null, MyExample3862Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3862DTO> doCreateEntity(MyEntity3862 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3862DTO> doUpdateEntity(MyEntity3862 entity, MyExample3862DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3862DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3862DTO> getActions() {
        return Actions.<MyExample3862DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

