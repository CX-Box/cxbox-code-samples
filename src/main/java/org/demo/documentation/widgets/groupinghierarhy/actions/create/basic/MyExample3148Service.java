package org.demo.documentation.widgets.groupinghierarhy.actions.create.basic;

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
public class MyExample3148Service extends VersionAwareResponseService<MyExample3148DTO, MyEntity3148> {

    private final MyEntity3148Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3148Meta> meta = MyExample3148Meta.class;

    @Override
    protected CreateResult<MyExample3148DTO> doCreateEntity(MyEntity3148 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3148DTO> doUpdateEntity(MyEntity3148 entity, MyExample3148DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3148DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3148DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3148DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3148DTO> getActions() {
        return Actions.<MyExample3148DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

