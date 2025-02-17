package org.demo.documentation.widgets.formpopup.base.onefield.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3400InlinePicklistPickService extends VersionAwareResponseService<MyEntity3400InlinePicklistPickDTO, MyEntity3400InlinePicklist> {

    public MyEntity3400InlinePicklistPickService() {
        super(MyEntity3400InlinePicklistPickDTO.class, MyEntity3400InlinePicklist.class, null, MyEntity3400InlinePicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3400InlinePicklistPickDTO> doCreateEntity(MyEntity3400InlinePicklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3400InlinePicklistPickDTO> doUpdateEntity(MyEntity3400InlinePicklist entity, MyEntity3400InlinePicklistPickDTO data,
                                                                                BusinessComponent bc) {
        return null;
    }


}