package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3043PickService extends VersionAwareResponseService<MyEntity3043PickDTO, MyEntity3043> {

    public MyEntity3043PickService() {
        super(MyEntity3043PickDTO.class, MyEntity3043.class, null, MyEntity3043PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3043PickDTO> doCreateEntity(MyEntity3043 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3043PickDTO> doUpdateEntity(MyEntity3043 entity, MyEntity3043PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}