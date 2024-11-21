package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3202PickPickService extends VersionAwareResponseService<MyEntity3202PickPickDTO, MyEntity3202Pick> {

    public MyEntity3202PickPickService() {
        super(MyEntity3202PickPickDTO.class, MyEntity3202Pick.class, null, MyEntity3202PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3202PickPickDTO> doCreateEntity(MyEntity3202Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3202PickPickDTO> doUpdateEntity(MyEntity3202Pick entity, MyEntity3202PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}