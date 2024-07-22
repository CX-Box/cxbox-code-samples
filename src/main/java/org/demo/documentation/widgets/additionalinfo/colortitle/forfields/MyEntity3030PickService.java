package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

import lombok.Getter;
import org.demo.documentation.widgets.additionalinfo.colortitle.MyEntity3030;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3030PickService extends VersionAwareResponseService<MyEntity3030PickDTO, MyEntity3030> {

    public MyEntity3030PickService() {
        super(MyEntity3030PickDTO.class, MyEntity3030.class, null, MyEntity3030PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3030PickDTO> doCreateEntity(MyEntity3030 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3030PickDTO> doUpdateEntity(MyEntity3030 entity, MyEntity3030PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}