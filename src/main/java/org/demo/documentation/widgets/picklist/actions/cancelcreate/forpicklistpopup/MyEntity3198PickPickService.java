package org.demo.documentation.widgets.picklist.actions.cancelcreate.forpicklistpopup;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3198PickPickService extends VersionAwareResponseService<MyEntity3198PickPickDTO, MyEntity3198Pick> {

    public MyEntity3198PickPickService() {
        super(MyEntity3198PickPickDTO.class, MyEntity3198Pick.class, null, MyEntity3198PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3198PickPickDTO> doCreateEntity(MyEntity3198Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3198PickPickDTO> doUpdateEntity(MyEntity3198Pick entity, MyEntity3198PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}