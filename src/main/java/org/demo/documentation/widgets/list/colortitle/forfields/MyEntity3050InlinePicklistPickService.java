package org.demo.documentation.widgets.list.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3050InlinePicklistPickService extends VersionAwareResponseService<MyEntity3050InlinePicklistPickDTO, MyEntity3050InlinePicklist> {

    public MyEntity3050InlinePicklistPickService() {
        super(MyEntity3050InlinePicklistPickDTO.class, MyEntity3050InlinePicklist.class, null, MyEntity3050InlinePicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3050InlinePicklistPickDTO> doCreateEntity(MyEntity3050InlinePicklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3050InlinePicklistPickDTO> doUpdateEntity(MyEntity3050InlinePicklist entity, MyEntity3050InlinePicklistPickDTO data,
                                                                                BusinessComponent bc) {
        return null;
    }


}