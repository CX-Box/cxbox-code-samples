package org.demo.documentation.widgets.groupinghierarhy.base;

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
public class MyExample3121Service extends VersionAwareResponseService<MyExample3121DTO, MyEntity3121> {

    private final MyEntity3121Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3121Meta> meta = MyExample3121Meta.class;

    @Override
    protected CreateResult<MyExample3121DTO> doCreateEntity(MyEntity3121 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3121DTO> doUpdateEntity(MyEntity3121 entity, MyExample3121DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3121DTO_.customFieldRadio, entity::setCustomFieldRadio);

        if (data.isFieldChanged(MyExample3121DTO_.customFieldCheckbox)) {
            entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
        }
        if (data.isFieldChanged(MyExample3121DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyExample3121DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3121DTO> getActions() {
        return Actions.<MyExample3121DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
    // --8<-- [end:getActions]
}
