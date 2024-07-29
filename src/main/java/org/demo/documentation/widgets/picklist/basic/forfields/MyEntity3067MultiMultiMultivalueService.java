package org.demo.documentation.widgets.picklist.basic.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3067MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3067MultiMultiMultivalueDTO, MyEntity3067MultiMulti> {

    public MyEntity3067MultiMultiMultivalueService() {
        super(MyEntity3067MultiMultiMultivalueDTO.class, MyEntity3067MultiMulti.class, null, MyEntity3067MultiMultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067MultiMultiMultivalueDTO> doCreateEntity(MyEntity3067MultiMulti entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067MultiMultiMultivalueDTO> doUpdateEntity(MyEntity3067MultiMulti entity, MyEntity3067MultiMultiMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}