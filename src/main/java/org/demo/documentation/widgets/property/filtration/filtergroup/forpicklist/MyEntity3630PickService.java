package org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3630PickService extends VersionAwareResponseService<MyEntity3630PickDTO, MyEntity3630> {

    public MyEntity3630PickService() {
        super(MyEntity3630PickDTO.class, MyEntity3630.class, null, MyEntity3630PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3630PickDTO> doCreateEntity(MyEntity3630 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3630PickDTO> doUpdateEntity(MyEntity3630 entity, MyEntity3630PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}