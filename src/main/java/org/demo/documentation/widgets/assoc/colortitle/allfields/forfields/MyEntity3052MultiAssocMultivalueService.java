package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3052MultiAssocMultivalueService extends VersionAwareResponseService<MyEntity3052MultiAssocMultivalueDTO, MyEntity3052MultiAssoc> {

    public MyEntity3052MultiAssocMultivalueService() {
        super(MyEntity3052MultiAssocMultivalueDTO.class, MyEntity3052MultiAssoc.class, null, MyEntity3052MultiAssocMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3052MultiAssocMultivalueDTO> doCreateEntity(MyEntity3052MultiAssoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052MultiAssocMultivalueDTO> doUpdateEntity(MyEntity3052MultiAssoc entity, MyEntity3052MultiAssocMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}