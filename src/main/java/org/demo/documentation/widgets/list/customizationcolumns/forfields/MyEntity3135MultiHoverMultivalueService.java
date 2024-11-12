package org.demo.documentation.widgets.list.customizationcolumns.forfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity3135MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3135MultiHoverMultivalueDTO, MyEntity3135MultiHover> {

    public MyEntity3135MultiHoverMultivalueService() {
        super(MyEntity3135MultiHoverMultivalueDTO.class, MyEntity3135MultiHover.class, null, MyEntity3135MultiHoverMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3135MultiHoverMultivalueDTO> doCreateEntity(MyEntity3135MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135MultiHoverMultivalueDTO> doUpdateEntity(MyEntity3135MultiHover entity, MyEntity3135MultiHoverMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}