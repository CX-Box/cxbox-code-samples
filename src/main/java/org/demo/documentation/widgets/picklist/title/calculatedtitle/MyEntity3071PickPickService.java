package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import lombok.Getter;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.time.base.MyExample3500DTO_;
import org.demo.documentation.widgets.picklist.actions.create.MyExample3072DTO;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3071PickPickService extends VersionAwareResponseService<MyEntity3071PickPickDTO, MyEntity3071Pick> {

    public MyEntity3071PickPickService() {
        super(MyEntity3071PickPickDTO.class, MyEntity3071Pick.class, null, MyEntity3071PickPickMeta.class);
    }

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

    @Override
    public Actions<MyEntity3071PickPickDTO> getActions() {
        return Actions.<MyEntity3071PickPickDTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}