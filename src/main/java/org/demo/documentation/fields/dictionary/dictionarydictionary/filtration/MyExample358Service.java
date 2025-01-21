package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample358Service extends VersionAwareResponseService<MyExample358DTO, MyEntity358> {

    private final MyEntity358Repository repository;

    public MyExample358Service(MyEntity358Repository repository) {
        super(MyExample358DTO.class, MyEntity358.class, null, MyExample358Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample358DTO> doCreateEntity(MyEntity358 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample358DTO> doUpdateEntity(MyEntity358 entity, MyExample358DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample358DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample358DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample358DTO> getActions() {
        return Actions.<MyExample358DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

