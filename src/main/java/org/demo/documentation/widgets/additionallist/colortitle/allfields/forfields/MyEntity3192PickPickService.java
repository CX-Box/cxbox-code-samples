package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3192PickPickService extends VersionAwareResponseService<MyEntity3192PickPickDTO, MyEntity3192Pick> {

    public MyEntity3192PickPickService() {
        super(MyEntity3192PickPickDTO.class, MyEntity3192Pick.class, null, MyEntity3192PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3192PickPickDTO> doCreateEntity(MyEntity3192Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3192PickPickDTO> doUpdateEntity(MyEntity3192Pick entity, MyEntity3192PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}