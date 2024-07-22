package org.demo.documentation.widgets.assoc.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3052PicklistPickService extends VersionAwareResponseService<MyEntity3052PicklistPickDTO, MyEntity3052Picklist> {

    public MyEntity3052PicklistPickService() {
        super(MyEntity3052PicklistPickDTO.class, MyEntity3052Picklist.class, null, MyEntity3052PicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3052PicklistPickDTO> doCreateEntity(MyEntity3052Picklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052PicklistPickDTO> doUpdateEntity(MyEntity3052Picklist entity, MyEntity3052PicklistPickDTO data,
                                                                          BusinessComponent bc) {
        return null;
    }


}