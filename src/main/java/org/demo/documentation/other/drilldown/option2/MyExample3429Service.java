package org.demo.documentation.other.drilldown.option2;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3429Service extends VersionAwareResponseService<MyExample3429DTO, MyEntity3429> {

    private final MyEntity3429Repository repository;

    public MyExample3429Service(MyEntity3429Repository repository) {
        super(MyExample3429DTO.class, MyEntity3429.class, null, MyExample3429Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3429DTO> doCreateEntity(MyEntity3429 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3429DTO> doUpdateEntity(MyEntity3429 entity, MyExample3429DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3429DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3429DTO> getActions() {
        return Actions.<MyExample3429DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

