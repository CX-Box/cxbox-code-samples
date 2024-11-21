package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3202MultiHoverPickService extends VersionAwareResponseService<MyEntity3202MultiHoverPickDTO, MyEntity3202MultiHover> {

    public MyEntity3202MultiHoverPickService() {
        super(MyEntity3202MultiHoverPickDTO.class, MyEntity3202MultiHover.class, null, MyEntity3202MultiHoverPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3202MultiHoverPickDTO> doCreateEntity(MyEntity3202MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3202MultiHoverPickDTO> doUpdateEntity(MyEntity3202MultiHover entity, MyEntity3202MultiHoverPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}