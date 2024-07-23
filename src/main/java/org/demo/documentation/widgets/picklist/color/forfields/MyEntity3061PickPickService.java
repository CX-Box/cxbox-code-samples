package org.demo.documentation.widgets.picklist.color.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3061PickPickService extends VersionAwareResponseService<MyEntity3061PickPickDTO, MyEntity3061Pick> {

    public MyEntity3061PickPickService() {
        super(MyEntity3061PickPickDTO.class, MyEntity3061Pick.class, null, MyEntity3061PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3061PickPickDTO> doCreateEntity(MyEntity3061Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061PickPickDTO> doUpdateEntity(MyEntity3061Pick entity, MyEntity3061PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}