package org.demo.documentation.widgets.formpopup.base.onefield.forfields.fa;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3400InlinePicklistFAPickService extends VersionAwareResponseService<MyEntity3400InlinePicklistFAPickDTO, MyEntity3400InlinePicklistFA> {

    public MyEntity3400InlinePicklistFAPickService() {
        super(MyEntity3400InlinePicklistFAPickDTO.class, MyEntity3400InlinePicklistFA.class, null, MyEntity3400InlinePicklistFAPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3400InlinePicklistFAPickDTO> doCreateEntity(MyEntity3400InlinePicklistFA entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3400InlinePicklistFAPickDTO> doUpdateEntity(MyEntity3400InlinePicklistFA entity, MyEntity3400InlinePicklistFAPickDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}