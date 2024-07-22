package org.demo.documentation.widgets.picklist.color;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3061PickService extends VersionAwareResponseService<MyEntity3061PickDTO, MyEntity3061> {

    public MyEntity3061PickService() {
        super(MyEntity3061PickDTO.class, MyEntity3061.class, null, MyEntity3061PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3061PickDTO> doCreateEntity(MyEntity3061 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061PickDTO> doUpdateEntity(MyEntity3061 entity, MyEntity3061PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}