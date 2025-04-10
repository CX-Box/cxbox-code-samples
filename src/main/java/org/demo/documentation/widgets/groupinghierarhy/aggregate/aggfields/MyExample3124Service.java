package org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3124Service extends VersionAwareResponseService<MyExample3124DTO, MyEntity3124> {

    private final MyEntity3124Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3124Meta> meta = MyExample3124Meta.class;

    @Override
    protected CreateResult<MyExample3124DTO> doCreateEntity(MyEntity3124 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3124DTO> doUpdateEntity(MyEntity3124 entity, MyExample3124DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3124DTO_.customFieldNumberOther, entity::setCustomFieldNumberOther);
        setIfChanged(data, MyExample3124DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample3124DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3124DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3124DTO> getActions() {
        return Actions.<MyExample3124DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

