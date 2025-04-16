package org.demo.documentation.widgets.picklist.actions.save.forpicklistpopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3197PickPickService extends VersionAwareResponseService<MyEntity3197PickPickDTO, MyEntity3197Pick> {
    private final MyEntity3197PickRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3197PickPickMeta> meta = MyEntity3197PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3197PickPickDTO> doCreateEntity(MyEntity3197Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]

    @Override
    protected ActionResultDTO<MyEntity3197PickPickDTO> doUpdateEntity(MyEntity3197Pick entity, MyEntity3197PickPickDTO data,
                                                                      BusinessComponent bc) {
        setIfChanged(data, MyEntity3197PickPickDTO_.customField, entity::setCustomField);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3197PickPickDTO> getActions() {
        return Actions.<MyEntity3197PickPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}