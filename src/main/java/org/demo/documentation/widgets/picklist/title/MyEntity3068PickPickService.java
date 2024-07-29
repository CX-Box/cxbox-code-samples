package org.demo.documentation.widgets.picklist.title;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3068PickPickService extends VersionAwareResponseService<MyEntity3068PickPickDTO, MyEntity3068Pick> {

    public MyEntity3068PickPickService() {
        super(MyEntity3068PickPickDTO.class, MyEntity3068Pick.class, null, MyEntity3068PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3068PickPickDTO> doCreateEntity(MyEntity3068Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3068PickPickDTO> doUpdateEntity(MyEntity3068Pick entity, MyEntity3068PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}