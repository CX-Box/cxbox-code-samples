package org.demo.documentation.widgets.form.allpropertiesfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3404Service extends VersionAwareResponseService<MyExample3404DTO, MyEntity3404> {

    private final MyEntity3404Repository repository;

    public MyExample3404Service(MyEntity3404Repository repository) {
        super(MyExample3404DTO.class, MyEntity3404.class, null, MyExample3404Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3404DTO> doCreateEntity(MyEntity3404 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3404DTO> doUpdateEntity(MyEntity3404 entity, MyExample3404DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3404DTO_.customFieldRequired, entity::setCustomFieldRequired);
        setIfChanged(data, MyExample3404DTO_.customFieldColorSort, entity::setCustomFieldColorSort);
        setIfChanged(data, MyExample3404DTO_.customFieldColorValidation, entity::setCustomFieldColorValidation);
        setIfChanged(data, MyExample3404DTO_.customFieldColorDrilldown, entity::setCustomFieldColorDrilldown);
        setIfChanged(data, MyExample3404DTO_.customFieldColorConst, entity::setCustomFieldColorConst);
        setIfChanged(data, MyExample3404DTO_.customFieldColor, entity::setCustomFieldColor);
        setIfChanged(data, MyExample3404DTO_.customFieldPlaceholder, entity::setCustomFieldPlaceholder);
        if (data.isFieldChanged(MyExample3404DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3404DTO> getActions() {
        return Actions.<MyExample3404DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

