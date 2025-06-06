package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

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
public class MyExample352Service extends VersionAwareResponseService<MyExample352DTO, MyEntity352> {

    private final MyEntity352Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample352Meta> meta = MyExample352Meta.class;

    @Override
    protected CreateResult<MyExample352DTO> doCreateEntity(MyEntity352 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample352DTO> doUpdateEntity(MyEntity352 entity, MyExample352DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample352DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample352DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
         return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample352DTO> getActions() {
        return Actions.<MyExample352DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

