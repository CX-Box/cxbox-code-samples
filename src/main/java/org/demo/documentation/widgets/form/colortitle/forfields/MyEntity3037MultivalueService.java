package org.demo.documentation.widgets.form.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3037MultivalueService extends VersionAwareResponseService<MyEntity3037MultivalueDTO, org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037> {

    public MyEntity3037MultivalueService() {
        super(MyEntity3037MultivalueDTO.class, org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037.class, null, MyEntity3037MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3037MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3037MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037 entity, MyEntity3037MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}