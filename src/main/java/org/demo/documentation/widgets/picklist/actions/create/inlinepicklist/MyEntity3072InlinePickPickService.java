package org.demo.documentation.widgets.picklist.actions.create.inlinepicklist;

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
public class MyEntity3072InlinePickPickService extends VersionAwareResponseService<MyEntity3072InlinePickPickDTO, MyEntity3072InlinePick> {
    private final MyEntity3072InlinePickRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3072InlinePickPickMeta> meta = MyEntity3072InlinePickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3072InlinePickPickDTO> doCreateEntity(MyEntity3072InlinePick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3072InlinePickPickDTO> doUpdateEntity(MyEntity3072InlinePick entity, MyEntity3072InlinePickPickDTO data,
                                                                            BusinessComponent bc) {
        setIfChanged(data, MyEntity3072InlinePickPickDTO_.customFieldPick, entity::setCustomFieldPick);
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    public Actions<MyEntity3072InlinePickPickDTO> getActions() {
        return Actions.<MyEntity3072InlinePickPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]
}