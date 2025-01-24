package org.demo.documentation.widgets.picklist.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3067PickInlinePicklistPickService extends VersionAwareResponseService<MyEntity3067PickInlinePicklistPickDTO, MyEntity3067PickInlinePicklist> {

    public MyEntity3067PickInlinePicklistPickService() {
        super(MyEntity3067PickInlinePicklistPickDTO.class, MyEntity3067PickInlinePicklist.class, null, MyEntity3067PickInlinePicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067PickInlinePicklistPickDTO> doCreateEntity(MyEntity3067PickInlinePicklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067PickInlinePicklistPickDTO> doUpdateEntity(MyEntity3067PickInlinePicklist entity, MyEntity3067PickInlinePicklistPickDTO data,
                                                                                    BusinessComponent bc) {
        return null;
    }


}