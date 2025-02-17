package org.demo.documentation.fields.money.currency.constkey;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3150Service extends VersionAwareResponseService<MyExample3150DTO, MyEntity3150> {

    private final MyEntity3150Repository repository;

    public MyExample3150Service(MyEntity3150Repository repository) {
        super(MyExample3150DTO.class, MyEntity3150.class, null, MyExample3150Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3150DTO> doCreateEntity(MyEntity3150 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3150DTO> doUpdateEntity(MyEntity3150 entity, MyExample3150DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3150DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3150DTO_.customField, entity::setCustomField);
        if (data.isFieldChanged(MyExample3150DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3150DTO> getActions() {
        return Actions.<MyExample3150DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

