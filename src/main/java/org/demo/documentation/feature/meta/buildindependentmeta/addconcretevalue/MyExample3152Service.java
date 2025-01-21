package org.demo.documentation.feature.meta.buildindependentmeta.addconcretevalue;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3152Service extends VersionAwareResponseService<MyExample3152DTO, MyEntity3152> {

    private final MyEntity3152Repository repository;

    public MyExample3152Service(MyEntity3152Repository repository) {
        super(MyExample3152DTO.class, MyEntity3152.class, null, MyExample3152Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3152DTO> doCreateEntity(MyEntity3152 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3152DTO> doUpdateEntity(MyEntity3152 entity, MyExample3152DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3152DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3152DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3152DTO> getActions() {
        return Actions.<MyExample3152DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

