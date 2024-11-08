package org.demo.documentation.widgets.collapse;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3022Service extends VersionAwareResponseService<MyExample3022DTO, MyEntity3022> {

    private final MyEntity3022Repository repository;

    public MyExample3022Service(MyEntity3022Repository repository) {
        super(MyExample3022DTO.class, MyEntity3022.class, null, MyExample3022Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3022DTO> doCreateEntity(MyEntity3022 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3022DTO> doUpdateEntity(MyEntity3022 entity, MyExample3022DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3022DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3022DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3022DTO> getActions() {
        return Actions.<MyExample3022DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

