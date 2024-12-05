package org.demo.documentation.widgets.property.excel.inner.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3134InlinePickPickService extends VersionAwareResponseService<MyEntity3134InlinePickPickDTO, MyEntity3134InlinePick> {

    public MyEntity3134InlinePickPickService() {
        super(MyEntity3134InlinePickPickDTO.class, MyEntity3134InlinePick.class, null, MyEntity3134InlinePickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3134InlinePickPickDTO> doCreateEntity(MyEntity3134InlinePick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134InlinePickPickDTO> doUpdateEntity(MyEntity3134InlinePick entity, MyEntity3134InlinePickPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}