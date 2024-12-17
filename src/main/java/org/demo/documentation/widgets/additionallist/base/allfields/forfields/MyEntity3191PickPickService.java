package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3191PickPickService extends VersionAwareResponseService<MyEntity3191PickPickDTO, MyEntity3191Pick> {

    public MyEntity3191PickPickService() {
        super(MyEntity3191PickPickDTO.class, MyEntity3191Pick.class, null, MyEntity3191PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3191PickPickDTO> doCreateEntity(MyEntity3191Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3191PickPickDTO> doUpdateEntity(MyEntity3191Pick entity, MyEntity3191PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}