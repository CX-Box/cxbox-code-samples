package org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3625PickService extends VersionAwareResponseService<MyEntity3625PickDTO, org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625> {

    public MyEntity3625PickService() {
        super(MyEntity3625PickDTO.class, org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625.class, null, MyEntity3625PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3625PickDTO> doCreateEntity(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3625PickDTO> doUpdateEntity(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity, MyEntity3625PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}