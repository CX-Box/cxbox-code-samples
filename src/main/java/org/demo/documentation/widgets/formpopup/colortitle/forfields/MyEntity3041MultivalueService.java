package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3041MultivalueService extends VersionAwareResponseService<MyEntity3041MultivalueDTO, org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041> {

    public MyEntity3041MultivalueService() {
        super(MyEntity3041MultivalueDTO.class, org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041.class, null, MyEntity3041MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3041MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3041MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041 entity, MyEntity3041MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}