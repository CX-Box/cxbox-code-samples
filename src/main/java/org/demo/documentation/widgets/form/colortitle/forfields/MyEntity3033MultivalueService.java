package org.demo.documentation.widgets.form.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3033MultivalueService extends VersionAwareResponseService<MyEntity3033MultivalueDTO, MyEntity3033> {

    public MyEntity3033MultivalueService() {
        super(MyEntity3033MultivalueDTO.class, MyEntity3033.class, null, MyEntity3033MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3033MultivalueDTO> doCreateEntity(MyEntity3033 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3033MultivalueDTO> doUpdateEntity(MyEntity3033 entity, MyEntity3033MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}