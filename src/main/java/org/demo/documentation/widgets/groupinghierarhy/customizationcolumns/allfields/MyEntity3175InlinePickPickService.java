package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3175InlinePickPickService extends VersionAwareResponseService<MyEntity3175InlinePickPickDTO, MyEntity3175InlinePick> {

    public MyEntity3175InlinePickPickService() {
        super(MyEntity3175InlinePickPickDTO.class, MyEntity3175InlinePick.class, null, MyEntity3175InlinePickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3175InlinePickPickDTO> doCreateEntity(MyEntity3175InlinePick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3175InlinePickPickDTO> doUpdateEntity(MyEntity3175InlinePick entity, MyEntity3175InlinePickPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}