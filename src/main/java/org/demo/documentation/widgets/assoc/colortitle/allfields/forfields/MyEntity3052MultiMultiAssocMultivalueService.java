package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3052MultiMultiAssocMultivalueService extends VersionAwareResponseService<MyEntity3052MultiMultiAssocMultivalueDTO, MyEntity3052MultiMultiAssoc> {

    public MyEntity3052MultiMultiAssocMultivalueService() {
        super(MyEntity3052MultiMultiAssocMultivalueDTO.class, MyEntity3052MultiMultiAssoc.class, null, MyEntity3052MultiMultiAssocMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3052MultiMultiAssocMultivalueDTO> doCreateEntity(MyEntity3052MultiMultiAssoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052MultiMultiAssocMultivalueDTO> doUpdateEntity(MyEntity3052MultiMultiAssoc entity, MyEntity3052MultiMultiAssocMultivalueDTO data,
                                                                                       BusinessComponent bc) {
        return null;
    }


}