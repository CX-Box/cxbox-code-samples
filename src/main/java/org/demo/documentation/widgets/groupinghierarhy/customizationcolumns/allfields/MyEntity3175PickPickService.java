package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3175PickPickService extends VersionAwareResponseService<MyEntity3175PickPickDTO, MyEntity3175Pick> {

    public MyEntity3175PickPickService() {
        super(MyEntity3175PickPickDTO.class, MyEntity3175Pick.class, null, MyEntity3175PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3175PickPickDTO> doCreateEntity(MyEntity3175Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3175PickPickDTO> doUpdateEntity(MyEntity3175Pick entity, MyEntity3175PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}