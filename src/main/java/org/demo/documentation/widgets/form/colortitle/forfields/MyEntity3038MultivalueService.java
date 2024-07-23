package org.demo.documentation.widgets.form.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3038MultivalueService extends VersionAwareResponseService<MyEntity3038MultivalueDTO, org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038> {

    public MyEntity3038MultivalueService() {
        super(MyEntity3038MultivalueDTO.class, org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038.class, null, MyEntity3038MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3038MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3038MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038 entity, MyEntity3038MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}