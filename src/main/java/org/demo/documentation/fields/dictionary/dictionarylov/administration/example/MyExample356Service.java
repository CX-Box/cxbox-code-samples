package org.demo.documentation.fields.dictionary.dictionarylov.administration.example;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample356Service extends VersionAwareResponseService<MyExample356DTO, MyEntity356> {

    private final MyEntity356Repository repository;

    public MyExample356Service(MyEntity356Repository repository) {
        super(MyExample356DTO.class, MyEntity356.class, null, MyExample356Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample356DTO> doCreateEntity(MyEntity356 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample356DTO> doUpdateEntity(MyEntity356 entity, MyExample356DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample356DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample356DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample356DTO> getActions() {
        return Actions.<MyExample356DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }


}

