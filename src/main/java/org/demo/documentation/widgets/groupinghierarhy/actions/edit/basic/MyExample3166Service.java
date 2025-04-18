package org.demo.documentation.widgets.groupinghierarhy.actions.edit.basic;

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
public class MyExample3166Service extends VersionAwareResponseService<MyExample3166DTO, MyEntity3166> {

    private final MyEntity3166Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3166Meta> meta = MyExample3166Meta.class;

    @Override
    protected CreateResult<MyExample3166DTO> doCreateEntity(MyEntity3166 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3166DTO> doUpdateEntity(MyEntity3166 entity, MyExample3166DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3166DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3166DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3166DTO> getActions() {
        return Actions.<MyExample3166DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

