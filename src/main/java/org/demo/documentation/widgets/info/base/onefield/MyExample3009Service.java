package org.demo.documentation.widgets.info.base.onefield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3009Service extends VersionAwareResponseService<MyExample3009DTO, MyEntity3009> {

    private final MyEntity3009Repository repository;

    public MyExample3009Service(MyEntity3009Repository repository) {
        super(MyExample3009DTO.class, MyEntity3009.class, null, MyExample3009Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3009DTO> doCreateEntity(MyEntity3009 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3009DTO> doUpdateEntity(MyEntity3009 entity, MyExample3009DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3009DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3009DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3009DTO> getActions() {
        return Actions.<MyExample3009DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

