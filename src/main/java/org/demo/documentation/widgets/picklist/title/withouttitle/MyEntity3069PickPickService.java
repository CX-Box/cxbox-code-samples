package org.demo.documentation.widgets.picklist.title.withouttitle;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3069PickPickService extends VersionAwareResponseService<MyEntity3069PickPickDTO, MyEntity3069Pick> {

    public MyEntity3069PickPickService() {
        super(MyEntity3069PickPickDTO.class, MyEntity3069Pick.class, null, MyEntity3069PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3069PickPickDTO> doCreateEntity(MyEntity3069Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3069PickPickDTO> doUpdateEntity(MyEntity3069Pick entity, MyEntity3069PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}