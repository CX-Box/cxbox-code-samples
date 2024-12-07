package org.demo.documentation.fields.dictionary.dictionarydictionary.icon;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample355Service extends VersionAwareResponseService<MyExample355DTO, MyEntity355> {

    private final MyEntity355Repository repository;

    public MyExample355Service(MyEntity355Repository repository) {
        super(MyExample355DTO.class, MyEntity355.class, null, MyExample355Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample355DTO> doCreateEntity(MyEntity355 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample355DTO> doUpdateEntity(MyEntity355 entity, MyExample355DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample355DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample355DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample355DTO> getActions() {
        return Actions.<MyExample355DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

