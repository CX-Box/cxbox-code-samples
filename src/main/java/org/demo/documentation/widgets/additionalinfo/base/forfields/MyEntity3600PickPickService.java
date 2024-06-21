package org.demo.documentation.widgets.additionalinfo.base.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3600PickPickService extends VersionAwareResponseService<MyEntity3600PickPickDTO, MyEntity3600Pick> {

    public MyEntity3600PickPickService() {
        super(MyEntity3600PickPickDTO.class, MyEntity3600Pick.class, null, MyEntity3600PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3600PickPickDTO> doCreateEntity(MyEntity3600Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3600PickPickDTO> doUpdateEntity(MyEntity3600Pick entity, MyEntity3600PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}