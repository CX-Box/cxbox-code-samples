package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.inlinepicklist;

import lombok.Getter;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3092PickPick0Service extends VersionAwareResponseService<MyEntity3092PickPick0DTO, MyEntity3092Pick> {

    public MyEntity3092PickPick0Service() {
        super(MyEntity3092PickPick0DTO.class, MyEntity3092Pick.class, null, MyEntity3092PickPick0Meta.class);
    }

    @Override
    protected CreateResult<MyEntity3092PickPick0DTO> doCreateEntity(MyEntity3092Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3092PickPick0DTO> doUpdateEntity(MyEntity3092Pick entity, MyEntity3092PickPick0DTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}