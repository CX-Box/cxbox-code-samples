package org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3624PickService extends VersionAwareResponseService<MyEntity3624PickDTO, org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624> {

    public MyEntity3624PickService() {
        super(MyEntity3624PickDTO.class, org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624.class, null, MyEntity3624PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3624PickDTO> doCreateEntity(org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3624PickDTO> doUpdateEntity(org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624 entity, MyEntity3624PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}