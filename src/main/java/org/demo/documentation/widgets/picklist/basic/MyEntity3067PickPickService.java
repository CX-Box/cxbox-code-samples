package org.demo.documentation.widgets.picklist.basic;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3067PickPickService extends VersionAwareResponseService<MyEntity3067PickPickDTO, MyEntity3067Pick> {

    public MyEntity3067PickPickService() {
        super(MyEntity3067PickPickDTO.class, MyEntity3067Pick.class, null, MyEntity3067PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067PickPickDTO> doCreateEntity(MyEntity3067Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067PickPickDTO> doUpdateEntity(MyEntity3067Pick entity, MyEntity3067PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}