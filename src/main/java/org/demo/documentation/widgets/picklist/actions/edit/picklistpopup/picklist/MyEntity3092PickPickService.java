package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.picklist;

import lombok.Getter;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3092PickPickService extends VersionAwareResponseService<MyEntity3092PickPickDTO, MyEntity3092Pick> {

    public MyEntity3092PickPickService() {
        super(MyEntity3092PickPickDTO.class, MyEntity3092Pick.class, null, MyEntity3092PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3092PickPickDTO> doCreateEntity(MyEntity3092Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3092PickPickDTO> doUpdateEntity(MyEntity3092Pick entity, MyEntity3092PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}