package org.demo.documentation.widgets.picklist.customizationcolumns;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3089PickPickService extends VersionAwareResponseService<MyEntity3089PickPickDTO, MyEntity3089Pick> {

    public MyEntity3089PickPickService() {
        super(MyEntity3089PickPickDTO.class, MyEntity3089Pick.class, null, MyEntity3089PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3089PickPickDTO> doCreateEntity(MyEntity3089Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3089PickPickDTO> doUpdateEntity(MyEntity3089Pick entity, MyEntity3089PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}