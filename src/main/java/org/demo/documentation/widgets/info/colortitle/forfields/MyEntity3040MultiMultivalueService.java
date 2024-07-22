package org.demo.documentation.widgets.info.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3040MultiMultivalueService extends VersionAwareResponseService<MyEntity3040MultiMultivalueDTO, org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi> {

    public MyEntity3040MultiMultivalueService() {
        super(MyEntity3040MultiMultivalueDTO.class, org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi.class, null, MyEntity3040MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3040MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3040MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi entity, MyEntity3040MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}