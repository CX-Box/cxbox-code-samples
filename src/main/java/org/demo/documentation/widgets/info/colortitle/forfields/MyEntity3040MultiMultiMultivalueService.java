package org.demo.documentation.widgets.info.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3040MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3040MultiMultiMultivalueDTO, org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti> {

    public MyEntity3040MultiMultiMultivalueService() {
        super(MyEntity3040MultiMultiMultivalueDTO.class, org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti.class, null, MyEntity3040MultiMultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3040MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3040MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti entity, MyEntity3040MultiMultiMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}