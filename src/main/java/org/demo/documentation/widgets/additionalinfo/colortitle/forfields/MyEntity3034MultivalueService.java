package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3034MultivalueService extends VersionAwareResponseService<MyEntity3034MultivalueDTO, org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3034> {

    public MyEntity3034MultivalueService() {
        super(MyEntity3034MultivalueDTO.class, org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3034.class, null, MyEntity3034MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3034MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3034 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3034MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3034 entity, MyEntity3034MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}