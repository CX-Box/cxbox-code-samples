package org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3865PickPickService extends VersionAwareResponseService<MyEntity3865PickPickDTO, MyEntity3865Pick> {

    public MyEntity3865PickPickService() {
        super(MyEntity3865PickPickDTO.class, MyEntity3865Pick.class, null, MyEntity3865PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3865PickPickDTO> doCreateEntity(MyEntity3865Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3865PickPickDTO> doUpdateEntity(MyEntity3865Pick entity, MyEntity3865PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}