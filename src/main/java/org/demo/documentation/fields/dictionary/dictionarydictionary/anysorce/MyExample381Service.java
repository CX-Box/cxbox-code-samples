package org.demo.documentation.fields.dictionary.dictionarydictionary.anysorce;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample381Service extends VersionAwareResponseService<MyExample381DTO, MyEntity381> {

    private final MyEntity381Repository repository;

    public MyExample381Service(MyEntity381Repository repository) {
        super(MyExample381DTO.class, MyEntity381.class, null, MyExample381Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample381DTO> doCreateEntity(MyEntity381 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample381DTO> doUpdateEntity(MyEntity381 entity, MyExample381DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample381DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample381DTO> getActions() {
        return Actions.<MyExample381DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

