package org.demo.documentation.widgets.picklist.color.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3061MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3061MultiMultiMultivalueDTO, org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061MultiMulti> {

    public MyEntity3061MultiMultiMultivalueService() {
        super(MyEntity3061MultiMultiMultivalueDTO.class, org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061MultiMulti.class, null, MyEntity3061MultiMultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3061MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061MultiMulti entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061MultiMulti entity, MyEntity3061MultiMultiMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}