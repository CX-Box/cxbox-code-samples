package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3035MultivalueService extends VersionAwareResponseService<MyEntity3035MultivalueDTO, org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035> {

    public MyEntity3035MultivalueService() {
        super(MyEntity3035MultivalueDTO.class, org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035.class, null, MyEntity3035MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3035MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3035MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035 entity, MyEntity3035MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}