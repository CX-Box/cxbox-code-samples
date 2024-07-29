package org.demo.documentation.widgets.picklist.basic.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3067MultiMultivalueService extends VersionAwareResponseService<MyEntity3067MultiMultivalueDTO, org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi> {

    public MyEntity3067MultiMultivalueService() {
        super(MyEntity3067MultiMultivalueDTO.class, org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi.class, null, MyEntity3067MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi entity, MyEntity3067MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}