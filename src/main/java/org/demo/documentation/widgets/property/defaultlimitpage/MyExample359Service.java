package org.demo.documentation.widgets.property.defaultlimitpage;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample359Service extends VersionAwareResponseService<MyExample359DTO, MyEntity359> {

    private final MyEntity359Repository repository;

    public MyExample359Service(MyEntity359Repository repository) {
        super(MyExample359DTO.class, MyEntity359.class, null, MyExample359Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample359DTO> doCreateEntity(MyEntity359 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample359DTO> doUpdateEntity(MyEntity359 entity, MyExample359DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample359DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample359DTO> getActions() {
        return Actions.<MyExample359DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

