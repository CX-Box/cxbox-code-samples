package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample106Service extends VersionAwareResponseService<MyExample106DTO, MyEntity106> {

    private final MyEntity106Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample106Meta> meta = MyExample106Meta.class;

    @Override
    protected CreateResult<MyExample106DTO> doCreateEntity(MyEntity106 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample106DTO> doUpdateEntity(MyEntity106 entity, MyExample106DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample106DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample106DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyExample106DTO_.customFieldDictionaryExample)) {
            entity.setCustomFieldDictionaryExample(data.getCustomFieldDictionaryExample());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample106DTO> getActions() {
        return Actions.<MyExample106DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

