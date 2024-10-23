package org.demo.documentation.fields.dictionary.icon;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3011Service extends VersionAwareResponseService<MyExample3011DTO, MyEntity3011> {

    private final MyEntity3011Repository repository;

    public MyExample3011Service(MyEntity3011Repository repository) {
        super(MyExample3011DTO.class, MyEntity3011.class, null, MyExample3011Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3011DTO> doCreateEntity(MyEntity3011 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3011DTO> doUpdateEntity(MyEntity3011 entity, MyExample3011DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3011DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3011DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3011DTO> getActions() {
        return Actions.<MyExample3011DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

