package org.demo.documentation.widgets.additionallist.colortitle.twofields;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3196Service extends VersionAwareResponseService<MyExample3196DTO, MyEntity3196> {

    private final MyEntity3196Repository repository;

    public MyExample3196Service(MyEntity3196Repository repository) {
        super(MyExample3196DTO.class, MyEntity3196.class, null, MyExample3196Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3196DTO> doCreateEntity(MyEntity3196 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3196DTO> doUpdateEntity(MyEntity3196 entity, MyExample3196DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3196DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3196DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3196DTO> getActions() {
        return Actions.<MyExample3196DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

