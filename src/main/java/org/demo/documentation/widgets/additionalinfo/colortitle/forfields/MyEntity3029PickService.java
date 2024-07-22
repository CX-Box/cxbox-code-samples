package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

import lombok.Getter;
import org.demo.documentation.widgets.additionalinfo.colortitle.MyEntity3029;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3029PickService extends VersionAwareResponseService<MyEntity3029PickDTO, MyEntity3029> {

    public MyEntity3029PickService() {
        super(MyEntity3029PickDTO.class, MyEntity3029.class, null, MyEntity3029PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3029PickDTO> doCreateEntity(MyEntity3029 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3029PickDTO> doUpdateEntity(MyEntity3029 entity, MyEntity3029PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}