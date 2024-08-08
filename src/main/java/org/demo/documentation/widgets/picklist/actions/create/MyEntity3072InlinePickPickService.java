package org.demo.documentation.widgets.picklist.actions.create;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3072InlinePickPickService extends VersionAwareResponseService<MyEntity3072InlinePickPickDTO, MyEntity3072InlinePick> {

    public MyEntity3072InlinePickPickService() {
        super(MyEntity3072InlinePickPickDTO.class, MyEntity3072InlinePick.class, null, MyEntity3072InlinePickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3072InlinePickPickDTO> doCreateEntity(MyEntity3072InlinePick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3072InlinePickPickDTO> doUpdateEntity(MyEntity3072InlinePick entity, MyEntity3072InlinePickPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}