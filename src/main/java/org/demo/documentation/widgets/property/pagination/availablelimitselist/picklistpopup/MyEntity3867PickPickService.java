package org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3867PickPickService extends VersionAwareResponseService<MyEntity3867PickPickDTO, MyEntity3867Pick> {

    public MyEntity3867PickPickService() {
        super(MyEntity3867PickPickDTO.class, MyEntity3867Pick.class, null, MyEntity3867PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3867PickPickDTO> doCreateEntity(MyEntity3867Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3867PickPickDTO> doUpdateEntity(MyEntity3867Pick entity, MyEntity3867PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}