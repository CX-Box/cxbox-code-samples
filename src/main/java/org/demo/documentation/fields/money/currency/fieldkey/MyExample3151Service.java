package org.demo.documentation.fields.money.currency.fieldkey;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3151Service extends VersionAwareResponseService<MyExample3151DTO, MyEntity3151> {

    private final MyEntity3151Repository repository;

    public MyExample3151Service(MyEntity3151Repository repository) {
        super(MyExample3151DTO.class, MyEntity3151.class, null, MyExample3151Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3151DTO> doCreateEntity(MyEntity3151 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3151DTO> doUpdateEntity(MyEntity3151 entity, MyExample3151DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3151DTO_.customField, entity::setCustomField);
        setIfChanged(data, MyExample3151DTO_.customFieldCurrency, entity::setCustomFieldCurrencyDictionary);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3151DTO> getActions() {
        return Actions.<MyExample3151DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

