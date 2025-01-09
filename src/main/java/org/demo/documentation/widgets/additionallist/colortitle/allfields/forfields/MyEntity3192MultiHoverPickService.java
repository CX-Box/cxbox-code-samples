package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3192MultiHoverPickService extends VersionAwareResponseService<MyEntity3192MultiHoverPickDTO, MyEntity3192MultiHover> {

    public MyEntity3192MultiHoverPickService() {
        super(MyEntity3192MultiHoverPickDTO.class, MyEntity3192MultiHover.class, null, MyEntity3192MultiHoverPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3192MultiHoverPickDTO> doCreateEntity(MyEntity3192MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3192MultiHoverPickDTO> doUpdateEntity(MyEntity3192MultiHover entity, MyEntity3192MultiHoverPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}