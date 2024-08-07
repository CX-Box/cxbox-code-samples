package org.demo.documentation.feature.customizationcolumns.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3135MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3135MultiHoverMultivalueDTO, org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiHover> {

    public MyEntity3135MultiHoverMultivalueService() {
        super(MyEntity3135MultiHoverMultivalueDTO.class, org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiHover.class, null, MyEntity3135MultiHoverMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3135MultiHoverMultivalueDTO> doCreateEntity(org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135MultiHoverMultivalueDTO> doUpdateEntity(org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiHover entity, MyEntity3135MultiHoverMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}