package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3073PickPickService extends VersionAwareResponseService<MyEntity3073PickPickDTO, MyEntity3073Pick> {

    public MyEntity3073PickPickService() {
        super(MyEntity3073PickPickDTO.class, MyEntity3073Pick.class, null, MyEntity3073PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3073PickPickDTO> doCreateEntity(MyEntity3073Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3073PickPickDTO> doUpdateEntity(MyEntity3073Pick entity, MyEntity3073PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}