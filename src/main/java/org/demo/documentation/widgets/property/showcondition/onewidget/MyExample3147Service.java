package org.demo.documentation.widgets.property.showcondition.onewidget;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3147Service extends VersionAwareResponseService<MyExample3147DTO, MyEntity3147> {

    private final MyEntity3147Repository repository;

    public MyExample3147Service(MyEntity3147Repository repository) {
        super(MyExample3147DTO.class, MyEntity3147.class, null, MyExample3147Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3147DTO> doCreateEntity(MyEntity3147 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3147DTO> doUpdateEntity(MyEntity3147 entity, MyExample3147DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3147DTO_.customFieldNumber, entity::setCustomFieldNumber);
        if (data.isFieldChanged(MyExample3147DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3147DTO> getActions() {
        return Actions.<MyExample3147DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

