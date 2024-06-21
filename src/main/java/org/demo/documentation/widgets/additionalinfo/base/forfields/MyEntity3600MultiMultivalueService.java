package org.demo.documentation.widgets.additionalinfo.base.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3600MultiMultivalueService extends VersionAwareResponseService<MyEntity3600MultiMultivalueDTO, org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi> {

    public MyEntity3600MultiMultivalueService() {
        super(MyEntity3600MultiMultivalueDTO.class, org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi.class, null, MyEntity3600MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3600MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3600MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi entity, MyEntity3600MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}