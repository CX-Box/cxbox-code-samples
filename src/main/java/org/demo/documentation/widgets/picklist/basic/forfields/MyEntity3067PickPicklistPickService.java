package org.demo.documentation.widgets.picklist.basic.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3067PickPicklistPickService extends VersionAwareResponseService<MyEntity3067PickPicklistPickDTO, MyEntity3067PickPicklist> {

    public MyEntity3067PickPicklistPickService() {
        super(MyEntity3067PickPicklistPickDTO.class, MyEntity3067PickPicklist.class, null, MyEntity3067PickPicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067PickPicklistPickDTO> doCreateEntity(MyEntity3067PickPicklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067PickPicklistPickDTO> doUpdateEntity(MyEntity3067PickPicklist entity, MyEntity3067PickPicklistPickDTO data,
                                                                              BusinessComponent bc) {
        return null;
    }


}