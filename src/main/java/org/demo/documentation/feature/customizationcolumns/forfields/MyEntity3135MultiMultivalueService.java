package org.demo.documentation.feature.customizationcolumns.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3135MultiMultivalueService extends VersionAwareResponseService<MyEntity3135MultiMultivalueDTO, org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135Multi> {

    public MyEntity3135MultiMultivalueService() {
        super(MyEntity3135MultiMultivalueDTO.class, org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135Multi.class, null, MyEntity3135MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3135MultiMultivalueDTO> doCreateEntity(org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135Multi entity, MyEntity3135MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}