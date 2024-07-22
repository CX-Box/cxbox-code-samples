package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3042MultivalueService extends VersionAwareResponseService<MyEntity3042MultivalueDTO, org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042> {

    public MyEntity3042MultivalueService() {
        super(MyEntity3042MultivalueDTO.class, org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042.class, null, MyEntity3042MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3042MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3042MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042 entity, MyEntity3042MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}