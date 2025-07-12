package org.demo.documentation.widgets.picklist.title.calculatedtitle;

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
public class MyEntity3071PickPickService extends VersionAwareResponseService<MyEntity3071PickPickDTO, MyEntity3071Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3071PickPickMeta> meta = MyEntity3071PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3071PickPickDTO> doCreateEntity(MyEntity3071Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3071PickPickDTO> doUpdateEntity(MyEntity3071Pick entity, MyEntity3071PickPickDTO data,
                                                                      BusinessComponent bc) {
        setIfChanged(data, MyEntity3071PickPickDTO_.customFieldPick, entity::setCustomFieldPick);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3071PickPickDTO> getActions() {
        return Actions.<MyEntity3071PickPickDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}