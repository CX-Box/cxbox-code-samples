package org.demo.documentation.widgets.picklist.color.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3061MultiMultivalueService extends VersionAwareResponseService<MyEntity3061MultiMultivalueDTO, org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Multi> {

    public MyEntity3061MultiMultivalueService() {
        super(MyEntity3061MultiMultivalueDTO.class, org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Multi.class, null, MyEntity3061MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3061MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Multi entity, MyEntity3061MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}